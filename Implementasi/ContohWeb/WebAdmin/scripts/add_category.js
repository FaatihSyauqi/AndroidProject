
var categoryDayaSection = document.getElementById('categorydata');

var frmCategoryName	 = document.querySelector('#frmCategoryName');
var frmImage		 = document.querySelector('#frmImage');

var logoutButton	 = document.getElementById('logoutBtn');

var listeningFirebaseRefs 	= [];
var currentUID;

function showNotif(messageText, elementNotif){
	$.notify({
		// options
		message: messageText 
		},{
		// settings
		type: elementNotif,
		timer: 1000,
		placement: {
			from: 'bottom',
			align: 'right'
		}
	});
}

function cleanupUi() {
	categoryDayaSection.style = "display:none";
	
	listeningFirebaseRefs.forEach(function (ref) {
		ref.off();
	});
	listeningFirebaseRefs = [];
}

function onAuthStateChanged(user) {
	
	cleanupUi();
	if (user) {
		categoryDayaSection.style = "display:block";
		
		if (user && currentUID === user.uid || !user && currentUID === null) {
			return;
		}
		currentUID = user ? user.uid : null;
		
	} 
	else{
		window.location.href = "sign-in";
	}
}

function AddDataPost(txtCategoryName, file) {
	
	
	var metadata = {
		contentType: file.type,
	};
	
	var keyA = firebase.database().ref().child("categories").push().getKey();
	var uploadTask = firebase.storage().ref('icon/'+file.name.replace(' ','_')).put(file, metadata);
	
	uploadTask.on('state_changed', function(snapshot){
		
	}, 
	function(error) {
		showNotif('Error:'+error,'danger');
	}, 
	function() {
		showNotif('Icon upload successfull','success');
		var downloadURL = uploadTask.snapshot.downloadURL;
		
		frmImage.value = '';
	});
	
	
	return firebase.database().ref().child("categories/"+keyA).set({
		categoryName: txtCategoryName,
		iconFileName: file.name.replace(' ','_')
	});
	
}

window.addEventListener('load', function(){
	
	logoutButton.addEventListener('click', function () {
		firebase.auth().signOut();
		location.reload();
		showNotif('Thank You, See You Nextime!','info');
	});
	
	
	saveForm.onsubmit = function(e){
		e.preventDefault();
		var txtCategoryName		= frmCategoryName.value;
		
		var file = document.forms['svForm']['fImage'].files[0];
		
		if(txtCategoryName && file){
			var ext = file.name.split('.').pop();
			console.log(ext);
			if(ext=="png" || ext=="jpg" || ext=="jpeg"){
				AddDataPost(txtCategoryName, file);
			
				showNotif('Data saved!','success');
				
				setTimeout(function () {
					window.location = "categories";
				}, 2000);
			}
			else{
				showNotif('File type not allowed.','danger')
			}
		}
		else{
			showNotif('Category Name and Image Icon must not be null','danger');
		}
	}
	
	firebase.auth().onAuthStateChanged(onAuthStateChanged);
	
}, false);
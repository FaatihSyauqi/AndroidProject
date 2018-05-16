
var titlePage = document.getElementById('titlePage');


var allCategorySection	= document.getElementById('allcategories');
var categoryDataSection	= document.getElementById('categorydata');

var saveForm		 	= document.getElementById('saveForm');

var logoutButton	 = document.getElementById('logoutBtn');

var loading			 = document.getElementById('loading');

var imgIcon		 = document.querySelector('#imgIcon');

var frmImage		 = document.querySelector('#frmImage');

var frmCategoryName	 = document.querySelector('#frmCategoryName');

var listeningFirebaseRefs 	= [];
var currentUID;

function getQueryVariable(variable) {
	var query = window.location.search.substring(1);
	var vars = query.split("&");
	for (var i = 0; i < vars.length; i++) {
		var pair = vars[i].split("=");
		if (pair[0] == variable) {
			return pair[1];
		}
	}
	return (false);
}

function createCategoryElement(key, categoryName, iconFileName){
	var html = 
	
	'<div class="col-sm-4"><div class="card"><div class="media">'+
	'<div class="media-left">'+
	'<a href="#" class="link-title">'+
	'<img class="iconImage media-object" style="background-color:#bbbbbb" src="" width="64" height="64">'+
	'</a>'+
	'</div>'+
	'<div class="media-body"><div class="col-sm-10"><h5 style="margin:auto;position:absolute;left:0;top:18px;"><a href="#" class="catName"></a></h5></div><div class="col-sm-2"><a href="#" class="del-cat" style="position: absolute;right: 0px;top:16px;"><i class="material-icons">delete_forever</i></a></div></div>'+
	'</div></div></div>';
	
	
	var div = document.createElement('div');
	div.innerHTML = html;
	var menuElement = div.firstChild;
	
	var linkImg = STORAGE_URL+"icon%2F"+iconFileName+"?alt=media";
	
	menuElement.getElementsByClassName('iconImage')[0].src = linkImg;
	menuElement.getElementsByClassName('link-title')[0].href = "?cat_show="+key;
	menuElement.getElementsByClassName('del-cat')[0].href = "#"+key;
	menuElement.getElementsByClassName('del-cat')[0].addEventListener('click', function(){
		deleteCategory(key);
	});
	menuElement.getElementsByClassName('catName')[0].innerHTML = categoryName;
	menuElement.getElementsByClassName('catName')[0].href = "?cat_show="+key;
	
	return menuElement;
}

function showAllCategories(){
	var catRef = firebase.database().ref('categories');
	var fetchData = function(ref, section){
		ref.on('child_added', function(data){
			
			var content = section.getElementsByClassName('category-list')[0];
			content.insertBefore(
			createCategoryElement(data.key, data.val().categoryName, data.val().iconFileName),
			content.firstChild);
		});
	};
	
	loading.style = "display:none";
	
	fetchData(catRef, allCategorySection);
	// Keep track of all Firebase refs we are listening to.
	listeningFirebaseRefs.push(catRef);
}

function showCategory(idCategory){
	
	var dataRef = firebase.database().ref('categories/'+idCategory);
	
	var fetchData = function(ref, section){
		ref.on('value', function(data){
			var linkImg = STORAGE_URL+"icon%2F"+data.val().iconFileName+"?alt=media";
			
			frmCategoryName.value 	= data.val().categoryName;
			imgIcon.src = linkImg;
			
			loading.style = "display:none";
			categoryDataSection.style = "display:block";
			
		});
	};
	
	fetchData(dataRef, categoryDataSection);
	// Keep track of all Firebase refs we are listening to.
	listeningFirebaseRefs.push(dataRef);
	
}

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
	categoryDataSection.style = "display:none";
	allCategorySection.getElementsByClassName('category-list')[0].innerHTML = "";
	
	listeningFirebaseRefs.forEach(function (ref) {
		ref.off();
	});
	listeningFirebaseRefs = [];
}

function onAuthStateChanged(user) {
	var showId = getQueryVariable('cat_show');
	
	cleanupUi();
	
	if(user){
		
		if(showId){
			showCategory(showId);
			allCategorySection.style = "display:none";
			titlePage.href = "categories";
			
		}
		else{
			showAllCategories();
			titlePage.href = "home";
			
		}
		
		if (user && currentUID === user.uid || !user && currentUID === null) {
			return;
		}
		currentUID = user ? user.uid : null;
	}
	else{
		window.location.href = "sign-in";
	}
}

function saveData(txtCategoryName, file){
	var currentCatID = getQueryVariable('cat_show');
	
	if(currentCatID){
		if(file){
			var metadata = {
				contentType: file.type,
			}
			
			var uploadTask = firebase.storage().ref('icon/'+file.name.replace(' ','_')).put(file, metadata);
			
			uploadTask.on('state_changed', function(snapshot){
				
				}, function(error){
				showNotif('Error:'+error,'danger');
				}, function(){
				showNotif('Icon successfully updated','success');
				var downloadURL = uploadTask.snapshot.downloadURL;
				imgIcon.src = downloadURL;
				frmImage.value = '';
			});
			
			return firebase.database().ref().child('categories/'+currentCatID).update({
				categoryName: txtCategoryName,
				iconFileName: file.name.replace(' ','_')
			});
		}
		else{
			return firebase.database().ref().child('categories/'+currentCatID).update({
				categoryName: txtCategoryName
			});
		}
	}
}

function deleteCategory(delcat){
	if(delcat){
		var delRefRev = firebase.database().ref('categories/'+delcat);
		
		
		swal({
			title: "Are you sure?",
			text: "You will not be able to recover!",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: false
		}, 
		function () {
			
			
			
			delRefRev.remove(function(error){
				if(!error){
					swal("Deleted!", "The category has been deleted!", "success");
					
					setTimeout(function () {
						window.location.href = "categories";
					}, 2000);
				}
			});
			
		});
		
	}
}


window.addEventListener('load', function(){
	
	logoutButton.addEventListener('click', function () {
		firebase.auth().signOut();
		location.reload();
		showNotif('Thank You, See You Nextime!','info');
	});
	
	saveForm.onsubmit = function(e){
		e.preventDefault();
		var txtCategoryName	= frmCategoryName.value;
		
		var file = document.forms['svForm']['fImage'].files[0];
		
		if(txtCategoryName){
			if(file){
				var ext = file.name.split('.').pop();
				console.log(ext);
				if(ext=="png" || ext=="jpg" || ext=="jpeg"){
					saveData(txtCategoryName, file);
					}else{
					showNotif('File type not allowed.','danger')
				}
			}
			else{
				saveData(txtCategoryName, file);
				showNotif('Data saved!','success');
			}
		}
		else{
			showNotif('Category Name must not be null','danger');
		}
	}
	
	firebase.auth().onAuthStateChanged(onAuthStateChanged);
}, false);
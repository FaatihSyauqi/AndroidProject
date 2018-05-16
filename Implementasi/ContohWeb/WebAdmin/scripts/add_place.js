
var placeDataSection = document.getElementById('placedata');


var frmPlaceName	 = document.querySelector('#frmPlaceName');
var frmAddress		 = document.querySelector('#frmAddress');
var frmDescription	 = document.querySelector('#frmDescription');
var frmFacilities	 = document.querySelector('#frmFacilities');
var frmInfo			 = document.querySelector('#frmInfo');
var frmLatitude		 = document.querySelector('#frmLatitude');
var frmLongitude	 = document.querySelector('#frmLongitude');
var frmCategory		 = document.querySelector('#frmCategory');
var frmImage		 = document.querySelector('#frmImage');

var selectCategorySection = document.querySelector('#category-list');

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
	placeDataSection.style = "display:none";
	
	listeningFirebaseRefs.forEach(function (ref) {
		ref.off();
	});
	listeningFirebaseRefs = [];
}

function onAuthStateChanged(user) {
	
	cleanupUi();
	if (user) {
		placeDataSection.style = "display:block";
		showAllCategories();
		if (user && currentUID === user.uid || !user && currentUID === null) {
			return;
		}
		currentUID = user ? user.uid : null;
		
	} 
	else{
		window.location.href = "sign-in";
	}
}

function showAllCategories(){
	var catRef = firebase.database().ref('categories');
	var fetchData = function(ref, section){
		ref.on('child_added', function(data){
			
			var content = section.getElementsByClassName('category-data')[0];
			content.insertBefore(
			createSelectElement(data.key, data.val().categoryName),
			content.firstChild);
			
		});
	};
	
	fetchData(catRef, selectCategorySection);
	// Keep track of all Firebase refs we are listening to.
	listeningFirebaseRefs.push(catRef);
}


function createSelectElement(key, categoryName){
	var html = 
	'<div class="col-sm-6"><input class="cat" type="checkbox"/>'+
	'<label class="cat-name"></label></div>';
	
	var div = document.createElement('div');
	div.innerHTML = html;
	var selectElement = div.firstChild;
	
	selectElement.getElementsByClassName('cat')[0].id = key;
	selectElement.getElementsByClassName('cat')[0].value = key;
	selectElement.getElementsByClassName('cat-name')[0].setAttribute('for',key);
	selectElement.getElementsByClassName('cat-name')[0].innerHTML = categoryName;
	
	return selectElement;
}

function AddDataPost(txtPlaceName, txtAddress, txtDescription, txtFacilities, txtInfo, txtLatlong, file, txtCategory, ext) {
	
	var d = new Date();
	var f = d.getTime();
				
	var metadata = {
		contentType: file.type,
	};
	
	var keyA = firebase.database().ref().child("places").push().getKey();
	var uploadTask = firebase.storage().ref('gallery/'+keyA+'/IMG_'+f+'.'+ext).put(file, metadata);
	
	uploadTask.on('state_changed', function(snapshot){
		
	}, 
	function(error) {
		showNotif('Error:'+error,'danger');
	}, 
	function() {
		showNotif('Image upload successfull','success');
		var downloadURL = uploadTask.snapshot.downloadURL;
		
		frmImage.value = '';
	});
	
	addGallery(file, keyA, currentUID, f, ext);
	if(txtCategory){
		return firebase.database().ref().child("places/"+keyA).set({
			placeName 	: txtPlaceName,
			address		: txtAddress,
			description	: txtDescription,
			facilities	: txtFacilities,
			info		: txtInfo,
			latlong		: txtLatlong,
			category	: txtCategory,
			imageThumbnail: 'IMG_'+f+'.'+ext
		});
	}
	else{
		showNotif('Select 1 or more category', 'danger');
	}
	
	
}

function addGallery(file, currentPlaceId, currentUID, f, ext){
	var today = getToday();
	
	firebase.database().ref().child("gallery/"+currentUID+'/'+currentPlaceId).push().set({
		fileName: 'IMG_'+f+'.'+ext,
		timestamp: today
	});
}



function getToday(){
	
	var today = new Date();
	
	var dd = today.getUTCDate();
	var mm = today.getUTCMonth()+1; //January is 0!
	var yyyy = today.getUTCFullYear();
	var hh = today.getUTCHours();
	var m = today.getUTCMinutes();
	var s = today.getUTCSeconds();
	
	if(dd<10) {
		dd='0'+dd
	} 
	
	if(mm<10) {
		mm='0'+mm
	} 
	
	if(hh<10){
		hh='0'+hh
	}
	
	if(m<10){
		m='0'+m
	}
	
	if(s<10){
		s='0'+s
	}
	today = dd+'-'+mm+'-'+yyyy+' '+hh+':'+m+':'+s;
	return today;
}

window.addEventListener('load', function(){
	
	logoutButton.addEventListener('click', function () {
		firebase.auth().signOut();
		location.reload();
		showNotif('Thank You, See You Nextime!','info');
	});
	
	
	saveForm.onsubmit = function(e){
		e.preventDefault();
		var txtAddress		= frmAddress.value;
		var txtDescription	= frmDescription.value;
		var txtFacilities	= frmFacilities.value;
		var txtInfo			= frmInfo.value;
		var txtLatlong		= frmLatitude.value+","+frmLongitude.value;
		var txtPlaceName	= frmPlaceName.value;
		
		var file = document.forms['svForm']['fImage'].files[0];
		
		var checkedValue = "";
		
		firebase.database().ref('categories').on('child_added', function(data){
			if(document.querySelector('#'+data.getKey()).checked){
				checkedValue += document.querySelector('#'+data.getKey()).value + " ";
			}
		});
		
		var txtCategory = checkedValue.slice(0, -1) + '';
		
		
		if(txtPlaceName && frmLatitude.value && frmLongitude.value && file && txtCategory){
			var ext = file.name.split('.').pop();
			console.log(ext);
			if(ext=="png" || ext=="jpg" || ext=="jpeg"){
				AddDataPost(txtPlaceName, txtAddress, txtDescription, txtFacilities, txtInfo, txtLatlong, file, txtCategory, ext);
			
				showNotif('Data saved!','success');
				
				setTimeout(function () {
					window.location = "home";
				}, 2000);
			} 
			else{
				showNotif('File format not allowed!','danger');
			}	
		}
		else{
			showNotif('Place Name, Category, (Latitude,Longitude) must not null!','danger');
		}
	}
	
	firebase.auth().onAuthStateChanged(onAuthStateChanged);
	
}, false);
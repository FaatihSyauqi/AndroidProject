
var titlePage = document.getElementById('titlePage');
var linkHome = document.querySelector('#linkHome');
var iconHome = document.querySelector('#iconHome');

var allPlacesSection = document.getElementById('allplacedata');
var placeDataSection = document.getElementById('placedata');
var comenSec = document.getElementById('comenSec');

var menuCategorySection = document.getElementById('menuCategory');

var selectCategorySection = document.querySelector('#category-list');

var reviewsSection	 = document.querySelector('#reviews');
var gallerySection	 = document.querySelector('#gallery');

var saveForm		 = document.getElementById('saveForm');
var searchForm		 = document.getElementById('searchForm');

var frmSearch		 = document.querySelector('#frmSearch');

var tagImgThumb		 = document.querySelector('#imgThumb');
var frmPlaceName	 = document.querySelector('#frmPlaceName');
var frmAddress		 = document.querySelector('#frmAddress');
var frmDescription	 = document.querySelector('#frmDescription');
var frmFacilities	 = document.querySelector('#frmFacilities');
var frmInfo			 = document.querySelector('#frmInfo');
var frmLatitude		 = document.querySelector('#frmLatitude');
var frmLongitude	 = document.querySelector('#frmLongitude');
var frmCategory		 = document.querySelector('#frmCategory');
var frmImage		 = document.querySelector('#frmImage');

var logoutButton	 = document.getElementById('logoutBtn');

var loading			 = document.getElementById('loading');

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

function createMenuElement(key, categoryName, iconFileName){
	var html = 
	'<li>'+
	'<a class="linkmenu waves-effect waves-block">'+
	'<div class="icon-circle">'+
	'<img class="material-icons" height="24px" width="24px"/>'+
	'</div>'+
	'<div class="menu-info">'+
	'</div>'+
	'</a>'+
	'</li>';
	
	var div = document.createElement('div');
	div.innerHTML = html;
	var menuElement = div.firstChild;
	
	var linkImg = STORAGE_URL + "icon%2F"+iconFileName+"?alt=media";
	
	menuElement.getElementsByClassName('material-icons')[0].src = linkImg;
	menuElement.getElementsByClassName('linkmenu')[0].href = "?category="+key;
	menuElement.getElementsByClassName('menu-info')[0].innerHTML = categoryName;
	
	return menuElement;
}

function showMenuCategories(){
	var catRef = firebase.database().ref('categories');
	var fetchData = function(ref, section){
		ref.on('child_added', function(data){
			
			var content = section.getElementsByClassName('menu-list')[0];
			content.insertBefore(
			createMenuElement(data.key, data.val().categoryName, data.val().iconFileName),
			content.firstChild);
			
		});
	};
	
	fetchData(catRef, menuCategorySection);
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

function createAllPlacesElement(key, imageThumbnail, placeName, address){
	var html = 
	'<div class="col-sm-4"><div class="card">'+
	'<img class="imageThumbnail" src="" width="100%" height="170px"/>'+
	'<div class="header">'+
	'<a class="link-title" href=""><h2 class="placeName"></h2></a>'+
	'<ul class="header-dropdown m-r--5">'+
	'<li>'+
	'<a href="#" class="delete">'+
	'<i class="material-icons">delete_forever</i>'+
	'</a>'+
	'</li>'+
	
	'</ul></div>'+
	'<div class="body" style="height:100px"></div></div></div>';
	
	var div = document.createElement('div');
	div.innerHTML = html;
	var dataElement = div.firstChild;
	
	var linkImg = STORAGE_URL + "gallery%2F"+key+"%2F"+imageThumbnail+"?alt=media";
	dataElement.getElementsByClassName('imageThumbnail')[0].src = linkImg;
	dataElement.getElementsByClassName('placeName')[0].innerHTML = placeName;
	dataElement.getElementsByClassName('body')[0].innerHTML = address;
	dataElement.getElementsByClassName('link-title')[0].href = '?show='+key;
	
	dataElement.getElementsByClassName('delete')[0].href = '?del_place='+key;
	
	return dataElement;
}

function showAllPlaces(){
	
	var dataRef = firebase.database().ref('places');
	
	var fetchData = function(ref, section){
		ref.on('child_added', function(data){
			
			var content = section.getElementsByClassName('data-list')[0];
			content.insertBefore(
			createAllPlacesElement(data.key, data.val().imageThumbnail, data.val().placeName, data.val().address),
			content.firstChild);
			loading.style = "display:none";
		});
	};
	
	fetchData(dataRef, allPlacesSection);
	// Keep track of all Firebase refs we are listening to.
	listeningFirebaseRefs.push(dataRef);
	
}

function showAllPlacesSearch(queryText){
	var searchTxt = queryText.replace('+', ' ');
	var dataRef = firebase.database().ref('places');
	
	var fetchData = function(ref, section){
		
		ref.on('child_added', function(data){
			if(data.val().placeName.toLowerCase().includes(searchTxt.toLowerCase())){
				console.log(data.getKey());
				var content = section.getElementsByClassName('data-list')[0];
				content.insertBefore(
				createAllPlacesElement(data.getKey(), data.val().imageThumbnail, data.val().placeName, data.val().address),
				content.firstChild);
				
			}
			loading.style = "display:none";
		});
	};
	
	fetchData(dataRef, allPlacesSection);
	// Keep track of all Firebase refs we are listening to.
	listeningFirebaseRefs.push(dataRef);
	
}

function showAllPlacesCategory(searchTxt){
	
	var dataRef = firebase.database().ref('places');
	
	var fetchData = function(ref, section){
		
		ref.on('child_added', function(data){
			if(data.val().category.toLowerCase().includes(searchTxt.toLowerCase())){
				console.log(data.getKey());
				var content = section.getElementsByClassName('data-list')[0];
				content.insertBefore(
				createAllPlacesElement(data.getKey(), data.val().imageThumbnail, data.val().placeName, data.val().address),
				content.firstChild);
				
			}
			loading.style = "display:none";
		});
	};
	
	fetchData(dataRef, allPlacesSection);
	// Keep track of all Firebase refs we are listening to.
	listeningFirebaseRefs.push(dataRef);
	
}

function showPlace(idPlace){
	
	var dataRef = firebase.database().ref('places/'+idPlace);
	
	var fetchData = function(ref, section){
		ref.on('value', function(data){
			var linkImg = STORAGE_URL+"gallery%2F"+idPlace+"%2F"+data.val().imageThumbnail+"?alt=media";
			
			tagImgThumb.src		= linkImg;
			frmPlaceName.value 	= data.val().placeName;
			frmAddress.value 	= data.val().address;
			
			//$('#frmDescription').froalaEditor('html.set', data.val().description);
			frmDescription.value = data.val().description;
			frmFacilities.value	= data.val().facilities;
			frmInfo.value		= data.val().info;
			var loc = data.val().latlong.split(",");
			frmLatitude.value	= loc[0];
			frmLongitude.value  = loc[1];
			//frmCategory.value	= data.val().category;
			
			var arrayCat = data.val().category.split(',');
			for(var i=0;i < arrayCat.length; i++){
				document.querySelector('#'+arrayCat[i].trim()).checked = true;
			}
			
			loading.style = "display:none";
			placeDataSection.style = "display:block";
			
		});
	};
	
	fetchData(dataRef, allPlacesSection);
	// Keep track of all Firebase refs we are listening to.
	listeningFirebaseRefs.push(dataRef);
	
}

function createGalleryElement(idPlace, userID, idGallery, fileName, uploadDate){
	var html = 
	'<div class="col-sm-6">'+
	'<a style="right:0px;top:0px;position:absolute;" href="" class="del btn bg-red btn-circle waves-effect waves-circle waves-float">'+
	'<i class="material-icons">delete_forever</i>'+
	'</a>'+
	'<a class="img_link" href="#" target="_blank">'+
	'<img class="imageFile" style="height:125px;width:100%" src="">'+
	'</a>'+
	
	'</div>';
	
	var div = document.createElement('div');
	div.innerHTML = html;
	var dataElement = div.firstChild;
	
	var linkImg = STORAGE_URL+"gallery%2F"+idPlace+"%2F"+fileName+"?alt=media";
	
	dataElement.getElementsByClassName('imageFile')[0].src = linkImg;
	dataElement.getElementsByClassName('img_link')[0].href = linkImg;
	dataElement.getElementsByClassName('del')[0].href = "?uid="+userID+"&id_place="+idPlace+"&del_gallery="+idGallery+"&filename="+fileName;
	
	return dataElement;
}

function showGallery(idPlace){
	firebase.database().ref('gallery').ref.on('child_added', function(data){
		
		var dataRefGallery = firebase.database().ref('gallery/'+data.getKey()+'/'+idPlace);
		
		var fetchDataGallery = function(refGallery, sectionGallery){
			refGallery.on('child_added', function(dataGallery){
				console.log(dataGallery.val().fileName);
				
				var content = sectionGallery.getElementsByClassName('gallery-list')[0];
				content.insertBefore(
				createGalleryElement(idPlace, data.getKey(), dataGallery.getKey(), dataGallery.val().fileName, data.val().timestamp),
				content.firstChild);
				
				loading.style = "display:none";
				comenSec.style = "display:block";
			});
		};
		
		fetchDataGallery(dataRefGallery, gallerySection);
		// Keep track of all Firebase refs we are listening to.
		listeningFirebaseRefs.push(dataRefGallery);
	});
	
}


function createReviewElement(idRev, userID, displayName, photoUrl, numStar, review){
	var html = 
	'<div class="media">'+
	'<div class="media-left">'+
	'<img class="media-object" width="60" height="60" alt="User"/>'+
	'</div>'+
	'<div class="media-body">'+
	'<div class="col-sm-10"><h4 class="media-heading"></h4><div class="rating"></div><div class="review"></div></div><div class="col-sm-2">'+
	'<a href="" class="del ">'+
	'<i class="material-icons">delete_forever</i>'+
	'</a>'+
	'</div>'+
	'</div>'+
	'</div>';
	
	var div = document.createElement('div');
	div.innerHTML = html;
	var dataElement = div.firstChild;
	
	if(photoUrl){
		dataElement.getElementsByClassName('media-object')[0].src = photoUrl;
	}
	else{
		dataElement.getElementsByClassName('media-object')[0].src = BASE_URL + "styles/images/user.png";
	}
	
	var rate = "";
	for(var i=0;i<numStar;i++){
		rate += '<i class="material-icons" style="font-size: 12px;color: #FB8C00;">star</i>';
	}
	
	dataElement.getElementsByClassName('media-heading')[0].innerHTML = displayName;
	dataElement.getElementsByClassName('review')[0].innerHTML = review;
	dataElement.getElementsByClassName('rating')[0].innerHTML = rate;
	dataElement.getElementsByClassName('del')[0].href = "?uid="+userID+"&del_review="+idRev;
	
	return dataElement;
}

function showReview(idPlace){
	firebase.database().ref('rate').ref.on('child_added', function(data){
		
		var dataRefReview = firebase.database().ref('rate/'+data.getKey()+'/'+idPlace);
		
		var fetchDataReview = function(refReview, sectionReview){
			refReview.on('value', function(dataRev){
				
				
				firebase.database().ref('users/'+data.getKey()+'/').once('value').then(
				function(snapshot) {
					var dn = snapshot.val();
					
					var content = sectionReview.getElementsByClassName('review-list')[0];
					content.insertBefore(
					createReviewElement(dataRev.getKey(), data.getKey(), dn.displayName, dn.photoUrl, dataRev.val().rateNum, dataRev.val().review),
					content.firstChild);
					
				});
				
				
				loading.style = "display:none";
				comenSec.style = "display:block";
			});
		};
		
		fetchDataReview(dataRefReview, reviewsSection);
		// Keep track of all Firebase refs we are listening to.
		listeningFirebaseRefs.push(dataRefReview);
	});
	
}

function saveData(txtPlaceName, txtAddress, txtDescription, txtFacilities, txtInfo, txtLatlong, file){
	var currentPlaceId = getQueryVariable('show');
	
	var checkedValue = "";
	
	firebase.database().ref('categories').on('child_added', function(data){
		if(document.querySelector('#'+data.getKey()).checked){
			checkedValue += document.querySelector('#'+data.getKey()).value + ",";
		}
	});
	
	var txtCategory = checkedValue.slice(0, -1) + '';
	
	if(txtCategory){
		if(currentPlaceId){
			if(file){
				var metadata = {
					contentType: file.type,
				};
				
				var uploadTask = firebase.storage().ref('gallery/'+currentPlaceId+'/'+file.name.replace(' ','_')).put(file, metadata);
				
				uploadTask.on('state_changed', function(snapshot){
					
				}, 
				function(error) {
					showNotif('Error:'+error,'danger');
				}, 
				function() {
					showNotif('Image upload successfull','success');
					var downloadURL = uploadTask.snapshot.downloadURL;
					imgThumb.src = downloadURL;
					frmImage.value = '';
				});
				
				addGallery(file, currentPlaceId, currentUID);
				
				showNotif('Data saved!','success');
				
				return firebase.database().ref().child('places/'+currentPlaceId).update({
					placeName 	: txtPlaceName,
					address		: txtAddress,
					description	: txtDescription,
					facilities	: txtFacilities,
					info		: txtInfo,
					latlong		: txtLatlong,
					category	: txtCategory,
					imageThumbnail: file.name.replace(' ','_')
				});
			}
			else{
			
				showNotif('Data saved!','success');
				
				return firebase.database().ref().child('places/'+currentPlaceId).update({
					placeName 	: txtPlaceName,
					address		: txtAddress,
					description	: txtDescription,
					facilities	: txtFacilities,
					info		: txtInfo,
					latlong		: txtLatlong,
					category	: txtCategory
				});
			}
		}
	}
	else{
		showNotif('Select category first', 'danger');
	}
	
}

function addGallery(file, currentPlaceId, currentUID){
	var today = getToday();
	
	firebase.database().ref().child("gallery/"+currentUID+'/'+currentPlaceId).push().set({
		fileName: file.name.replace(' ','_'),
		timestamp: today
	});
}

function deleteQuery(){
	var delRevLink = getQueryVariable('del_review');
	var delGalId = getQueryVariable('id_place');
	var delGalLink = getQueryVariable('del_gallery');
	var filename   = getQueryVariable('filename');
	var userIdLink	= getQueryVariable('uid');
	
	var delPlace = getQueryVariable('del_place');
	
	
	var onComplete = function(error) {
		if (error) {
			showNotif(error.message, 'danger');
		} 
		else {
			showNotif('Deleted', 'info');
		}
	};
	
	if(userIdLink){
		if(delRevLink){
			var delRefRev = firebase.database().ref('rate/'+userIdLink+'/'+delRevLink);
			delRefRev.remove(onComplete);
			
			
			setTimeout(function () {
				window.location.href = "home?show="+delRevLink;
			}, 2000);
		}
		else if(delGalLink && delGalId && filename){
			var delRefImg = firebase.database().ref('gallery/'+userIdLink+'/'+delGalId+'/'+delGalLink);
			delRefImg.remove(onComplete);
			
			var delStorageImg = firebase.storage().ref('gallery/'+delGalId+'/'+filename);
			delStorageImg.delete().then(function() {
				showNotif('Image deleted!', 'info');
				}).catch(function(error) {
				showNotif(error.message, 'danger');
			});
			
			setTimeout(function () {
				window.location.href = "home?show="+delGalId;
			}, 2000);
		}
		
		
	}
	else if(delPlace){
		var delRefPlace = firebase.database().ref('places/'+delPlace);
		delRefPlace.remove(onComplete);
		
		firebase.database().ref('gallery').on('child_added', function(data){
			firebase.database().ref('gallery/'+data.getKey()).on('child_added', function(data2){
				
				if(data2.getKey() == delPlace){
					firebase.database().ref('gallery/'+data.getKey()+'/'+data2.getKey()).remove(onComplete);
				}
			});
		});
		
		setTimeout(function () {
			window.location.href = "home";
		}, 2000);
	}
	
}

function getToday(){
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	
	if(dd<10) {
		dd='0'+dd
	} 
	
	if(mm<10) {
		mm='0'+mm
	} 
	
	today = dd+'-'+mm+'-'+yyyy;
	return today;
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
	placeDataSection.style = "display:none";
	allPlacesSection.getElementsByClassName('data-list')[0].innerHTML = "";
	comenSec.style = "display:none";
	gallerySection.getElementsByClassName('gallery-list')[0].innerHTML = '';
	reviewsSection.getElementsByClassName('review-list')[0].innerHTML = '';
	selectCategorySection.getElementsByClassName('category-data')[0].innerHTML = '';
	menuCategorySection.getElementsByClassName('menu-list')[0].innerHTML = '';
	listeningFirebaseRefs.forEach(function (ref) {
		ref.off();
	});
	listeningFirebaseRefs = [];
}

function updateUser(currentUID){
	var today = getToday();
	
	firebase.database().ref().child("users/"+currentUID).update({
		displayName: "Admin",
		photoUrl: "",
		lastAccess: getToday()
	});
}

function onAuthStateChanged(user) {
	var deleteId = getQueryVariable('delete');
	var editId	 = getQueryVariable('edit');
	var showId	 = getQueryVariable('show');
	var search	 = getQueryVariable('search');
	
	var category = getQueryVariable('category');
	
	cleanupUi();
	if (user) {
		showMenuCategories();
		showAllCategories();
		deleteQuery();
		if(showId){
			titlePage.innerHTML = WEB_TITLE+" - Place";
			titlePage.href = "home";
			linkHome.href = "home";
			iconHome.innerHTML = "keyboard_arrow_left";
			
			showPlace(showId);
			showGallery(showId);
			showReview(showId);
			
			allPlacesSection.style = "display:none";
		}
		else if(search){
			titlePage.innerHTML = WEB_TITLE+" - Search Place";
			titlePage.href = "home";
			linkHome.href = "home";
			iconHome.innerHTML = "keyboard_arrow_left";
			
			showAllPlacesSearch(search);
			placeDataSection.style = "display:none";
			comenSec.style = "display:none";
			allPlacesSection.style = "display:block";
		}
		else if(category){
			titlePage.innerHTML = WEB_TITLE+" - Places by Category";
			titlePage.href = "home";
			linkHome.href = "home";
			iconHome.innerHTML = "keyboard_arrow_left";
			
			showAllPlacesCategory(category);
			placeDataSection.style = "display:none";
			comenSec.style = "display:none";
			allPlacesSection.style = "display:block";
		}
		else{
			titlePage.innerHTML = WEB_TITLE+" - All Places";
			titlePage.href = "home";
			linkHome.href = "home";
			iconHome.innerHTML = "home";
			
			
			showAllPlaces();
			
			placeDataSection.style = "display:none";
			comenSec.style = "display:none";
			allPlacesSection.style = "display:block";
			
		}
		
		if (user && currentUID === user.uid || !user && currentUID === null) {
			return;
		}
		currentUID = user ? user.uid : null;
		
		updateUser(currentUID);
	} 
	else{
		window.location.href = "sign-in";
	}
}

window.addEventListener('load', function(){
	
	var currentPlaceId = getQueryVariable('show');
	
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
		
		if(txtPlaceName && frmLatitude.value && frmLongitude.value){
			
			saveData(txtPlaceName, txtAddress, txtDescription, txtFacilities, txtInfo, txtLatlong, file);
			
		}
		else{
			showNotif('Place Name and Latitude,Longitude must not be null','danger');
		}
	}
	
	firebase.auth().onAuthStateChanged(onAuthStateChanged);
	
}, false);

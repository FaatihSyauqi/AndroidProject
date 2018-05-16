
var titlePage = document.getElementById('titlePage');


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

var loadingSave		 = document.getElementById('loading-save');

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
	
	dataElement.getElementsByClassName('delete')[0].addEventListener('click', function(){
		deletePlace(key);
	});
	
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
			
		});
	};
	
	loading.style = "display:none";
	
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
			
			frmDescription.value = data.val().description;
			
			frmDescription.hml = data.val().description;
			frmFacilities.value	= data.val().facilities;
			frmInfo.value		= data.val().info;
			var loc = data.val().latlong.split(",");
			frmLatitude.value	= loc[0];
			frmLongitude.value  = loc[1];
			
			var arrayCat = data.val().category.split(',');
			for(var i=0;i < arrayCat.length; i++){
				document.querySelector('#'+arrayCat[i].trim()).checked = true;
			}
			
			loading.style = "display:none";
			placeDataSection.style = "display:block";
			
		});
	};
	
	fetchData(dataRef, allPlacesSection);
	listeningFirebaseRefs.push(dataRef);
	
}

function createGalleryElement(idPlace, userID, idGallery, fileName, uploadDate){
	var html = 
	
	'<div class="col-sm-6"><div class="thumbnail">'+
	'<a class="img_link" href="#" target="_blank"><img style="height:125px;width:100%" class="imageFile" src=""></a>'+
	'<div class="caption">'+
	'<p>'+
	'<a href="#" class="del-gal btn btn-danger btn-block waves-effect" role="button">Delete</a>'+
	'</p>'+
	'</div>'+
	'</div></div>';
	
	
	var div = document.createElement('div');
	div.innerHTML = html;
	var dataElement = div.firstChild;
	
	var linkImg = STORAGE_URL+"gallery%2F"+idPlace+"%2F"+fileName+"?alt=media";
	
	dataElement.getElementsByClassName('imageFile')[0].src = linkImg;
	dataElement.getElementsByClassName('img_link')[0].href = linkImg;
	dataElement.getElementsByClassName('del-gal')[0].addEventListener('click', function(){
		deleteGallery(userID, idPlace, idGallery, fileName);
	});
	
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
	'<a href="#" class="del-rev">'+
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
	dataElement.getElementsByClassName('del-rev')[0].addEventListener('click', function(){
		deleteReview(userID, idRev);
	});
	
	return dataElement;
}

function deletePlace(delPlace){
	if(delPlace){
		var delRefPlace = firebase.database().ref('places/'+delPlace);
		swal({
			title: "Are you sure?",
			text: "You will not be able to recover this place!",
			type: "warning",
			showCancelButton: true,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: false
		}, 
		function () {
			
			delRefPlace.remove();
			
			firebase.database().ref('gallery').on('child_added', function(data){
				firebase.database().ref('gallery/'+data.getKey()).on('child_added', function(data2){
					
					if(data2.getKey() == delPlace){
						firebase.database().ref('gallery/'+data.getKey()+'/'+data2.getKey()).remove(function(error){
							if(!error){
								swal("Deleted!", "The place has been deleted!", "success");
								
								setTimeout(function () {
									window.location.href = "home";
								}, 2000);
							}
						});
					}
				});
			});
			
		});
	}
}

function deleteReview(userIdLink, delRevLink){
	if(userIdLink && delRevLink){
		var delRefRev = firebase.database().ref('rate/'+userIdLink+'/'+delRevLink);
		
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
					swal("Deleted!", "The review has been deleted!", "success");
					
					setTimeout(function () {
						window.location.href = "home?show="+delRevLink;
					}, 2000);
				}
			});
			
		});
	}
}

function deleteGallery(userIdLink, delGalId, delGalLink, fileName){
	if(userIdLink && delGalId && delGalLink && fileName){
		var delRefImg = firebase.database().ref('gallery/'+userIdLink+'/'+delGalId+'/'+delGalLink);
		
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
			
			
			delRefImg.remove(function(error){
				if(!error){
					
					var delStorageImg = firebase.storage().ref('gallery/'+delGalId+'/'+fileName);
					delStorageImg.delete().then(function() {
						swal("Deleted!", "The image has been deleted!", "success");
						
						setTimeout(function () {
							window.location.href = "home?show="+delGalId;
						}, 2000);
					})
					.catch(function(error) {
						swal("Deleted!", "The image has been deleted!", "success");
						
						setTimeout(function () {
							window.location.href = "home?show="+delGalId;
						}, 2000);
					});
				}
			});
			
		});
		
	}
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

function saveData(txtPlaceName, txtAddress, txtDescription, txtFacilities, txtInfo, txtLatlong, file, ext){
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
			loadingSave.style = "display:block";
			if(file){
				var metadata = {
					contentType: file.type,
				};
				
				var d = new Date();
				var f = d.getTime();
				
				var uploadTask = firebase.storage().ref('gallery/'+currentPlaceId+'/IMG_'+f+'.'+ext).put(file, metadata);
				
				uploadTask.on('state_changed', function(snapshot){
					
				}, 
				function(error) {
					showNotif('Error:'+error,'danger');
				}, 
				function() {
					var downloadURL = uploadTask.snapshot.downloadURL;
					imgThumb.src = downloadURL;
					frmImage.value = '';
					
					firebase.database().ref().child('places/'+currentPlaceId).update({
						placeName 	: txtPlaceName,
						address		: txtAddress,
						description	: txtDescription,
						facilities	: txtFacilities,
						info		: txtInfo,
						latlong		: txtLatlong,
						category	: txtCategory,
						imageThumbnail: 'IMG_'+f+'.'+ext
					}, 
					function(error){
						if(!error){
							addGallery(file, ext, f, currentPlaceId, currentUID);
						}
					});
				});
			}
			else{
				firebase.database().ref().child('places/'+currentPlaceId).update({
					placeName 	: txtPlaceName,
					address		: txtAddress,
					description	: txtDescription,
					facilities	: txtFacilities,
					info		: txtInfo,
					latlong		: txtLatlong,
					category	: txtCategory
				}, 
				function(error){
					if(!error){
						showNotif('Data saved!','success');
						loadingSave.style = "display:none";
						setTimeout(function () {
							window.location.href = "home?show="+delGalId;
						}, 2000);
					}
				});
			}
		}
	}
	else{
		showNotif('Select category first', 'danger');
	}
	
}

function addGallery(file, ext, timeStamp, currentPlaceId, currentUID){
	var today = getToday();
	
	firebase.database().ref().child("gallery/"+currentUID+'/'+currentPlaceId).push().set({
		fileName: 'IMG_'+timeStamp+'.'+ext,
		timestamp: today
	}, function(error){
		if(!error){
		
			showNotif('Data saved','success');
			loadingSave.style = "display:none";
			setTimeout(function () {
				window.location.href = "home?show="+delGalId;
			}, 2000);
		}
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

function showNotif(messageText, elementNotif){
	$.notify({
		message: messageText 
	},
	{
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
		if(showId){
			titlePage.innerHTML = WEB_TITLE+" - Place";
			titlePage.href = "home";
			
			showPlace(showId);
			showGallery(showId);
			showReview(showId);
			
			allPlacesSection.style = "display:none";
		}
		else if(search){
			titlePage.innerHTML = WEB_TITLE+" - Search Place";
			titlePage.href = "home";
			
			showAllPlacesSearch(search);
			placeDataSection.style = "display:none";
			comenSec.style = "display:none";
			allPlacesSection.style = "display:block";
		}
		else if(category){
			titlePage.innerHTML = WEB_TITLE+" - Places by Category";
			titlePage.href = "home";
			
			showAllPlacesCategory(category);
			placeDataSection.style = "display:none";
			comenSec.style = "display:none";
			allPlacesSection.style = "display:block";
		}
		else{
			titlePage.innerHTML = WEB_TITLE+" - All Places";
			titlePage.href = "home";
			
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
		var fName			= frmImage.value;
		console.log(fName);
		var file = document.forms['svForm']['fImage'].files[0];
		
		if(txtPlaceName && frmLatitude.value && frmLongitude.value){
			if(file){
				var ext = file.name.split('.').pop();
				if(ext =="png" || ext=="jpg" || ext =="jpeg" || ext =="PNG" || ext=="JPG" || ext =="JPEG"){
					saveData(txtPlaceName, txtAddress, txtDescription, txtFacilities, txtInfo, txtLatlong, file, ext);
				}
				else{
					showNotif('File type not allowed.','danger')
				}
			}
			else{
				saveData(txtPlaceName, txtAddress, txtDescription, txtFacilities, txtInfo, txtLatlong, file, ext);
			}
		}
		else{
			showNotif('Place Name and Latitude,Longitude must not be null','danger');
		}
	}
	
	firebase.auth().onAuthStateChanged(onAuthStateChanged);
	
}, false);

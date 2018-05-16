
var titlePage = document.getElementById('titlePage');

var configDataAboutSection = document.getElementById('configDataAbout');
var configDataAdsSection = document.getElementById('configDataAds');

var saveFormAbout = document.getElementById('saveFormAbout');

var saveFormAds = document.getElementById('saveFormAds');

var frmAppDescription = document.querySelector('#frmAppDescription');
var frmAppFacebook = document.querySelector('#frmAppFacebook');
var frmAppTwitter = document.querySelector('#frmAppTwitter');
var frmAppInstagram = document.querySelector('#frmAppInstagram');
var frmAppYoutube = document.querySelector('#frmAppYoutube');
var frmAppWebsite = document.querySelector('#frmAppWebsite');
var frmAppEmail = document.querySelector('#frmAppEmail');

var checkAdBanner = document.querySelector('#checkAdBanner');
var checkAdInterstitial = document.querySelector('#checkAdInterstitial');
var checkAdNative = document.querySelector('#checkAdNative');

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

function checkRefConfig(){
	var refConfig = firebase.database().ref('config');
		refConfig.once('value', function(snapshot) {
			if (!snapshot.hasChild('ads_config')) {
				console.log('Ads Config Not Exist');
				addDefaultAdsConfig();
			}else{
				showAdsConfig();
			}
			if (!snapshot.hasChild('about_config')){
				console.log('About Config Not Exist');
				addDefaultAboutConfig();
			}else{
				showAboutConfig();
			}
		});
}

function addDefaultAboutConfig(){
	return firebase.database().ref('config').child('about_config').
	update({
		app_description: 'This is description of your app',
		app_facebook: 'ihsan.badruzaman',
		app_twitter: 'ihsan_bz',
		app_instagram: 'ihsan_bz',
		app_email: 'ihsanbadru@gmail.com',
		app_youtube: 'gaexjro',
		app_website: 'blogger-dot-blogspot.blogspot.com'
	});
}

function addDefaultAdsConfig(){
	return firebase.database().ref('config').child('ads_config').
	update({
		enable_ad_banner: true,
		enable_ad_interstitial: true,
		enable_ad_native: true
	})
}
	
function showAboutConfig(){
	var dataAboutRef = firebase.database().ref('config').child('about_config');
	dataAboutRef.once('value', function(snap){
		configDataAboutSection.style = "display:block";
		loading.style = "display:none";
		
		frmAppDescription.value = snap.val().app_description;
		frmAppEmail.value = snap.val().app_email;
		frmAppFacebook.value = snap.val().app_facebook;
		frmAppTwitter.value = snap.val().app_twitter;
		frmAppInstagram.value = snap.val().app_instagram;
		frmAppWebsite.value = snap.val().app_website;
		frmAppYoutube.value = snap.val().app_youtube;
	});
}

function showAdsConfig(){
	var dataAdsRef = firebase.database().ref('config').child('ads_config');
	dataAdsRef.once('value', function(snap){
		configDataAdsSection.style = "display:block";
		loading.style = "display:none";
		
		checkAdBanner.checked = snap.val().enable_ad_banner;
		checkAdInterstitial.checked = snap.val().enable_ad_interstitial;
		checkAdNative.checked = snap.val().enable_ad_native;
		
		checkAdBanner.value = snap.val().enable_ad_banner;
		checkAdInterstitial.value = snap.val().enable_ad_interstitial;
		checkAdNative.value = snap.val().enable_ad_native;
	});
}

function cleanupUi() {
	configDataAboutSection.style = "display:none";
	configDataAdsSection.style = "display:none";
	
	listeningFirebaseRefs.forEach(function (ref) {
		ref.off();
	});
	listeningFirebaseRefs = [];
}

function onAuthStateChanged(user) {
	
	cleanupUi();
	
	if(user){
		titlePage.href = "home";
		
		checkRefConfig();
		
		if (user && currentUID === user.uid || !user && currentUID === null) {
			return;
		}
		currentUID = user ? user.uid : null;
	}
	else{
		window.location.href = "sign-in";
	}
}

window.addEventListener('load', function(){
	
	logoutButton.addEventListener('click', function () {
		firebase.auth().signOut();
		location.reload();
		showNotif('Thank You, See You Nextime!','info');
	});
	
	saveFormAbout.onsubmit = function(e){
		e.preventDefault();
		
		showNotif('About config updated!', 'success');
		
		return firebase.database().ref('config').child('about_config').
		update({
			app_description: frmAppDescription.value,
			app_facebook: frmAppFacebook.value,
			app_twitter: frmAppTwitter.value,
			app_instagram: frmAppInstagram.value,
			app_email: frmAppEmail.value,
			app_youtube: frmAppYoutube.value,
			app_website: frmAppWebsite.value
		});
		
	}
	
	saveFormAds.onsubmit = function(e){
		e.preventDefault();
		
		showNotif('Ads Config updated', 'success');
		
		
		return firebase.database().ref('config').child('ads_config').
		update({
			enable_ad_banner: checkAdBanner.checked,
			enable_ad_interstitial: checkAdInterstitial.checked,
			enable_ad_native: checkAdNative.checked
		});
		
	}
	
	firebase.auth().onAuthStateChanged(onAuthStateChanged);
}, false);
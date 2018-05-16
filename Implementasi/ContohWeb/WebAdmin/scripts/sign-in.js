
var signInForm		= document.getElementById('sign_in');
var userInput		= document.getElementById('username');
var passwordInput	= document.getElementById('password');

var loading			= document.getElementById('loading');

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

function onAuthStateChanged(user) {
	if (user) {
		window.location.href = "home";
	} 
}

//uName : admin@cityapp.com pWord: admin1234
window.addEventListener('load', function(){
	
	firebase.auth().onAuthStateChanged(onAuthStateChanged);
	
	signInForm.onsubmit = function(e){
		e.preventDefault();
		loading.style = "display:block";
		var uName = userInput.value;
		var pWord = passwordInput.value;
		
		if(uName && pWord){
			firebase.auth().signInWithEmailAndPassword(uName, pWord).catch(function(error){
				if(error){
					var errorCode = error.code;
					var errorMessage = error.message;
					loading.style = "display:none";
					showNotif('Error : ' + errorMessage, 'danger');
				}
				else{
					loading.style = "display:none";
					showNotif('Login success!','success');
					
				}
			});
			userInput.value = '';
			passwordInput.value = '';
		}
	};
}, false);
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});

function callLoginTemplate(){
    var elements = document.getElementsByClassName('loginPopup');
 if (elements.length > 0) {
  elements[0].style.zIndex = 10;
 }
};
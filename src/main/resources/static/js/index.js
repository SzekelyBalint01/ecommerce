//import createFormString from "./createFormString.js";



//Handler function for the userForm form
async function btnSend() {
  const resp = await fetch("http://localhost:8080/login", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded",
    },
    body: createFormData(),
  })
      .catch(() => console.log("Rejected"))
      .then((response) => {
        return response.json();
      });

  if (resp.sent) {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function () {
      x.className = x.className.replace("show", "");
    }, 3000);
  }
}

//Creates string from the data retrieved from the search form
const createFormData = () => {
  let keys = [];
  let values = [];

  keys.push("costumerEmail");
  values.push(document.getElementById("costumerEmail").value);
  keys.push("subject");
  values.push(document.getElementById("subject").value);
  keys.push("massage");
  values.push(document.getElementById("massage").value);

  return createFormString(keys, values);
};

//--------------------Slider Script START----------------
let slideIndex = 1;
showSlides(slideIndex);

// Next/previous controls
function plusSlides(n) {
  showSlides(slideIndex += n);
}

// Thumbnail image controls
function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides() {
  let i;
  let slides = document.getElementsByClassName("mySlides");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}
  slides[slideIndex-1].style.display = "block";
  setTimeout(showSlides, 5000); // Change image every 5 seconds
}
//---------------------Slider Script END------------------
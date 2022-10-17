import createFormString from "./createFormString.js";

//Retrieves the search form
const cartForm = document.getElementById("cartFrom");

//Sets the action to do when submitting the search form
cartForm.onsubmit = (e) => {
  e.preventDefault();
  btnSend();
};

//Handler function for the userForm form
async function btnSend() {
  const resp = await fetch("http://localhost:8080/addToCartPost", {
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
   
  }
}

//Creates string from the data retrieved from the search form
const createFormData = () => {
  let keys = [];
  let values = [];

  keys.push("userId");
  values.push(document.getElementById("user").value);
  keys.push("productId");
  values.push(document.getElementById("product").value);
  
  return createFormString(keys, values);
};

//Creates string for form data to use in a fetch api call
function createFormString(keys, values) {
  let returnValue = "";
  console.log("test");
  values.forEach((value, index) => {
    returnValue = returnValue.concat(keys[index] + "=");
    returnValue = returnValue.concat(value);
    if (index != values.length - 1) {
      returnValue = returnValue.concat("&");
    }
  });

  return returnValue;
}

export default createFormString;

function check(myform) {
    var regexInput = /(((0|1)[0-9]|2[0-9]|3[0-1])\/(0[1-9]|1[0-2])\/((19|20|21)\d\d)) (((0|1)[0-9]|2[0-9]|3[0-1])\/(0[1-9]|1[0-2])\/((19|20|21)\d\d))$/;
    var lblError = document.getElementById("lblError");
    if (regexInput.test(myform.inputInfo.value) == false) {
		lblError.innerHTML = "  Enter in valid format 'dd/MM/yyyy dd/MM/yyyy'"
		myform.inputInfo.focus();
		return false;
	}
	alert("Request Submitted");
}

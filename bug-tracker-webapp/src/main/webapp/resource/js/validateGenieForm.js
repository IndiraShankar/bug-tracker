function assignPerson(issue) {
	if (issue == "LoginIssue") {
		document.getElementById("assignedTo").value = "ramesh";
		document.getElementById("person").innerHTML = "ramesh";
	} else if (issue == "networkIssue") {
		document.getElementById("assignedTo").value = "suresh";
		document.getElementById("person").innerHTML = "suresh";
	} else if (issue == "laptopIssue") {
		document.getElementById("assignedTo").value = "hari";
		document.getElementById("person").innerHTML = "hari";
	} else if (issue == "browserIssue") {
		document.getElementById("assignedTo").value = "nari";
		document.getElementById("person").innerHTML = "nari";
	}
}

function validate() {
	document.getElementById("errorMsg").innerHTML="";
	
	var Severity= document.getElementById("Severity").value;
	var genieType= document.getElementById("genieType").value;
	var location= document.getElementById("location").value;
	var mobilenum= document.getElementById("mobilenum").value;
	var raisedDate= document.getElementById("raiseddate").value;
	
	if (genieType == "") {
		 document.getElementById("errorMsg").innerHTML="select genieType"
		return false;
	}
	if (Severity == "") {
		 document.getElementById("errorMsg").innerHTML="select Severity"
		return false;
	}
	if (location == "") {
		 document.getElementById("errorMsg").innerHTML="select location"
		return false;
	}
	if (mobilenum == "" || mobilenum.length!=10) {
		 document.getElementById("errorMsg").innerHTML="u hv not entered a mobile number or it may not be a valid mobile number"
		return false;
	}
	if (raisedDate == "" ) {
		 document.getElementById("errorMsg").innerHTML="enter the date";
		return false;
	}
	
	return true;
}


function validateForm() {
var x = document.forms["form"]["f1"].value;
var y = document.forms["form"]["t1"].value;

if (x == null || x == "") {
    fError = "Please enter your station";
    document.getElementById("err").innerHTML = fError; 
    return false;
} 

else if (y == null || y == "") {
    tError = "Please enter your to station";
    document.getElementById("trr").innerHTML = tError;
    return false;
} 

else {return true;}
}

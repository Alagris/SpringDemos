document.addEventListener('DOMContentLoaded', function() {
	document.getElementById("all_cookies").innerHTML = document.cookie;
});
function setCookies() {
	var d = new Date();
	var exdays = 5;
	d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
	document.cookie = document.getElementById("cookiesIn").value + ";expires="
			+ d.toUTCString() + ";path=/";
	document.getElementById("all_cookies").innerHTML = document.cookie;

}
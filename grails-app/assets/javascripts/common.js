function getUrlParameter(urlName) {
    var found = RegExp('[?&]' + urlName + '=([^&]*)').exec(window.location.search);
	return found && decodeURIComponent(found[1].replace(/\+/g, ' '));
};
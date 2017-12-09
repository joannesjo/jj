
function onLoad() {
    gapi.load('auth2', function() {
        gapi.auth2.init();
    });
}

function onSignIn(googleUser) {
window.location.replace("http://"+window.location.host+"/home");
}

function signOut() {
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
        });
    window.location.replace("http://"+window.location.host+"/login");

}
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06-12-2017
  Time: 00:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="google-signin-client_id" content="201080948341-iiomn8urn74s9e0qojcfr4tiefnah3iv.apps.googleusercontent.com">

    <title>Title</title>

    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script>
        function onSignIn(googleUser) {
            var profile = googleUser.getBasicProfile();
            //alert('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
            //alert('Name: ' + profile.getName());
            //alert('Image URL: ' + profile.getImageUrl());
           // alert('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
       console.log(googleUser.getBasicProfile());
       console.log(googleUser.getContent);
            console.log(googleUser.getAllResponseHeaders);
            console.log(googleUser.getData);


        }

    </script>
</head>
<body>
<div class="g-signin2" data-onsuccess="onSignIn"></div>
<a href="#" onclick="signOut();">Sign out</a>
<script>
    function signOut() {
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
            alert('User signed out.');
        });
    }
</script>

</body>
</html>

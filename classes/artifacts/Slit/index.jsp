<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
  <title>Slit</title>
  <meta charset="UTF-8">
  <meta name="google-signin-client_id" content="310967327837-t8jk6mv0v1n9h20c4nfl0lfdopjvtuc2.apps.googleusercontent.com">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
<body>

<h1>Velkommen til Slit, hva ønsker du å gjøre?</h1>
<form action="/Slit/Login.jsp" method="post">
  <input type="submit" value="Logge inn">
</form>

  <form action="/Slit/NewStudent.jsp" method="post">
    <input type="submit" value="Opprette ny bruker">
  </form>

<!-- Script hentet fra https://stackoverflow.com/questions/31331428/how-to-call-getbasicprofile-of-google-to-google-signin-on-only-button-click -->
<script>
    function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        var user_name = profile.getName();

        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'localhost:8080/Slit/Login');
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onload = function() {
            console.log('Signed in as: ' + xhr.responseText);
        };
        xhr.send('idtoken=' + id_token);
    }

    function onLoad() {
        gapi.load('auth2,signin2', function() {
            var auth2 = gapi.auth2.init();
            auth2.then(function() {
                // Current values
                var isSignedIn = auth2.isSignedIn.get();
                var currentUser = auth2.currentUser.get();

                if (!isSignedIn) {
                    // Rendering g-signin2 button.
                    gapi.signin2.render('google-signin-button', {
                        'onsuccess': 'onSignIn'
                    });
                }
            });
        });
    }
</script>

<div id="google-signin-button"></div>
<script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
</body>
</html>
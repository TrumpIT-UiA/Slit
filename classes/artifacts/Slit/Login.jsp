<!--Pulling Awesome Font -->
<!--Hentet fra: https://codepen.io/colorlib/pen/rxddKy -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="LoginTemplate.css">
        <title>Slit</title>
    </head>
    <body>
    <title>Slit</title>
    <div class="login-page">
        <div class="form">
            <form class="login-form" method="post" action="j_security_check">
                <input type="text" name="j_username" placeholder="E-post"/>
                <input type="password" name ="j_password" placeholder="Password"/>
                <button input type="submit">Logg inn</button>
            </form>
        </div>
    </div>
    </body>
</html>

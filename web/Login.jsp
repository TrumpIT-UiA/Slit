<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Slit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Velkommen til Slit</h1>
<form action="/Slit/Login" method="post">
    Brukernavn: <input name="email" type="text"><br>

    Passord: <input name="passWord" type="password"><br>

    <input type="submit" value="Logg inn">
</form>
</body>
</html>

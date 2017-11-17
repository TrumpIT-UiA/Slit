<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Slit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Vennligst oppgi din brukerinformasjon</h1>
<form action="/Slit/NewUser" method="post">
    E-post: <input name="email" type="text"><br>
    Passord: <input name="passWord" type="password"><br>
    Fornavn: <input name="firstName" type="text"><br>
    Etternavn: <input name="lastName" type="text"><br>
    Brukertype: <select name = "userType">
    <option value="Admin">Administrator</option>
    <option value="Teacher">Lærer</option>
    <option value="AssistantTeacher">Hjelpelærer</option>
    </select> <br>
    <input type="submit" value="Lagre"> <br>
</form>
</body>
</html>

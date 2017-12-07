<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Slit</title>
    <meta charset="UTF-8">
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

<form action="/Slit/Upload.jsp" method="post">
    <input type="submit" value="Laste opp fil">
</form>

<form action="/Slit/PDS" method="post">
    <input type="submit" value="Laste ned fil">
</form>

<form action="/Slit/PDS.jsp" method="post">
    <input type="submit" value="PDS.jsp">
</form>

<form action="/Slit/Download" method="post">
    <input type="submit" value="DL-Test">
</form>

</body>
</html>
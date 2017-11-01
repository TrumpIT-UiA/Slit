
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Slit</title>
</head>
<body>
Velkommen til Slit!

Hva ønsker du å gjøre?

<form method="POST" action="Upload" enctype="multipart/form-data" >
    File:
    <input type="file" name="file" id="file" /> <br/>
    <input type="submit" value="Upload" name="upload" id="upload" />
    <p>${message}</p>
    <c:remove var="message" scope="session" />
</form>
</body>
</html>

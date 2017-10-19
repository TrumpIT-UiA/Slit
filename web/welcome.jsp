
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Slit</title>
</head>
<body>
Velkommen til Slit!

Hva ønsker du å gjøre her?

<form action="/Slit/UploadServlet" enctype="multipart/form-data" method="post">
    <input type="file" name="FileName"/>
    <input type="submit" value="Upload File" />
</form>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Slit</title>
</head>
<body>
Velkommen til Slit!

Hva ønsker du å gjøre?

<form action="/Slit/Upload" enctype="multipart/form-data" method="post">
    <input type="file" name="FileName"/>
    <input type="submit" value="Upload File" />
</form>

<form method="POST" action="Upload" enctype="multipart/form-data" >
    File:
    <input type="file" name="file" id="file" /> <br/>
    Destination:
    <input type="text" value="/tmp" name="destination"/>
    </br>
    <input type="submit" value="Upload" name="upload" id="upload" />
</form>

</body>
</html>

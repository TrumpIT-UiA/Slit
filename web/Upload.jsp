<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Halla</title>
</head>
<body>

<form method="POST" action="upload" enctype="multipart/form-data" >
    File:
    <input type="file" name="file" id="file" /> <br/>
    Destination:
    <input type="text" value="/tmp" name="destination"/>
    </br>
    <input type="submit" value="Upload" name="upload" id="upload" />
</form>
</body>
</html>

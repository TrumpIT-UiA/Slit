<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Heihei</title>
</head>
<body>

<form method="POST" action="upload" enctype="multipart/form-data" >
    File:
    <form method="POST" action="Upload" enctype="multipart/form-data" >
        Last opp din fil her:
        <input type="file" name="file" id="file" /> <br/>
        <input type="submit" value="Upload" name="upload" id="upload" />
        <p>${message}</p>
        <c:remove var="message" scope="session" />
</form>

</body>
</html>

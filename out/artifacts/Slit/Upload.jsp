<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Slit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h2>Her kan du laste opp din innlevering!</h2>
<p>Filen du laster opp må være en zip-fil og kan ikke være større enn 10Mib.</p>
<p>Last opp filen her:</p>
<form method="POST" action="Upload" enctype="multipart/form-data">
    Last opp din fil her:
    <input type="file" name="file" id="file"/> <br/>
    <input type="submit" value="Upload" name="upload" id="upload"/>
    <p>${message}</p>
    <c:remove var="message" scope="session"/>
</form>

</body>
</html>

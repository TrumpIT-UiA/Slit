<%--
  Created by IntelliJ IDEA.
  User: Emil-Ruud
  Date: 03/11/2017
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SLIT Delivery</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="MidlertidigStyleSheet.css">
</head>
<h2>Her kan du laste opp din innlevering!</h2>
<p>NB! Filen du laster opp må være en zip-fil og kan ikke være større enn 10Mib.</p>
<form method="POST" action="Upload" enctype="multipart/form-data">
    Last opp din fil her:
    <input type="file" name="file" id="file"/> <br/>
    <input type="submit" value="Upload" name="upload" id="upload"/>
    <p>${message}</p>
    <c:remove var="message" scope="session"/>
</form>
<form action="${pageContext.request.contextPath}/SetModuleNumber" method="post">
        <div class="moduleButtons">
            <input type="submit" name="module1" value="Modul 1" />
            <input type="submit" name="module2" value="Modul 2" />
            <input type="submit" name="module3" value="Modul 3" />
            <input type="submit" name="module4" value="Modul 4" />
            <input type="submit" name="module5" value="Modul 5" />
        </div>
    </form>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Emil-Ruud
  Date: 03/11/2017
  Time: 15:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SLIT Module Delivery</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="MidlertidigStyleSheet.css">
</head>
<body>
<form action="/Slit/ViewModule" method="post">

    <div class="moduleButtons">
        <a href="ModuleDescriptionAndDelivery.jsp">
            <input type="submit" name="module1" value="Modul 1"/>
            <input type="submit" name="module2" value="Modul 2"/>
            <input type="submit" name="module3" value="Modul 3"/>
            <input type="submit" name="module4" value="Modul 4"/>
            <input type="submit" name="module5" value="Modul 5"/>
        </a>
    </div>

    <h2>Modul ${mNr}</h2>
    <c:remove var="mNr" scope="session"/>

    <h3>Mål:</h3>
    <p>${goals}</p>
    <c:remove var="goals" scope="session"/>

    <h3>Hjelpemidler:</h3>
    <p>${resources}</p>
    <c:remove var="resources" scope="session"/>

    <h3>Deadline:</h3>
    <p>${deadline}</p>
    <c:remove var="deadline" scope="session"/>

    <h3>Approval Criterias: </h3>
    <p>${approvalCriterias}</p>
    <c:remove var="approvalCriterias" scope="session"/>

    <h3>Tasks:</h3>
    <p>${tasks}</p>
    <c:remove var="tasks" scope="session"/>

</form>
<h2>Her kan du laste opp din innlevering!</h2>
<p>NB! Filen du laster opp må være en zip-fil og kan ikke være større enn 10Mib.</p>
<form method="POST" action="Upload" enctype="multipart/form-data">
    Last opp din fil her:
    <input type="file" name="file" id="file"/> <br/>
    <input type="submit" value="Upload" name="upload" id="upload"/>
    <p>${message}</p>
    <c:remove var="message" scope="session"/>
</form>

</body>
</html>
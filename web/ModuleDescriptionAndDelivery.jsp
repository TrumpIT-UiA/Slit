<%@ page import="users.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) session.getAttribute("user");%>
<!-- Hentet fra https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_webpage&stacked=h -->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Modulbeskrivelse & Innlevering</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/Slit/MainPageTemplate.css">
    <script src="functions.js"></script>
</head>
<body>
<div class="navbar">
    <a href="/Slit/ModuleDescriptionAndDelivery.jsp">Slit</a>
    <a href="/Slit/Admin/opprettAdmin.jsp">Admin</a>
    <a class="active" href="/Slit/ModuleDescriptionAndDelivery.jsp">Moduler</a>
    <div class="knapperHoyre">
        <a href="/Slit/MyPage">Min side</a>
        <a href="Logout">Logout</a>
    </div>
</div>
<div class="sidenav">
    <div class="sidenavContent">
        <p>Her kan feedback og progresjonsplanen ligge</p>
        <form action="ReadFeedback.jsp">
            <input type="submit" name="feedback" value="Feedback">
        </form>
    </div>
</div>
<main class="main">
    <h1>Moduler</h1>
    <form action="/Slit/ViewModule" method="post" id="getModule">
        <a href="ModuleDescriptionAndDelivery.jsp">
            <input type="submit" name="module1" value="Modul 1"/>
            <input type="submit" name="module2" value="Modul 2"/>
            <input type="submit" name="module3" value="Modul 3"/>
            <input type="submit" name="module4" value="Modul 4"/>
            <input type="submit" name="module5" value="Modul 5"/>
        </a>
        <br>
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
    <form method="POST" action="/Slit/Upload" enctype="multipart/form-data">
        Last opp din fil her:
        <br>
        <label for="file-upload" class="custom-file-upload">
            Velg fil
        </label>
        <br>
        <input id="file-upload" type="file" value="Velg fil" name="file"/>
        <br>
        <input type="submit" value="Last opp" name="upload" id="upload"/>
        <p>${message}</p>
        <c:remove var="message" scope="session"/>
    </form>
    <button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
</main>
</body>
</html>
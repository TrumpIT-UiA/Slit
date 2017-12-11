<%@ page import="users.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) session.getAttribute("user");%>
<!-- Hentet fra https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_webpage&stacked=h -->
<!DOCTYPE html>
<html lang="no">
<head>
    <title>Modulbeskrivelse & Innlevering</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/Slit/Templates/CSS/MainPageTemplate.css">
    <script src="../Templates/Javascript/goToTop.js"></script>
</head>
<body>
<div class="navbar">
    <a href="/Slit/ModuleDescriptionAndDelivery.jsp">&Sopf;&Lopf;&Iopf;&Topf;</a>
    <a href="Admin/opprettAdmin.jsp">Admin</a>
    <a class="active" href=/Slit/ModuleDescriptionAndDelivery.jsp">Moduler</a>
    <div class="knapperHoyre">
        <a href="MyPage">Min side</a>
        <a href="Logout">Logout</a>
    </div>
</div>
<div class="sidenav">
    <label for="sidebarFeedback" class="sidenavContent">
        Feedback
    </label>
    <br>
    <label for="sidebarProgPlan" class="sidenavContent" style="margin-bottom: 20px;">
        Din progresjon
    </label>
    <form action="/Slit/ReadFeedback.jsp">
        <input type="submit" id="sidebarFeedback" class="sidebarFeedback">
    </form>
    <form action="/Slit/ProgressionPlan" method="post">
        <input type="submit" id="sidebarProgPlan" class="sidebarProgPlan">
    </form>
</div>
<main class="main">
    <div class="modulInfo">
        <h1>Moduler</h1>
        <h2>${moduleError}</h2>
        <c:remove var="moduleError" scope="session"/>
        <form action="/Slit/ViewModule" method="post" id="getModule" accept-charset="UTF-8">
            <a style="display: inline;" href="ModuleDescriptionAndDelivery.jsp">
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

            <h3>Approval Criterias: </h3>
            <p>${approvalCriterias}</p>
            <c:remove var="approvalCriterias" scope="session"/>

            <h3>Tasks:</h3>
            <p>${tasks}</p>
            <c:remove var="tasks" scope="session"/>

            <h3>Hjelpemidler:</h3>
            <p>${resources}</p>
            <c:remove var="resources" scope="session"/>

            <h3>Deadline:</h3>
            <p>${deadline}</p>
            <c:remove var="deadline" scope="session"/>
            <br>
        </form>
    </div>
    <div class="opplastningsseksjon">
        <h2>Her kan du laste opp din innlevering til modul ${mNr}!</h2>
        <c:remove var="mNr" scope="session"/>
        <p>NB! Filen du laster opp må være en zip-fil og kan ikke være større enn 10Mib.</p>
        <form method="POST" action="/Slit/Upload" enctype="multipart/form-data" id="uploadForm">
            Last opp din fil her:
            <br>
            <label for="file-upload" class="custom-file-upload">
                Velg fil
            </label>
            <br>
            <input id="file-upload" type="file" value="Velg fil" name="file"/>
            <br>
            <input type="submit" value="Last opp" name="upload" id="upload"/>
        </form>
        <textarea name="studComment" style="margin-top: 30px" form="uploadForm" id="comment" placeholder="Her kan du skrive en kommentar til innleveringen hvis du har lyst"></textarea>
        <p style="margin-top: -15px">${message}</p>
        <c:remove var="message" scope="session"/>
        <a>
            <button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
        </a>
    </div>
</main>
</body>
</html>
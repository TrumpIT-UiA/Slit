<%@ page import="users.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) session.getAttribute("user");%>
<!-- Hentet fra https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_webpage&stacked=h -->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Slit</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/Slit/MainPageTemplate.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="navbar">
    <a href="/Slit/ModuleDescriptionAndDelivery.jsp">Slit</a>
    <a href="/Slit/Admin/opprettAdmin.jsp">Admin</a>
    <a class="active" href="/Slit/ModuleDescriptionAndDelivery.jsp">Moduler</a>

    <a style="float:right" href="Logout">Logout</a>
    <a style="float:right" href="/Slit/MyPage">MyPage</a>
</div>
<div class="sidenav">
    <div class="sidenavContent">
        <p>Her kan feedback og progresjonsplanen ligge</p>
        <form action="ReadFeedback" method="post" name="feedbackForm">
            <input type="hidden" name="hdnbt" />
            <input type="button" value="Feedback" name="feedback" onclick="{document.feedbackForm.hdnbt.value=this.value;document.feedbackForm.submit();}">
        </form>
    </div>
</div>
<main class="main">
    <div class="uploadContent">
        <form action="/Slit/ViewModule" method="post" id="getModule">
            <a href="ModuleDescriptionAndDelivery.jsp">
                <input type="submit" name="module1" value="Modul 1"/>
                <input type="submit" name="module2" value="Modul 2"/>
                <input type="submit" name="module3" value="Modul 3"/>
                <input type="submit" name="module4" value="Modul 4"/>
                <input type="submit" name="module5" value="Modul 5"/>
            </a>

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
            <input type="file" name="file" id="file"/> <br/>
            <input type="submit" value="Upload" name="upload" id="upload"/>
            <p>${message}</p>
            <c:remove var="message" scope="session"/>
        </form>
    </div>
</main>

</body>
</html>
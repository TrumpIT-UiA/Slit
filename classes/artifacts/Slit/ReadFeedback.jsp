<%@ page import="users.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) session.getAttribute("user");%>
<!-- Hentet fra https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_webpage&stacked=h -->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Feedback Til Moduler</title>
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
        <a href="/Slit/MyPage">MyPage</a>
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
<h1>Feedback</h1>
<h2>Trykk på en knapp for å vise feedback til din leverte modul</h2>
    <a href="ModuleDescriptionAndDelivery.jsp">
        <input type="submit" name="module1" value="Modul 1"/>
        <input type="submit" name="module2" value="Modul 2"/>
        <input type="submit" name="module3" value="Modul 3"/>
        <input type="submit" name="module4" value="Modul 4"/>
        <input type="submit" name="module5" value="Modul 5"/>
    </a>
    <h3>Modul ${modulnr}</h3>
    <p>${score}</p>
<c: remove var="score" scope="session"/>

<p>${feedbackContent}</p>
<c: remove var="feedbackContent" scope="session"/>
</main>
<!-- Denne knappen skal alltid ligge til slutt i main!!! -->
<button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
</body>

</html>

<%@ page import="users.User" %>
<%@ page language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<% User user = (User) session.getAttribute("user");%>
<!-- Hentet fra https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_webpage&stacked=h -->
<!DOCTYPE html>
<html lang="no">
<head>
    <title>Feedback Til Moduler</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
    <label for="sidebarFeedback" class="sidenavContent">
        Feedback
    </label>
    <br>
    <label for="sidebarProgPlan" class="sidenavContent" style="margin-bottom: 20px;">
        Din progresjon
    </label>
    <form action="ReadFeedback.jsp">
        <input type="submit" id="sidebarFeedback" class="sidebarFeedback">
    </form>
    <form action="Progresjonsplan">
        <input type="submit" id="sidebarProgPlan" class="sidebarProgPlan">
    </form>
</div>
<main class="main" style="margin-left: 40px">
    <h1>Feedback</h1>
    <h2 >Trykk p&aring; en knapp for &aring; vise feedback til din leverte modul</h2>
    <h3>${error}</h3>
    <form action="/Slit/ReadFeedback" method="post">
        <a href="ReadFeedback.jsp">
            <input type="submit" name="module1" value="Modul 1"/>
            <input type="submit" name="module2" value="Modul 2"/>
            <input type="submit" name="module3" value="Modul 3"/>
            <input type="submit" name="module4" value="Modul 4"/>
            <input type="submit" name="module5" value="Modul 5"/>
        </a>
        <br>
        <h3>Modul ${modulnr}</h3>

        <h4>Score: </h4>
        <p>${score}</p>
        <c: remove var="score" scope="session"/>

        <h4>Feedback:</h4>
        <p>${feedbackContent}</p>
        <c: remove var="feedbackContent" scope="session"/>

        <h4>Tidspunkt feedback ble lastet opp: </h4><p>${timewritten}</p>
        <c: remove var="timewritten" scope="session"/>
    </form>
</main>
<!-- Denne knappen skal alltid ligge til slutt i main!!! -->
<button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
</body>

</html>

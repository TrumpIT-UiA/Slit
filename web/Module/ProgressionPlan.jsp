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
    <link rel="stylesheet" type="text/css" href="../Templates/CSS/MainPageTemplate.css">
    <link rel="stylesheet" type="text/css" href="../Templates/CSS/barChartStylesheet.css">
    <script src="../Templates/Javascript/goToTop.js"></script>

</head>
<body>
<div class="navbar">
    <a href="ModuleDescriptionAndDelivery.jsp">Slit</a>
    <a href="/Admin/opprettAdmin.jsp">Admin</a>
    <a class="active" href="/Slit/ModuleDescriptionAndDelivery.jsp">Moduler</a>
    <div class="knapperHoyre">
        <a href="/Slit/MyPage">Min side</a>
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
    <form action="/Slit/ProgressionPlan" method="post">
        <input type="submit" id="sidebarProgPlan" class="sidebarProgPlan">
    </form>
</div>
<main style="margin-top: 200px; margin-left: 500px;">
    <div class="bars">
        <div id="bar1">Modul 1</div>
        <div id="bar2">Modul 2</div>
        <div id="bar3">Modul 3</div>
        <div id="bar4">Modul 4</div>
        <div id="bar5">Modul 5</div>
    </div>
</main>
<button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
</body>
</html>

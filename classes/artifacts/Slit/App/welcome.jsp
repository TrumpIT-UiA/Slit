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
    <script src="Templates/Javascript/goToTop.js"></script>
</head>
<body>
<div class="navbar">
    <a href="/Slit/App/welcome.jsp">&Sopf;&Lopf;&Iopf;&Topf;</a>
    <a href="Admin/opprettAdmin.jsp">Admin</a>
    <a class="active" href="/Slit/ModuleDescriptionAndDelivery.jsp">Moduler</a>
    <div class="knapperHoyre">
        <a href="MyPage">Min side</a>
        <a href="/Slit/ProgressionPlan.jsp">Logout</a>
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
    <a>
        <button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
    </a>
</main>
</body>
</html>
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
    <a href="/Slit/App/welcome.jsp">Slit</a>
    <a href="/Slit/Admin/AdminPage.jsp">Admin</a>
    <a href="/Slit/Test">Test</a>
    <a class="active" href="/Slit/Module/ModuleDescriptionAndDelivery.jsp">Moduler</a>
    <div class="knapperHoyre">
        <a href="#">Min side</a>
        <a href="#">Logout</a>
    </div>
</div>

<main class="main">
    <a>
        <button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
    </a>
</main>
</body>
</html>
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
<h1>Feedback til dine leverte moduler</h1>
<p>${score}</p>
<c: remove var="score" scope="session"/>

<p>${feedbackContent}</p>
<c: remove var="feedbackContent" scope="session"/>



</body>

</html>

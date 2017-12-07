<%@ page import="users.User" %>
<%@ page language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<% User user = (User) session.getAttribute("user");%>
<!-- Hentet fra https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_webpage&stacked=h -->
<!DOCTYPE html>
<html lang="no">
<head>
    <title>Feedback Til Moduler</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="/Slit/MainPageTemplate.css">
    <script src="functions.js"></script>
</head>
<body>
<div class="navbar">
    <a href="/Slit/ModuleDescriptionAndDelivery.jsp">&Sopf;&Lopf;&Iopf;&Topf;</a>
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
    <h1>Skriv feedback</h1>
    <form action="/Slit/WriteFeedback" method="post" id="writeFeedbackForm">
        <label><input type="radio" name="module" value="1"> Modul 1</label><br>
        <label><input type="radio" name="module" value="2"> Modul 2</label><br>
        <label><input type="radio" name="module" value="3"> Modul 3</label><br>
        <label><input type="radio" name="module" value="4"> Modul 4</label><br>
        <label><input type="radio" name="module" value="5"> Modul 5</label><br>

        <p>${errorMessage}</p>
        <c:remove var="errorMessage" scope="session"/>


        <input type="number" name="score" value="Skriv inn score - range 1-10" min="1" max="10">
        <input type="submit" value="Lagre">
    </form>

    <textarea name="comment" form="writeFeedbackForm" placeholder="Skriv kommentar til studenten her..."></textarea>
    <textarea name="hiddenComment" form="writeFeedbackForm"
              placeholder="Skriv gjemt kommentar til andre lærere her..."></textarea>
</main>
<!-- Denne knappen skal alltid ligge til slutt i main!!! -->
<button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
</body>
</html>

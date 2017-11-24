<%@ page import="users.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) session.getAttribute("user");%>
<!-- Hentet fra https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_webpage&stacked=h -->
<!DOCTYPE html>
<html lang="no">
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
<main class="main" style="margin-left: 40px">
    <h1>Vennligst oppgi informasjon til modulen i feltene under</h1>
    <h4>Dersom modulen allerede finnes vil kun de feltene du fyller ut bli med i den nye modulenbeskrivelsen.</h4>
    <h3>Eksempel: Hvis du endrer alle feltene bortsett fra "Learning goals" vil ikke "Learning goals" bli oppdatert i
        systemet og derfor vil den tidligere verdien vil bli vist.</h3>
    <form action="/Slit/newModule" method="post" id="newM" accept-charset="UTF-8">
        <label><input type="radio" name="module" value="1"> Modul 1</label><br>
        <label><input type="radio" name="module" value="2"> Modul 2</label><br>
        <label><input type="radio" name="module" value="3"> Modul 3</label><br>
        <label><input type="radio" name="module" value="4"> Modul 4</label><br>
        <label><input type="radio" name="module" value="5"> Modul 5</label><br>

        <p>${errorMessage}</p>
        <c:remove var="errorMessage" scope="session"/>
    </form>
    <div>
        Læringsmål: <br>
        <textarea name="learningGoals" form="newM" placeholder="Skriv om læringsmål her"></textarea>
        <br>
        Oppgavebeskrivelse: <br>
        <textarea name="tasks" form="newM" placeholder="Skriv selve oppgavebeskrivelsen her"></textarea> <br>
        Hjelpemidler: <br>
        <textarea name="resources" form="newM" placeholder="List opp hjelpemidler her"></textarea> <br>
        Approval criteria: <br>
        <textarea name="approvalCriteria" form="newM" placeholder="Skriv om approval criterias her"></textarea>
        <br>
        Deadline: <br>
        <input type="date" name="deadline" form="newM"><p> NB! Datoen vil bli skrevet ut i følgende format: yyyy-mm-dd</p><br>
        <input type="submit" value="Last opp" form="newM" style="margin-bottom: 1cm">
        <input type="reset" value="Reset" form="newM" style="margin-bottom: 1cm">
    </div>
</main>
<button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
</body>
</html>

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
    <a href="/Slit/ModuleDescriptionAndDelivery.jsp">&Sopf;&Lopf;&Iopf;&Topf;</a>
    <a href="/Slit/Admin/opprettAdmin.jsp">Admin</a>
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
    <form action="Progresjonsplan">
        <input type="submit" id="sidebarProgPlan" class="sidebarProgPlan">
    </form>
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
    <div class="tooltip">Spesialtegn for Mac
        <span class="tooltiptext">
            &#8997; + A |  <br>
            &#8997; + Q | • <br>
            &#8679; + &#8997; + N | “ <br>
            &#8679; + &#8997; + M | ” <br>
            &#8679; + &#8997; + 8 | { <br>
            &#8679; + &#8997; + 9 | }
        </span>
    </div>
    <div class="tooltip">Spesialtegn for Windows
        <span class="tooltiptext" style="width: 200px; left: 55px;">
            FN + ALT + 0149 | •<br>
            &uArr; Går ikke uten numerisk tastatur<br>
            <span style="font-family: Wingdings">&#255;</span> + D | show/hide desktop<br>
            <span style="font-family: Wingdings">&#255;</span> + L | lås maskin <br>

        </span>
    </div>
    <div class="tooltip">Spesialtegn i HTML
        <span class="tooltiptext">
            &amp;bull; | &bull;<br>
            &amp;infin; | &infin;<br>
            &amp;real; |  &real;<br>
            &amp;spades; | &spades;<br>
            &amp;clubs; | &clubs;<br>
            &amp;hearts; | &hearts;<br>
            &amp;diams; | &diams;
        </span>
    </div>
    <div>
        <br>
        Læringsmål: <br>
        <textarea name="learningGoals" form="newM" placeholder="Skriv om læringsmål her"></textarea>

        <br>
        Oppgavebeskrivelse: <br>
        <textarea name="tasks" form="newM" placeholder="Skriv selve oppgavebeskrivelsen her"></textarea> <br>

        <br>
        Hjelpemidler: <br>
        <textarea name="resources" form="newM" placeholder="List opp hjelpemidler her"></textarea> <br>

        <br>
        Approval criteria: <br>
        <textarea name="approvalCriterias" form="newM" placeholder="Skriv om approval criterias her"></textarea>

        <br>
        Deadline: <br>
        <input type="date" name="deadline" form="newM">
        <p> NB! Datoen vil bli skrevet ut i følgende format: yyyy-mm-dd</p><br>
        <input type="submit" value="Last opp" form="newM" style="margin-bottom: 1cm">
        <input type="reset" value="Reset" form="newM" style="margin-bottom: 1cm">
    </div>
</main>
</body>
</html>

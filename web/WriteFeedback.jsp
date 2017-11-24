<%--
  Created by IntelliJ IDEA.
  User: Emil-Ruud
  Date: 13/11/2017
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Slit</title>
</head>
<body>
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

<textarea name="feedback" form="writeFeedbackForm" placeholder="Skriv feedback her..."></textarea>

</body>
</html>

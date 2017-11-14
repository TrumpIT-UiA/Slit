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
    <input type="number" name="score" value="Skriv inn score - range 1-10" min="1" max="10">
    <input type="submit" value="Lagre">
</form>

<textarea name="feedback" form="writeFeedbackForm">Skriv feedback her...</textarea>

</body>
</html>

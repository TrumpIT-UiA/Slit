<%--
  Created by IntelliJ IDEA.
  User: Emil-Ruud
  Date: 03/11/2017
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SLIT Delivery</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <p>Trykk på en knappene for å vise den modulen du vil se! Modulen vil bli vist i dette vinduet :) </p>
    <p>${message}</p>
    <c:remove var="message" scope="session"/>
</body>
</html>
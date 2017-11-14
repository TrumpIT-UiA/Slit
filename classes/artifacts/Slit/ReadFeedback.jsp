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

<p>${score}</p>
<c: remove var="score" scope="session"/>

<p>${feedbackContent}</p>
<c: remove var="feedbackContent" scope="session"/>

</body>
</html>

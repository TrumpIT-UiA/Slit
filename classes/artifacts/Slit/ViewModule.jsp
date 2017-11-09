<%--
  Created by IntelliJ IDEA.
  User: Emil-Ruud
  Date: 06/11/2017
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    Module test
</head>
<body>
<form id="id" method="get" action="ViewModule">

    Modul nr: <p>${mNr}</p>
    <c:remove var="mNr" scope="session"/>

    Mål: <p>${goals}</p>
    <c:remove var="goals" scope="session"/>

    Hjelpemidler: <p>${resources}</p>
    <c:remove var="resources" scope="session"/>

    Deadline: <p>${deadline}</p>
    <c:remove var="deadline" scope="session"/>

    Approval Criterias: <p>${approvalCriterias}</p>
    <c:remove var="approvalCriterias" scope="session"/>

    Tasks: <p>${tasks}</p>
    <c:remove var="tasks" scope="session"/>

</form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Slit</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Velkommen til Slit, hva ønsker du å gjøre?</h1>
<form action="/Slit/Login.jsp" method="post">
  <input type="submit" value="Logge inn">
</form>

  <form action="/Slit/NewStudent.jsp" method="post">
    <input type="submit" value="Opprette ny bruker">
  </form>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
    <title>Slit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Vennligst oppgi informasjon til modulen i feltene under</h1>
<form action="/Slit/newModule" method="post">
    <input type="radio" name="module" value="1" checked> Modul 1<br>
    <input type="radio" name="module" value="2"> Modul 2<br>
    <input type="radio" name="module" value="3"> Modul 3<br>
    <input type="radio" name="module" value="4"> Modul 4<br>
    <input type="radio" name="module" value="5"> Modul 5<br>

    Learning goals: <input name="learningGoals" type="text"><br>
    Resources: <input name="resources" type="text"><br>
    Tasks: <input name="tasks" type="text"><br>
    Approval criteria: <input name="approvalCriteria" type="text"><br>
    Deadline: <input name="deadline" type="text"><br>
    <input type="submit" value="Lagre">
</form>

</body>
</html>

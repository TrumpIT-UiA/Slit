<!DOCTYPE html>
<html>
<head>
    <title>Slit</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<h1>Vennligst oppgi informasjon til modulen i feltene under</h1>
<h4>Dersom modulen allerede finnes vil kun de feltene du fyller ut bli med i den nye modulenbeskrivelsen.</h4>
<h4>Eksempel: Hvis du endrer alle feltene bortsett fra "Learning goals" vil ikke "Learning goals" bli oppdatert i systemet og derfor vil den tidligere verdien vil bli vist.</h4>
<form action="/Slit/newModule" method="post" id="newM">
    <input type="radio" name="module" value="1"> Modul 1<br>
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

    <textarea name="comment" form="newM">Enter text here...</textarea>

    <p>${errorMessage}</p>
    <c:remove var="errorMessage" scope="session"/>
</form>

</body>
</html>

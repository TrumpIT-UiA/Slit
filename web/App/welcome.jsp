<!-- Hentet fra https://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_temp_webpage&stacked=h -->
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Slit</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/Slit/Templates/CSS/MainPageTemplate.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/Slit/App/welcome.jsp">Slit</a>
        </div>

        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/Slit/App/welcome.jsp">Home</a></li>
                <li><a href="/Slit/Admin/NewUser.jsp">Admin</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href=#>Min Side</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logg ut</a></li>

            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
        </div>

        <div class="col-sm-8 text-left">

            <h1>Velkommen til slit!</h1>
        </div>

        <div class="col-sm-2 sidenav">

        </div>
    </div>
</div>
</body>
</html>

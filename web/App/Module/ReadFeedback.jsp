<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!--Interphase by TEMPLATED
templated.co @templatedco
Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
Modified for use in SLIT -->
<html lang="en">
<head>
    <!-- <meta charset="UTF-8"> -->
    <title>Slit</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />

    <script src="../../Static/js/jquery.min.js"></script>
    <script src="../../Static/js/skel.min.js"></script>
    <script src="../../Static/js/skel-layers.min.js"></script>
    <script src="../../Static/js/init.js"></script>

    <link rel="stylesheet" href="../../Static/Styles/skel.css" />
    <link rel="stylesheet" href="../../Static/Styles/style.css" />
    <link rel="stylesheet" href="../../Static/Styles/style-xlarge.css" />
</head>

<body>
<!-- Header -->
<header id="header">
    <h1><a href="../../App/welcome.jsp">Slit</a></h1>
    <nav id="nav">
        <ul>
            <li><a href="../../App/Module/welcome.jsp">Home</a></li>
            <li><a href="../../App/Module/ViewModule.jsp">Moduler</a></li>
            <li><a href="../../Admin/AdminPage.jsp">Admin</a></li>
        </ul>
    </nav>
</header>

<!-- Main -->
<section id="main" class="wrapper">
    <div class="container">

        <header class="major">
            <h2>Feedback</h2>
            <p>Trykk p&aring; en knapp for &aring; vise feedback til din leverte modul</p>
        </header>

        <!-- <a href="#" class="image fit"><img src="../Static/images/pic08.jpg" alt="" /></a> -->
            <h2></h2>
            <h3 ></h3>
            <h3>${feedbackError}</h3>
            <form action="/Slit/ReadFeedback" method="post">
                <a href="ReadFeedback.jsp">
                    <input type="submit" name="module1" value="Modul 1"/>
                    <input type="submit" name="module2" value="Modul 2"/>
                    <input type="submit" name="module3" value="Modul 3"/>
                    <input type="submit" name="module4" value="Modul 4"/>
                    <input type="submit" name="module5" value="Modul 5"/>
                </a>
                <br>
                <h3>Modul ${modulnr}</h3>

                <h4>Score: </h4>
                <p>${score}</p>

                <h4>Feedback:</h4>
                <p>${comment}</p>

                <h4>Tidspunkt feedback ble lastet opp: </h4>
                <p>${timewritten}</p>
            </form>
    </div>
</section>

<!-- Footer -->
<footer id="footer">
    <div class="container">
        <div class="row">
            <section class="4u$ 12u$(medium) 12u$(small)" id="test">
                <h3>Kontakt oss</h3>
                <ul class="icons">
                    <li><a href="https://github.com/TrumpIT-UiA" class="icon rounded fa-github"><span class="label">Github</span></a></li>
                </ul>
            </section>
        </div>
        <ul class="copyright">
            <li>&copy; Untitled. All rights reserved.</li>
            <li>Design: <a href="http://templated.co">TEMPLATED</a></li>
            <li>Images: <a href="http://unsplash.com">Unsplash</a></li>
        </ul>
    </div>
</footer>
<!-- Denne knappen skal alltid ligge til slutt i main!!! -->
<button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
</body>

</html>

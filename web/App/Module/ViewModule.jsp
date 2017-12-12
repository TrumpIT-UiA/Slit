<%@ page contentType="text/html; charset=UTF-8" %>
<!--Interphase by TEMPLATED
templated.co @templatedco
Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
Modified for use in SLIT -->
<html lang="en">
<head>
    <!-- <meta charset="UTF-8"> -->
    <title>Slit</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>

    <script src="../../Static/js/jquery.min.js"></script>
    <script src="../../Static/js/skel.min.js"></script>
    <script src="../../Static/js/skel-layers.min.js"></script>
    <script src="../../Static/js/init.js"></script>
    <script src="../../Static/Javascript/goToTop.js"></script>

    <link rel="stylesheet" href="../../Static/Styles/skel.css"/>
    <link rel="stylesheet" href="../../Static/Styles/style.css"/>
    <link rel="stylesheet" href="../../Static/Styles/style-xlarge.css"/>

</head>

<body>
<!-- Header -->
<header id="header">
    <h1><a href="../../App/welcome.jsp">Slit</a></h1>
    <nav id="nav">
        <ul>
            <li><a href="../../App/welcome.jsp">Home</a></li>
            <li><a href="../../App/Module/ViewModule.jsp">Moduler</a></li>
            <li><a href="../../Admin/AdminPage.jsp">Admin</a></li>
        </ul>
    </nav>
</header>

<!-- Main -->
<section id="main" class="wrapper">
    <div class="container">

        <header class="major">
            <h2>Moduler</h2>
            <p>Her finner du modulene i IS-109 & IS-110<br>Trykk på en av knappene under for å vise informasjonen til modulen du vil se<br>Dersom du skal levere - gå til bunnen av siden</p>
        </header>

        <!-- <a href="#" class="image fit"><img src="../Static/images/pic08.jpg" alt="" /></a> -->
        <h3>${moduleError}</h3>
        <c:remove var="moduleError" scope="session"/>
        <form action="/Slit/ViewModule" method="post" id="getModule" accept-charset="UTF-8">
            <a style="display: inline;" href="ModuleDescriptionAndDelivery.jsp">
                <input type="submit" name="module1" value="Modul 1"/>
                <input type="submit" name="module2" value="Modul 2"/>
                <input type="submit" name="module3" value="Modul 3"/>
                <input type="submit" name="module4" value="Modul 4"/>
                <input type="submit" name="module5" value="Modul 5"/>
            </a>
            <br>
            <br>
            <h2>Modul ${mNr}</h2>
            <c:remove var="mNr" scope="session"/>

            <h3>Mål:</h3>
            <p>${goals}</p>
            <c:remove var="goals" scope="session"/>

            <h3>Akseptansekriterier: </h3>
            <p>${approvalCriterias}</p>
            <c:remove var="approvalCriterias" scope="session"/>

            <h3>Oppgaver:</h3>
            <p>${tasks}</p>
            <c:remove var="tasks" scope="session"/>

            <h3>Hjelpemidler:</h3>
            <p>${resources}</p>
            <c:remove var="resources" scope="session"/>

            <h3>Innleveringsfrist:</h3>
            <p>${deadline}</p>
            <c:remove var="deadline" scope="session"/>
            <br>
        </form>
        <h2>Her kan du laste opp din innlevering til modul ${mNr}!</h2>
        <c:remove var="mNr" scope="session"/>
        <p>NB! Filen du laster opp må være en zip-fil og kan ikke være større enn 10Mib.</p>
        <form method="POST" action="/Slit/Upload" enctype="multipart/form-data" id="uploadForm">
            Last opp din fil her:
            <br>
            <label for="file-upload" class="chooseFile">
                Velg fil
            </label>
            <br>
            <input id="file-upload" type="file" value="Velg fil" name="file" style="opacity: 0"/>
            <br>
            <input type="submit" value="Last opp" name="upload" id="upload"/>
        </form>
        <textarea name="studComment" style="margin-top: 30px" form="uploadForm" id="comment"
                  placeholder="Her kan du skrive en kommentar til innleveringen"></textarea>
        <p>${message}</p>
        <c:remove var="message" scope="session"/>
    </div>
</section>

<!-- Footer -->
<footer id="footer">
    <div class="container">
        <div class="row">
            <section class="4u$ 12u$(medium) 12u$(small)">
                <h3>Kontakt oss</h3>
                <ul class="icons">
                    <li><a href="https://github.com/TrumpIT-UiA" class="icon rounded fa-github"><span class="label">Github</span></a>
                    </li>
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
<a>
    <button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
</a>
</body>
</html>
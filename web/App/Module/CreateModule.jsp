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
            <div class="dropdown">
                <button onclick="myFunction()" class="dropbtn">Moduler</button>
                <div id="myDropdown" class="dropdown-content">
                    <a href="../../App/Module/ViewModule.jsp">Moduler</a>
                    <a href="../../App/Module/ReadFeedback.jsp">Feedback</a>
                    <a onclick="progression()">Progresjonsplan</a>
                </div>
            </div>
            <script>
                function progression() {
                    document.getElementById("progressionplan").submit();
                }
            </script>
            <script>
                /* When the user clicks on the button,
                toggle between hiding and showing the dropdown content */
                function myFunction() {
                    document.getElementById("myDropdown").classList.toggle("show");
                }

                // Close the dropdown if the user clicks outside of it
                window.onclick = function (event) {
                    if (!event.target.matches('.dropbtn')) {
                        var dropdowns = document.getElementsByClassName("dropdown-content");
                        var i;
                        for (i = 0; i < dropdowns.length; i++) {
                            var openDropdown = dropdowns[i];
                            if (openDropdown.classList.contains('show')) {
                                openDropdown.classList.remove('show');
                            }
                        }
                    }
                }
            </script>
            <li><a href="../../Admin/AdminPage.jsp">Admin</a></li>
        </ul>
    </nav>
</header>

<!-- Main -->
<section id="main" class="wrapper">
    <div class="container">

        <header class="major">
            <h2>Opprett en ny modul</h2>
            <p>Dersom du skal endre på en allerede eksisterende modul trenger du bare å velge modulnummer, fylle ut feltene du vil endre og legge inn deadline
                <br>Eksempel: Hvis du endrer alle feltene bortsett fra "Learning goals" vil ikke "Learning goals" bli oppdatert i
                databasen og derfor vil den som tidligere ble skrevet bli vist.
            </p>
        </header>

        <!-- <a href="#" class="image fit"><img src="../Static/images/pic08.jpg" alt="" /></a> -->
        <form action="/Slit/newModule" method="post" id="newM" accept-charset="UTF-8">
            <label><input type="radio" name="module" value="1"> Modul 1</label><br>
            <label><input type="radio" name="module" value="2"> Modul 2</label><br>
            <label><input type="radio" name="module" value="3"> Modul 3</label><br>
            <label><input type="radio" name="module" value="4"> Modul 4</label><br>
            <label><input type="radio" name="module" value="5"> Modul 5</label><br>

            <p>${errorMessage}</p>
            <c:remove var="errorMessage" scope="session"/>
        </form>
        <div class="tooltip">Spesialtegn for Mac
            <span class="tooltiptext">
            &#8997; + A |  <br>
            &#8997; + Q | • <br>
            &#8679; + &#8997; + N | “ <br>
            &#8679; + &#8997; + M | ” <br>
            &#8679; + &#8997; + 8 | { <br>
            &#8679; + &#8997; + 9 | }
        </span>
        </div>
        <div class="tooltip">Spesialtegn for Windows
            <span class="tooltiptext" style="width: 200px; left: 55px;">
            FN + ALT + 0149 | •<br>
            &uArr; Går ikke uten numerisk tastatur<br>
            <span style="font-family: Wingdings">&#255;</span> + D | show/hide desktop<br>
            <span style="font-family: Wingdings">&#255;</span> + L | lås maskin <br>

        </span>
        </div>
        <div class="tooltip">Spesialtegn i HTML
            <span class="tooltiptext">
            &amp;bull; | &bull;<br>
            &amp;infin; | &infin;<br>
            &amp;real; |  &real;<br>
            &amp;spades; | &spades;<br>
            &amp;clubs; | &clubs;<br>
            &amp;hearts; | &hearts;<br>
            &amp;diams; | &diams;
        </span>
        </div>
        <div>
            <br>
            Læringsmål: <br>
            <textarea name="learningGoals" form="newM" placeholder="Skriv om læringsmål her"></textarea>

            <br>
            Oppgavebeskrivelse: <br>
            <textarea name="tasks" form="newM" placeholder="Skriv selve oppgavebeskrivelsen her"></textarea> <br>

            <br>
            Hjelpemidler: <br>
            <textarea name="resources" form="newM" placeholder="List opp hjelpemidler her"></textarea> <br>

            <br>
            Approval criteria: <br>
            <textarea name="approvalCriterias" form="newM" placeholder="Skriv om approval criterias her"></textarea>

            <br>
            Deadline: <br>
            <input type="date" name="deadline" form="newM">
            <p> NB! Datoen vil bli skrevet ut i følgende format: yyyy-mm-dd</p><br>
            <input type="submit" value="Last opp" form="newM" style="margin-bottom: 1cm">
            <input type="reset" value="Reset" form="newM" style="margin-bottom: 1cm">
        </div>
    </div>
</section>

<!-- Footer -->
<footer id="footer">
    <div class="container">
        <div class="row">
            <section class="4u$ 12u$(medium) 12u$(small)" id="test">
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
</body>
</html>
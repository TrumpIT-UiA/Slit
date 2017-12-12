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

		<script src="../Static/js/jquery.min.js"></script>
		<script src="../Static/js/skel.min.js"></script>
		<script src="../Static/js/skel-layers.min.js"></script>
		<script src="../Static/js/init.js"></script>

		<link rel="stylesheet" href="../Static/Styles/skel.css" />
		<link rel="stylesheet" href="../Static/Styles/style.css" />
		<link rel="stylesheet" href="../Static/Styles/style-xlarge.css" />
	</head>

	<body>
		<!-- Header -->
			<header id="header">
				<h1><a href="../App/welcome.jsp">Slit</a></h1>
				<nav id="nav">
					<ul>
						<li><a href="../App/welcome.jsp">Home</a></li>
						<div class="dropdown">
							<button onclick="myFunction()" class="dropbtn">Moduler</button>
							<div id="myDropdown" class="dropdown-content">
								<a href="../../App/Module/ReadFeedback.jsp">Feedback</a>
								<a href="../../App/Module/ViewModule.jsp">Moduler</a>
								<a href="/Slit/ProgressionPlan">Progresjonsplan</a>
							</div>
						</div>
						<script>
                            /* When the user clicks on the button,
                            toggle between hiding and showing the dropdown content */
                            function myFunction() {
                                document.getElementById("myDropdown").classList.toggle("show");
                            }
                            // Close the dropdown if the user clicks outside of it
                            window.onclick = function(event) {
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
						<li><a href="../Admin/AdminPage.jsp">Admin</a></li>
					</ul>
				</nav>
			</header>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="container">

					<header class="major">
						<h2>Overskrift</h2>
						<p>Underoverskrift</p>
					</header>

					<!-- <a href="#" class="image fit"><img src="../Static/images/pic08.jpg" alt="" /></a> -->
					<p>Undertekst side</p>
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
	</body>
</html>
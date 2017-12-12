<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
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
			<li><a href="../../App/welcome.jsp">Home</a></li>
			<li><a href=#>Moduler</a></li>
			<li><a href="../../Admin/AdminPage.jsp">Admin</a></li>
		</ul>
	</nav>
</header>

<!-- Main -->
<section id="main" class="wrapper">
	<div class="container">

		<header class="major">
			<h2>Hei</h2>
			<p>Her er en liste over alle de leverte modulene</p>
		</header>

        <table>
		<c:forEach items="${ModulListe}" var="ModulFil">
            <tr>
                <th>Levert av</th>
                <th>Filnavn</th>
                <th>Kommentar</th>
                <th>Levert tid</th>
                <th></th>
            </tr>
            <tr>
                <td><c:out value="${ModulFil.getUserEmailFile()}"/></td>
				<td><c:out value="${ModulFil.getFilename()}"/></td>
				<td><c:out value="${ModulFil.getComment()}"/></td>
				<td><c:out value="${ModulFil.getDeliveredTime()}"/></td>
                <td></td>
            </tr>
        </table>
	</div>
</section>

<!-- Footer -->
<footer id="footer">
	<div class="container">
		<div class="row">
			<section class="4u$ 12u$(medium) 12u$(small)">
				<h3>Kontakt oss</h3>
				<ul class="icons">
					<li><a href="https://github.com/TrumpIT-UiA" class="icon rounded fa-github"><span class="label">Github</span></a></li>
				</ul>
			</section>
		</div>

		<ul class="copyright">
			<li>Design: <a href="http://templated.co">Templated</a></li>
			<li>Images: <a href="http://unsplash.com">Unsplash</a></li>
		</ul>
	</div>
</footer>
</body>
</html>
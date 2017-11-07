<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SLIT</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="stylesheet.css">
</head>
<body>

<ul>
    <li><a href="#slit">SLIT</a></li>
    <li><a href="#moduler">Moduler</a></li>
    <li><a href=#dinemoduler">Dine moduler</a></li>
    <li class="dropdown">
        <a href="javascript:void(0)" class="dropbtn">Progresjonsplan</a>
        <div class="dropdown-content">
            <a href="#deg">Deg</a>
            <a href="#klassen">Klassen</a>
            <a href="#midlertidig">(midlertidig)</a>
        </div>
    </li>
    <div style="float:right">
        <li class="dropdown">
            <a href="javascript:void(0)" class="dropbtn">Bruker</a>
            <div class="dropdown-content">
                <a href="#profil">Profil</a>
                <a href="#loggut">Logg ut</a>
            </div>
        </li>
        <li><a href="#settings">Settings</a></li>
    </div>
</ul>
<div style="text-align: center;">
    <h1>SLIT</h1>
    <p>Et førsteutkast som må forbedres</p>
</div>
<!--
******************************************************************************
––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––
Tekstbokser
______________________________________________________________________________
******************************************************************************
-->
<div class="textBoxTop">
    <h3>Neste innlevering</h3>
    <p>Modul nr: X</p>
    <p>Dato: XX.XX.XX</p>
</div>
<div class="textBoxMiddle">
    <h3>Deretter...</h3>
    <p>Modul nr: X</p>
    <p>Dato: XX.XX.XX</p>
</div>
<div class="textBoxBottom">
    <h3>Og deretter...</h3>
    <p>Modul nr: X</p>
    <p>Dato: XX.XX.XX</p>
</div>
<form action="Search">
    <input type="submit" value="Connection"/>
</form>
</body>
</html>
Checklist:

Bruker i SQL som heter Slit med passord Mongoper!
Og et schema med navn Slit  
En Java EE server konfigurert med java:/Slit som JNDI navn, med samme login som definert over


Følgende må legges til i Wildfly sin standalone.xml, om ikke det er gjort allerede :  
```xml
<security-domain name="Slit" cache-type = "default">
  <authentication>
    <login-module code="Database" flag="required">
      <module-option name="dsJndiName" value="java:/SlitDS"/>
      <module-option name="principalsQuery" value="select password from user where user=?"/>
      <module-option name="rolesQuery" value="select DTYPE from user where user=?"/>
    </login-module>
  </authentication>
</security-domain>
```

## Cheatsheet (triks i Ludo)

#### Cheat sheet for Mastering Markup lang:
[Orker ikke skrive om det, så trykk på denne linken](https://guides.github.com/features/mastering-markdown/)

#### For å sende et parameter til jsp:
Skriv følgende i en servlet:
```java
    String message = "Testing, testing... Dette vil ble skrevet i gitt jsp.";
    request.getSession().setAttribute("messageJSP", message);
    response.sendRedirect("FilenDuVilSendeParameteret.jsp");  
```
Skriv så følgende i jsp:
```html
   <p>${messageJSP}</p>
   <c:remove var="messageJSP" scope="session"/>
```

#### For å legge ut et parameter i session, samt hente fra session:
Hensikten med dette er å kunne sende parametere mellom servlets.
<br>NB! Kan ligge flere verdier i session, så vær påpasselig med navnet på attributten.

Servlet1:
```java
HttpSession session = request.getSession();
String exampleVar = "Dette er paramterets value";
session.setAttribute("exampleParameter", exampleVar);
```

Servlet2:
```java
HttpSession session = request.getSession();
String modulNummer = (String) session.getAttribute("exampleParameter");
```

#### For å legge til 'Go to top'-knapp:
Nesten all kode ligger i MainPageTemplate.css og functions.js. 
Trenger kun én linje for å legge til knappen i jsp-en (legg nederst rett før \</body>\)

```html
<button onclick="topFunction()" id="goToTop" title="Go to top">Gå til toppen</button>
```

For å få knappen til å fungere må du linke til scriptet i \<head>:

```html
<script src="functions.js"></script>
```

#### Skive javakode direkte i jsp (Marius hadde et godt eksempel på dette):

#### Sørge for at dataene fra formen har UTF-8 encoding:

```java
String learningGoals = new String( request.getParameter( "learningGoals").getBytes( "ISO-8859-1" ), "UTF-8" ); 
```

#### Ny pakke for å fikse line break:
Dette __må__ brukes i forbindelse med TextArea <br>
Brukes kun når du skal **skrive** til jsp (ikke hente parameteret fra jsp)

```java 
//"Diverse" er pakke jeg har selv har fikset. 

Diverse.DataRelated stringLinebreak = new Diverse.DataRelated();
request.getSession().setAttribute("learningGoals", stringLinebreak.LineBreak(learningGoals));
```


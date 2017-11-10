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
<br></br>
## Cheatsheet (triks i Ludo)
#### For å sende et parameter til jsp: 
Skriv følgende i en servlet: 
```java
    String message = "Testing, testing... Dette vil ble skrevet i gitt jsp.";
    request.getSession().setAttribute("message", message);
    response.sendRedirect("FilenDuVilSendeParameteret.jsp");  
```
Skriv så følgende i jsp:
```jsp
   <p>${message}</p>
   <c:remove var="message" scope="session"/>

```

#### For å legge ut et parameter i session
Hensikten med dette er å kunne sende parametere mellom servlets.
<br>NB! Kan ligge flere verdier i session, så vær påpasselig med navnet på attributten.

Servlet1: 
```java
HttpSession session = request.getSession();
exampleVar = "Dette er paramterets "value"";
session.setAttribute("exampleParameter", exampleVar);
```

Servlet2: 
```java
HttpSession session = request.getSession();
String modulNummer = (String) session.getAttribute("exampleParameter");
```

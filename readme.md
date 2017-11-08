Checklist:

Bruker i SQL som heter Slit med passord Mongoper! 
Og et schema med navn Slit  
En Java EE server konfigurert med java:/Slit som JNDI navn, med samme login som definert over 


Følgende må legges til i Wildfly sin standalone.xml, om ikke det er gjort allerede :  
```xml
<scurity-domain name="Slit" cache-type = "default">
  <authentication>
    <login-module code="Database" flag="required">
      <module-option name="dsJndiName" value="java:/SlitDS"/>
      <module-option name="principalsQuery" value="select password from user where user=?"/>
      <module-option name="rolesQuery" value="select DTYPE from user where user=?"/>
    </login-module>
  </authentication>
</security-domain>
```

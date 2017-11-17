Checklist:

Bruker i SQL som heter Slit med passord Mongoper!

Følgende må legges til i Wildfly sin standalone.xml 

```xml
<security-domain name="Slit" cache-type = "default">
  <depreceated.authentication>
    <login-module code="Database" flag="required">
      <module-option name="dsJndiName" value="java:/SlitDS"/>
      <module-option name="principalsQuery" value="select password from user where user=?"/>
      <module-option name="rolesQuery" value="select DTYPE from user where user=?"/>
    </login-module>
  </depreceated.authentication>
</security-domain>
```

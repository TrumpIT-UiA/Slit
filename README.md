# Slit

Hvordan få det til å virke: 
Last ned wildfly (http://wildfly.org/) og sett opp wildfly som en JBoss server (Wildfly er videreutviklingen av JBoss) i intellij 

Når dere har klonet og satt opp wildfly så velg (i intellij) File->Project Structure->Artifacts->Slit 
Her går dere inn i WEB-INF->lib og fjerner Maven: dom4j:dom4j:1.6.1 (denne finnes allerede i hibernate/jboss, blir konflikt med to versjoner) 

Husk å sjekke om prosjektet er lagt til i Wildfly konfigurasjonen, for å gjøre dette går dere på: 

Serverkonfigurasjon (Opp i høyre hjørnet, rett til venstre for den grønne "play" knappen  
og velger edit configuration. Deretter må dere velge Deployment og trykke på "+" knappen, og så legge til "Slit". 
Nå skal dere kunne kjøre prosjektet med fungerende EJB + JPA.

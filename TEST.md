Setup for running SampleProject in TEST environment
=================================================== 

Assembly and deploy
-------------------
* Single WAR, names onstage-dev.war
* Console deployed on the same Tomcat
* Tomcat listening on 8080 (http)


Set the environment
-------------------
In $TOMCAT_HOME/conf/catalina.properties add:
 `spring_profiles_active=onstage.env.preprod`
  
Start TCP H2 instance
---------------------

    <h2-install-dir>/bin/h2.sh -tcp -tcpAllowOthers -web

Writes data in the `/tmp` directory

**ATTENTION** 

DB ARE persistent between runs.
To restart data from scratch:

    rm /tmp/onairTest.*   
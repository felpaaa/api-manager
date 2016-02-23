SampleProject environments usage
================================

DEV
---
For running on developer machine.

* Single war deploy (PA+S+MC). Context name: `/onstage-dev`
* Console deployed in the same Tomcat
* Tomcat listening on 8080 
* PostgreSQL on `localhost` (onairTest)

TEST
----
For human testing with semi-persistent db

* Single war deploy (PA+S+MC). Context name: `/onstage-dev`
* Console deployed in the same Tomcat
* Tomcat listening on 8080 
* H2 tcp instance persisting locally in /tmp. To start H2 see [TEST.md](TEST.md)
* No Quartz Scheduler!


QA
--
For dev with Oracle DB

* Single war deploy (PA+S+MC). Context name: `/onstage-dev`
* Console deployed in the same Tomcat
* Tomcat listening on 8080 
* Oracle on `oracle11.z-c.office` (onairtest)

PREPROD
-------
For deploying in Docker

For details see [PREPROD.md](PREPROD.md)

PRODUCTION
----------

*TBD*
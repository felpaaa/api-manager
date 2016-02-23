
DISTRIBUTION ASSEMBLIES
=======================

Standalone/Development distribution
-----------------------------------
* **PA+S+MC modules**: single WAR directly built by <project>-dev module. Can be used in Eclipse
* ***Console module**: single WAR directly built by <project>-console module. Can be used in Eclipse
  

Server distributions
--------------------

**P,S and MC modules**

 
3 possible assembly schemes are available:

1. single WAR: PA+S+MC
2. 2 WARs: PA, S+MC
3. 3 WARs: PA, S, MC			
		
WARs for all possible schemes are build using (from the project directory):

    mvn package -Pdistribution
 
Depending on the deployment scheme, Spring Bean Profiles must be set appropriately (see below)
to configure gateways between modules at runtime.
  	  
**Console module**

Single WAR directly built by <project>-console module. Can be used in Eclipse


ASSEMBLY SCHEMES
================

Single WAR
----------
* WAR to use:				`<project>-pa-s-mc.war`
* Runtime Spring Profiles:	none required (optionally specify: `onair.pa-s.gw.mode.local,onair.s-mc.gw.mode.local`)
* Services/Persistence remoted from: Console only
* Webapp dirs from:		`<project>-pa/src/main/webapp`
* Logback file from:	`<project>-pa/src/main/config/logback.xml`

2 WARs (PA split from S+MC)
---------------------------
* WAR to use:				`<project>-pa.war, <project>-s-mc.war`
* Runtime Spring Profile:	`onair.pa-s.gw.mode.http` (optionally append: `,onair.s-mc.gw.mode.local`)
* Services/Persistence remoted from: PA and Console
* Webapp dirs from:		`<project>-pa/src/main/webapp` and `<project>-s/src/main/webapp`
* Logback files from:	`<project>-pa/src/main/config/logback.xml` and `<project>-s/src/main/config/logback.xml`
	
3 WARS (all module split)
-------------------------
* WAR to use:				`<project>-pa.war`, `<project>-s.war` and `<project>-mc.war`
* Runtime Spring Profile:	`onair.pa-s.gw.mode.http,onair.s-mc.gw.mode.http`
* Services/Persistence remoted from: PA, MC and Console
* Webapp dirs from:		`<project>-pa/src/main/webapp`, `<project>-s/src/main/webapp` and `<project>-mc/src/main/webapp`
* Logback files from:	`<project>-pa/src/main/config/logback.xml`, `<project>-s/src/main/config/logback.xml` and `<project>-mc/src/main/config/logback.xml`

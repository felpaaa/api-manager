PREPROD environment
===================

For deploying with Docker

TBD

Assembly options
----------------

**Single WAR**

Docker image, container-name --> linked to... : http port, remote debugging port, remote JMX port

1. onair/sampleproject:dbpg, onair_db
2. redis, onair_redis
3. onair/sampleproject:1war, onair_pa --> onair_db,onair_redis : 8888, 8000, 9000

Console on: `http://localhost:8888/onstage-console`
Info PA+S+MC: `http://localhost:8888/onstage/onAirInfo`

**2 WARs (PA, S+MC)**
	
1. onair/sampleproject:dbpg, onair_db
2. redis, onair_redis
3. onair/sampleproject:pa, onair_pa --> onair_s  : 8888, 8000, 9000
4. onair/sampleproject:smc, onair_s --> onair_db,onair_redis : 8887, 8001, 9001  

Console on: `http://localhost:8887/onstage-console`
Info Console: `http://localhost:8887/onstage-console/onAirInfo`
Info PA: `http://localhost:8888/onstage/onAirInfo`
Info S+MC: `http://localhost:8887/onstage/onAirInfo`
API base URL: `http://localhost:8888/onstage/`

**3 WARs (PA, S, MC)**

1. onair/sampleproject:dbpg, onair_db
2. redis, onair_redis
3. onair/sampleproject:pa, onair_pa --> onair_s : 8888, 8000, 9000
4. onair/sampleproject:s, onair_s --> onair_db,onair_redis : 8887, 8001, 9001
5. onair/sampleproject:mc, onair_mc -->  : 8886, 8002, 9002

Console on: `http://localhost:8887/onstage-console`

Accessing PostgreSQL and REDIS from host
----------------------------------------

* Host access PostgreSQL (of the onair_db container) on port 5431
* Host access REDIS (of the onair_redis container) on port 6378
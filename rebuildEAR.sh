#/bin/bash
mvn -U clean install -DskipTests
cd ${ONAIR_PROJECTNAME}-dist
mvn -U -Pdistribution package
mvn -U -Pear package
cd ..

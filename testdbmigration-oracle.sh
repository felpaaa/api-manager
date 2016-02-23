#!/bin/bash

echo test+apply migrations - Oracle @ oracle11.z-c.office
./schemamigration.sh -T -t oracle -d oracle.jdbc.OracleDriver -U "jdbc:oracle:thin:@//dbserver:1521/xe" -u dbusername -p dbpassword
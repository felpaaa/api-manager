#!/bin/bash

echo apply migrations - Oracle @ dbserver
./schemamigration.sh -A -t oracle -d oracle.jdbc.OracleDriver -U "jdbc:oracle:thin:@//oracle11.z-c.office:1521/xe" -u dbusername -p dbpassword
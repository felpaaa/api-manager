#!/bin/bash

echo apply migrations - PostgreSQL @ dbserver
./schemamigration.sh -A -t postgresql -d org.postgresql.Driver -U "jdbc:postgresql://dbserver:5432/dbname" -u dbusername -p dbpassword
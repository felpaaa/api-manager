#!/bin/bash

echo test+apply migrations - PostgreSQL @ localhost
./schemamigration.sh -T -t postgresql -d org.postgresql.Driver -U "jdbc:postgresql://dbserver:5432/dbname" -u dbusername -p dbpassword
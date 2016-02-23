#!/bin/bash
# Copyright (c) 2012-2014  Bizmatica Software Lab <onstagemobile@bizmatica.com>

echo "====================================="
echo " OnAir db schema migration utility   "
echo "====================================="


usage () {
	echo "Usage: `basename $0` -C|A|R|T -n <number-of-changes-to-apply> -t <db-type> -d <jdbc-driver> -U <jdbc-url> -u <db-user> -p <db-pwd>"
	echo -e " 	-C, -A, -R or -T\t action:  _C_heck schema status, _A_pply schema changes, _R_ollback one db migration script, _T_test+Apply migrations"
	echo -e "       -n <number-of-changes-to-apply>\t\t the number of changes to apply, 0 to apply all pending changes"
	echo -e "	-t <db-type>\t\t db type. e.g. postgresql or mysql"
	echo -e "	-d <jdbc-driver>\t jdbc driver name. e.g. org.postgresql.Driver"
	echo -e "	-U <jdbc-URL>\t\t jdbc URL to the db. e.g. jdbc:postgresql://localhost:5432/onstage" 
	echo -e "	-u <db-user>\t\t DB username"
	echo -e "	-p <db-pwd>\t\t DB password"
	echo -e "	Specify any of -S (to check schema status), -A (to apply schema changes), -R (to rollback one migration) or -T (to test+apply pending changes)"
	echo -e "	All other parameters are mandatory except -n which if not specified implies all changes"
	echo -e "	-h for this help" 
	exit 1
}

if ( ! getopts "CARTn:t:d:U:u:p:h" opt); then
	usage
fi 

while getopts "CARTn:t:d:U:u:p:h" opt; do
	case $opt in
		C)
			ACTION="CHECK"
			echo "Action: Check status" >&2
			;;
		A) 
			ACTION="APPLY"
			echo "Action: Apply updates" >&2
			;;
		R) 
			ACTION="ROLLBACK"
			echo "Action: Rollback changes" >&2
			;;
		T)
			ACTION="TEST"
			echo "Action: Test and Apply changes" >&2
			;;
		n)
			NUMBER_OF_CHANGES="$OPTARG"
			echo "Number of changes to apply: $NUMBER_OF_CHANGES"
			;;
		t)
			DBTYPE="$OPTARG"
			echo "DB type: $DBTYPE" >&2
			;;
		d)
			DRIVER="$OPTARG"
			echo "JDBC Driver: $DRIVER" >&2
			;; 
		U)		
			DBURL="$OPTARG"
			echo "DB URL: $DBURL" >&2
			;;
		u)
			DBUSER="$OPTARG"
			echo "DB user: $DBUSER" >&2
			;;
		p)
			DBPWD="$OPTARG"
			echo  "DB pwd: ****" >&2
			;;
		h)
			usage
			;;
		\?)
			echo "Invalid option: -$OPTARG" >&2
			echo "`basename $0` -h   for help" >&2
			exit 1
			;;
   		:)
			echo "Option -$OPTARG requires an argument." >&2
			echo "`basename $0` -h   for help" >&2
			;;
	esac
done

# Check params
if [ -z "$ACTION" ]; then
	echo "Error: missing action. Specify any of -C, -A, -R or -T" >&2
	PARAMERR=1
fi
if [ -z "$DBTYPE" ]; then
	echo "Error: missing db-type.  e.g. 'postgresql' (without quotes)" >&2
	PARAMERR=1
fi
if [ -z "$DRIVER" ]; then
	echo "Error: missing JDBC driver name.  e.g. '-d org.postgresql.Driver' (without quotes)" >&2
	PARAMERR=1
fi
if [ -z "$DBURL" ]; then
	echo "Error: missing JDBC db URL.  e.g. '-U jdbc:postgresql://localhost:5432/onstage' (without quotes)" >&2
	PARAMERR=1
fi
if [[ -z "$DBUSER" || -z "$DBPWD" ]]; then
	echo "Error: missing db user or password.  e.g. '-u myuser -p secret' (without quotes)" >&2
	PARAMERR=1
fi

if [ ! -z "$PARAMERR" ]; then
	echo "`basename $0` -h   for help" >&2
	exit 1
fi

if [ -z "$NUMBER_OF_CHANGES" ]; then
	NUMBER_OF_CHANGES=0
fi

# Check if in base project directory
if [ ! -f ./onair.project ]; then
	echo "Run only in the OnAir implementation project directory!"
	exit
fi


# Check status
if [[ "$ACTION" == "CHECK" ]]; then
	echo "=== Making sure migration are installed"
	#mvn install -DskipTests
	echo "=== Checking schema status ==="	
	mvn --non-recursive --update-snapshots liquibase:status -Dosdb.type=$DBTYPE -Dosdb.driver=$DRIVER -Dosdb.url=$DBURL -Dosdb.user=$DBUSER -Dosdb.pwd=$DBPWD
fi 

# Update schema
if [[ "$ACTION" == "APPLY" ]]; then
	echo "=== Making sure migration are installed"
	#mvn install -DskipTests
	echo "=== Applying changes to schema ==="	
	mvn --non-recursive --update-snapshots liquibase:update -Dliquibase.changesToApply=$NUMBER_OF_CHANGES -Dosdb.type=$DBTYPE -Dosdb.driver=$DRIVER -Dosdb.url=$DBURL -Dosdb.user=$DBUSER -Dosdb.pwd=$DBPWD	
fi 

# Rollback one step
if [[ "$ACTION" == "ROLLBACK" ]]; then
	echo "=== Making sure migration are installed"
	#mvn install -DskipTests
	echo "=== Rolling back one step of changes ==="	
	mvn --non-recursive --update-snapshots liquibase:rollback -Dliquibase.rollbackCount=1 -Dosdb.type=$DBTYPE -Dosdb.driver=$DRIVER -Dosdb.url=$DBURL -Dosdb.user=$DBUSER -Dosdb.pwd=$DBPWD	
fi 

# Test pending schema changes and Update
if [[ "$ACTION" == "TEST" ]]; then
	echo "=== Making sure migration are installed"
	#mvn install -DskipTests
	echo "=== Test pending schema changes and Apply changes ==="	
	mvn --non-recursive --update-snapshots liquibase:updateTestingRollback -Dliquibase.changesToApply=$NUMBER_OF_CHANGES -Dosdb.type=$DBTYPE -Dosdb.driver=$DRIVER -Dosdb.url=$DBURL -Dosdb.user=$DBUSER -Dosdb.pwd=$DBPWD	
fi 

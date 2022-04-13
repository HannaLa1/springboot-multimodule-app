#!/bin/bash

set -e
set -u

echo "*********Creating user and databases"
psql -v ON_ERROR_STOP=1 --username "postgres" <<-EOSQL

	    create user multimodule_project_app with login nosuperuser nocreatedb nocreaterole inherit noreplication  password 'anna123';

		  CREATE DATABASE multimodule_project;

      \c auth
      alter default privileges for role "multimodule_project_app" in schema public grant select, insert, update, delete on tables to "multimodule_project_app";
      alter default privileges for role "multimodule_project_app" in schema public grant select, usage on sequences to "multimodule_project_app";

EOSQL
echo "*********Completed user and databases"

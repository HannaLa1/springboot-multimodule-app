#!/bin/bash

set -e
set -u

echo "*********Creating user and databases"
psql -v ON_ERROR_STOP=1 --username "postgres" <<-EOSQL

	    create user multimodule_project_app with login nosuperuser nocreatedb nocreaterole inherit noreplication  password 'anna123';

		  CREATE DATABASE multimodule_project;

      \c multimodule_project;

      create table users
      (
          id bigserial constraint users_pkey primary key,
          username            varchar(255) not null unique,
          password            varchar(255) not null,
          email               varchar(255) not null unique,
          first_name          varchar(255) not null,
          last_name           varchar(255) not null,
          image_url           varchar(255),
          created             timestamp not null,
          updated             timestamp not null,
          last_visited_date   timestamp,
          recovery_token      varchar(255) unique,
          token_creation_date timestamp,
          user_account_status varchar(255)
      );

      create table roles
      (
          id bigserial constraint roles_pkey primary key,
          type_of_role varchar(255) not null unique
      );

      create table users_roles
      (
          user_id bigint not null
              constraint fk2o0jvgh89lemvvo17cbqvdxaa
                  references users,
          role_id bigint not null
              constraint fkj6m8fwv7oqv74fcehir1a9ffy
                  references roles,
          constraint users_roles_pkey
              primary key (user_id, role_id)
      );

      insert into roles (type_of_role) values ('USER');
      insert into roles (type_of_role) values ('ADMIN');

      \c auth
      alter default privileges for role "multimodule_project_app" in schema public grant select, insert, update, delete on tables to "multimodule_project_app";
      alter default privileges for role "multimodule_project_app" in schema public grant select, usage on sequences to "multimodule_project_app";

EOSQL
echo "*********Completed user and databases"

create table cdc_account_users (
   user_id uuid primary key,
   username varchar(255) not null,
   password text not null,
   email varchar(255) not null,
   status integer not null default 0,
   full_name varchar(255),
   created_by uuid,
   created_date timestamp default now(),
   modified_by uuid,
   modified_date timestamp default now()
);

create table cdc_account_roles (
   role_id uuid primary key,
   role varchar(64) not null,
   description varchar(255),
   status integer not null default 0
);

create table cdc_account_user_role (
   user_role_id uuid primary key,
   user_id uuid not null,
   role_id uuid not null,
   unique (user_id, role_id)
)
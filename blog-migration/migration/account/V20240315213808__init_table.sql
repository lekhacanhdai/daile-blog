create table users (
    user_id uuid primary key default gen_random_uuid(),
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

create table roles (
    role_id uuid primary key default gen_random_uuid(),
    role varchar(64) not null,
    description varchar(255),
    status integer not null default 0
);

create table user_role (
    user_role_id uuid primary key default gen_random_uuid(),
    user_id uuid not null,
    role_id uuid not null,
    foreign key (user_id) references users(user_id),
    foreign key (role_id) references roles(role_id),
    unique (user_id, role_id)
)
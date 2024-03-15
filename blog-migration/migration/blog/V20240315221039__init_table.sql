create table posts (
    post_id uuid primary key default gen_random_uuid(),
    title varchar(255) not null,
    content text not null,
    user_id uuid not null,
    status integer not null default 0
);

create table tags (
    tag_id uuid primary key default gen_random_uuid(),
    name varchar(255),
    description varchar(255)
);

create table post_tag (
    post_tag_id uuid primary key default gen_random_uuid(),
    post_id uuid not null,
    tag_id uuid not null,
    foreign key (post_id) references posts(post_id),
    foreign key (tag_id) references tags(tag_id),
    unique (post_id, tag_id)
);
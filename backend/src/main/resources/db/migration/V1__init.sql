CREATE EXTENSION IF NOT EXISTS pgcrypto;

create sequence design_sequence start 1 increment 1;
create sequence icon_in_design_sequence start 1 increment 1;
create sequence icon_sequence start 1 increment 1;
create sequence theme_sequence start 1 increment 1;
create sequence user_sequence start 1 increment 1;

create table theme
(
    id int8 not null,
    name varchar(255) not null,
    primary key (id),
    constraint uk_theme_name unique (name)
);

create table fanicon_user
(
    email varchar(255) not null,
    name varchar(255) not null,
    password varchar(255) not null,
    user_group varchar(255) not null,
    primary key (name),
    constraint uk_user_email unique (email),
    constraint uk_user_name unique (name)
);

create table design
(
    id int8 not null,
    bg_color varchar(255) not null,
    icon_margin varchar(255),
    icon_size varchar(255),
    name varchar(255) not null,
    user_name varchar(255) not null,
    primary key (id),
    constraint fk_design_user foreign key (user_name) references fanicon_user (name)
);

create table icon
(
    id int8 not null,
    copyright_source varchar(255),
    is_copyrighted boolean,
    name varchar(255) not null,
    style varchar(255),
    svg varchar(255) not null,
    theme_id int8 not null,
    primary key (id),
    constraint fk_icon_theme foreign key (theme_id) references theme (id)
);

create table icon_in_design
(
    id int8 not null,
    position int4 not null,
    design_id int8,
    icon_id int8,
    primary key (id),
    constraint fk_iconindesign_design foreign key (design_id) references design (id),
    constraint fk_iconindesign_icon foreign key (icon_id) references icon (id)
);


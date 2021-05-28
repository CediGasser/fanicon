CREATE EXTENSION IF NOT EXISTS pgcrypto;

create sequence design_sequence start 1 increment 1;
create sequence icon_in_design_sequence start 1 increment 1;
create sequence icon_sequence start 1 increment 1;
create sequence theme_sequence start 1 increment 1;
create sequence user_sequence start 1 increment 1;

create table design (id int8 not null, bg_color varchar(255) not null, icon_margin varchar(255), icon_size varchar(255), name varchar(255) not null, user_id int8 not null, primary key (id));
create table fanicon_user (id int8 not null, email varchar(255) not null, name varchar(255) not null, password varchar(255) not null, user_group varchar(255) not null, primary key (id));
create table icon (id int8 not null, copyright_source varchar(255), is_copyrighted boolean, name varchar(255) not null, style varchar(255), svg varchar(255) not null, theme_id int8 not null, primary key (id));
create table icon_in_design (id int8 not null, position int4 not null, design_id int8, icon_id int8, primary key (id));
create table theme (id int8 not null, name varchar(255) not null, primary key (id));

alter table if exists fanicon_user add constraint UK_j7o891doj86ikht9u4um2c1ci unique (email);
alter table if exists fanicon_user add constraint UK_nbu38m3a5583tsiwvd8bfki45 unique (name);
alter table if exists theme add constraint UK_kos4rdub1av4d5wt6wocsdb7t unique (name);
alter table if exists design add constraint FK45yc0b845l5lx2gw8pelk135f foreign key (user_id) references fanicon_user;
alter table if exists icon add constraint FKo66pnjpx5al61gbk9x8ajejko foreign key (theme_id) references theme;
alter table if exists icon_in_design add constraint FKqb3670s72a6yoojs86lugynf8 foreign key (design_id) references design;
alter table if exists icon_in_design add constraint FK533tgfhj1pkg8phg0inipiqpo foreign key (icon_id) references icon;

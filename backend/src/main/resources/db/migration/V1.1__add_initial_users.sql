insert into fanicon_user (name, email, password, user_group)
values ('admin', 'admin@example.com', crypt('secret', gen_salt('bf', 8)), 'ADMIN');

insert into fanicon_user (name, email, password, user_group)
values ('testli', 'testli@example.com', crypt('secret', gen_salt('bf', 8)), 'NORMAL');

insert into fanicon_user (name, email, password, user_group)
values ('vip testli', 'vip@example.com', crypt('secret', gen_salt('bf', 8)), 'VIP');
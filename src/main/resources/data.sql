

insert into SEC_User (userName, encryptedPassword, ENABLED)
values ('Jon', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

INSERT INTO SEC_User (userName, encryptedPassword, ENABLED)
VALUES
    ('John Doe', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
    ('Jane Smith', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
    ('Michael Johnson', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
    ('Emily Williams', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1),
    ('Mark Davis', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);




insert into sec_role (roleName)
values ('ROLE_VENDER');

insert into sec_role (roleName)
values ('ROLE_GUEST');


insert into user_role (userId, roleId)
values (1, 1);



insert into user_role (userId, roleId)
values (2, 2);
insert into user_role (userId, roleId)
values (3, 2);
insert into user_role (userId, roleId)
values (4, 2);
insert into user_role (userId, roleId)
values (5, 2);
insert into user_role (userId, roleId)
values (6, 2);


INSERT INTO Ticket(username, date, address,price,time, anime_group)
VALUES ( 'John Doe', 'September 2, 2023',  'The Michener Institute · Toronto, Ontario', 234.98, '9:00AM EDT', 'Jujutsu Kaisen'),
       ( 'John Doe', 'September 3, 2023',  'Ramada Airport East Hotel Toronto, Ontario',  300.00, '6:00PM EDT', 'Demon Slayer'),
       ( 'John Doe', 'September 1, 2023',  'Metro Toronto Convention Centre (MTCC), Front Street West, Toronto',  199.98, '9:00PM EDT', 'Attack on Titan'),
       ( 'Jane Smith', 'September 2, 2023',  'The Michener Institute · Toronto, Ontario',  234.98, '9:00AM EDT', 'Dragon Ball Z'),
       ( 'Jane Smith', 'September 3, 2023',  'Ramada Airport East Hotel Toronto, Ontario',  300.00, '6:00PM EDT', 'Baki Hanma'),
       ( 'Michael Johnson', 'September 1, 2023',  'Metro Toronto Convention Centre (MTCC), Front Street West, Toronto',  199.98, '9:00PM EDT', 'Zom 100'),
       ( 'Emily Williams', 'September 3, 2023',  'Ramada Airport East Hotel Toronto, Ontario', 234.98, '6:00PM EDT', 'Naruto'),
       ( 'Emily Williams', 'September 1, 2023',  'Metro Toronto Convention Centre (MTCC), Front Street West, Toronto' , 199.98, '9:00PM EDT', 'Tokyo Ghoul'),
       ( 'Emily Williams', 'September 2, 2023',  'The Michener Institute · Toronto, Ontario',  234.98, '9:00AM EDT', 'Tokyo Revengers'),
       ( 'Emily Williams', 'September 3, 2023',  'Ramada Airport East Hotel Toronto, Ontario',  300.00, '6:00PM EDT', 'My Hero Academia'),
       ( 'Mark Davis', 'September 1, 2023',  'Metro Toronto Convention Centre (MTCC), Front Street West, Toronto', 199.98, '9:00PM EDT', 'Hells Paradise');

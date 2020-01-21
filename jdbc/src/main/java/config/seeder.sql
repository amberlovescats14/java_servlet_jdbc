create user 'amber'@'localhost' identified by 'aj';

GRANT SELECT, INSERT, UPDATE, DELETE
    ON contacts.* TO 'amber'@'localhost';

drop user 'amber'@'localhost';

show databases ;
create database contacts;


use contacts;
show tables;
drop table users;
drop table ads;
drop table  ads_category;
drop table category;


create table if not exists users(
    id int unsigned not null auto_increment,
    username varchar(50) not null,
    email varchar(50) not null ,
    password varchar(100) not null ,
    primary key (id)
);
drop table ads;
create table if not exists ads (
        id int unsigned unique auto_increment,
        user_id int unsigned not null ,
        title varchar(50) not null,
        description varchar(200) not null ,
        primary key (id),
        foreign key (user_id) references users(id)
                               on delete cascade
);

create table if not exists ads_category (
    ads_id int unsigned,
    category_id int unsigned,
    foreign key (ads_id) references ads (id)
                                       on delete cascade ,
    foreign key (category_id) references category (id)
                                        on delete  cascade
);

create table  if not exists category (
    id int unsigned auto_increment,
    name varchar(50) not null ,
    primary key (id)
);
insert into category (name) values
('food'),
('furniture'),
('children'),
('pets');
# truncate table users;
insert into users(username, email, password) values
('amberlovescats', 'aj@mail.com', 'aj'),
('camilovescats', 'cj@mail.com', 'cj'),
('masonlovescats', 'mj@mail.com', 'mj');


insert into ads (user_id, title, description) VALUES
(2, 'Nail Polish for Sale', 'Lady Glitter Sparkles'),
(2, 'Socks for Rent', 'One missing'),
(3, 'Nanny needed', 'Must be cool');

select * from category;
insert into ads_category (ads_id, category_id) values
(1,3),
(2,4),
 (3,1);



select * from users;
;
select * from ads;

select * from ads where id = 2;

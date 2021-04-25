create database if not exists restaurant;

use restaurant;

drop tables if exists food;

create table food (
id int (10) not null auto_increment,
dishname varchar(15) not null,
price decimal(3,2),
primary key (id)
);
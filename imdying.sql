create database imdyingdb;
use imdyingdb;
create table user(userId int, firstName varchar(20),lastName varchar(20),email varchar(30),
dob date,gender varchar(20), category varchar(40),contactNo bigint,password varchar(30));

create table loggeduser(id int primary key auto_increment ,userId int , firstName varchar(20),
lastName varchar(20),email varchar(30),
dob date ,gender varchar(20) , category varchar(40),contactNo bigint,
password varchar(30));

create table ticket(ticketId int primary key auto_increment,
title varchar(30) ,
createrName varchar(20),
holderName varchar(20),
createDate date ,
status int);

create table category(id int auto_increment primary key,categoryName varchar(20));

create table message(messageId int auto_increment,ticketId int,
authorName varchar(20),recepientName varchar(20), text varchar(50),
createDate date,primary key(messageId));

insert into user values(13,"Tracker","Master","admin@gmail.com","1999-01-17","male","ADMIN",7598691746,"admin","null","admin","delhi","voilet");

update user set userId=0 where category="ADMIN";

select * from user;
select * from loggeduser;
select * from ticket;
select * from category;
select * from message;
select * from ticket where holdername="Tara," and status !='Closed';

alter table user modify column userId int auto_increment primary key;

alter table user add column repCategory varchar(20);
alter table user add column q1 varchar(30);
alter table user add column q2 varchar(30);
alter table user add column q3 varchar(30);

show tables;

drop table loggeduser;
drop table ticket;

desc loggeduser;
desc ticket;

alter table ticket drop column status;
alter table ticket add column status varchar(20);

delete from loggeduser;
delete from message;



alter table category rename column id to categoryId;

select * from ticket where ticket.holdername="Tara," and status = 'reopen';

delete from user where userId=6;
delete from user where userId=0;
select email,contactNo from user where category="Admin";

select * from ticket where ticket.holdername="Diya" and status = 'reopen';


desc user;
desc category;
desc ticket;
desc message;
desc loggeduser;



SELECT *from user where firstName like '%?1%';

select * from user where userId LIKE '%?1%'
				 OR firstName LIKE '%?1%'
				 OR lastName LIKE '%?1%'
				 OR email LIKE '%?1%'
				 OR category LIKE 'User';
                 
                 
select * from user where userId>0 and userId LIKE '%s%' OR firstName LIKE '%s%' OR lastName LIKE '%s%' OR email LIKE '%s%' OR category LIKE '%';             
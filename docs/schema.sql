-- drop -----------------------------
drop table IF EXISTS user_invitations;
drop table IF EXISTS user_contacts;
drop table IF EXISTS group_users;
drop table IF EXISTS chat_groups;
drop table IF EXISTS users;
DROP TABLE IF EXISTS admin_login;

-- creation -------------------------
create table admin_login (
	phone varchar(50) primary key ,
    password varchar(50) default '123456'
);

create table users (
	phone_number varchar(30) primary key,
    username varchar(100) not null,
	email varchar(100) unique not null,
	pass text not null,   
	image text not null default("user.png"),
	gender varchar(10) not null,
	country varchar(20) not null,
	date_of_birth datetime not null,
	bio varchar(200),
    user_status varchar(20) not null default("AVAILABLE")
);

create table user_contacts (
	user_number varchar(20) not null,
	contact_number varchar(20) not null,
    foreign key (user_number) references users(phone_number),
    foreign key (contact_number) references users(phone_number),
    primary key (user_number, contact_number)
);

create table user_invitations (
	sender_number varchar(20) not null,
	reciever_number varchar(20) not null,
	date datetime default(sysdate()) not null, 
	state bit,
	foreign key (sender_number) references users(phone_number),
    foreign key (reciever_number) references users(phone_number),
    primary key (sender_number, reciever_number)
);

create table chat_groups (
	id int auto_increment primary key,
	group_name varchar(250) not null,
    group_img text not null default("group.png")
);

create table group_users (
	user_number varchar(30) not null,
    group_id int not null,
    foreign key (user_number) references users(phone_number),
    foreign key (group_id) references chat_groups(id)
);

-- ----------- seed ------------------------------------


 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01151303667', 'hesham', 'hesham901@gmail.com', 'user.png', 'Male', 'VIENNA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('0115928056', ' Elsisi', 'elsisi@gmail.com', 'user.png', 'Male', 'AUSTRALIA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01555528056', 'hosaam', 'hosam1@gmail.com', 'user.png', 'Male', 'KSA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01002528056', 'hatem', 'hatem@gmail.com', 'user.png', 'Male', 'ANGOLA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01095201234', 'shawky', 'eshawky@gmail.com', 'user.png', 'Male', 'ALGERIA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('0109524587', 'hamdii', 'isi901@gmail.com', 'user.png', 'Male', 'ALBANIA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01245879114', 'MAGJ', 'eMAGJisi901@gmail.com', 'user.png', 'Male', 'AFGHANISTAN', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01095012457', 'essam', 'essam901@gmail.com', 'user.png', 'Male', 'EGYPT', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01012458888', 'tarek', 'tareki901@gmail.com', 'user.png', 'Male', 'KSA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01142799371', 'Marwa', 'marwa@gmail.com', 'user.png', 'Female', 'USA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01148834043', 'Mariam', 'mariam@gmail.com', 'user.png', 'Female', 'USA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01188834043', 'Noura', 'noura@gmail.com', 'user.png', 'Female', 'USA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01148034043', 'yasmeen', 'yasmeen@gmail.com', 'user.png', 'Female', 'USA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01148734043', 'jana', 'jana@gmail.com', 'user.png', 'Female', 'USA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01158834043', 'mohammed', 'mohammed@gmail.com', 'user.png', 'male', 'USA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01188934043', 'hala', 'hala@gmail.com', 'user.png', 'Female', 'USA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01198834043', 'hamada', 'hamada@gmail.com', 'user.png', 'Male', 'KSA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01146834043', 'Mariam', 'mariam77@gmail.com', 'user.png', 'Female', 'KSA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');

 VALUES ('01148834043', 'Mariam', 'mariam@gmail.com', 'user.png', 'Female', 'USA', '2022-02-18', 'hello', 'OFFLINE', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');


insert into user_contacts values('01555528056','01151303667');
insert into user_contacts values('01151303667','01555528056');
insert into user_contacts values('01151303667','01002528056');
insert into user_contacts values('01002528056','01151303667');

-- admin_login table insertion
insert into admin_login (`phone`,`password`) values('01097961674','123456789');
insert into admin_login (`phone`,`password`) values('01297961674','123456789');
  
-- create table user_blocks (
-- 	user_number varchar(20) not null,
-- 	contact_number varchar(20) not null,
-- 	foreign key (user_number) references users(phone_number),
-- 	foreign key (contact_number) references users(phone_number),
-- 	primary key (user_number, contact_number)
-- );

-- create table user_messages (
-- 	sender_number foreign key not null,
-- 	receive_number foreign key not null,
-- 	msg_body text not null,
-- date date not null, 
-- style text
-- );

-- drop table users;
-- drop table user_contacts;
-- drop table user_invetations;

-- CREATE TRIGGER AFTER_INSERT_IN_CONTACTS
-- 	AFTER INSERT ON user_contacts FOR EACH ROW
--     BEGIN
-- 		INSERT INTO user_contacts VALUES (new.contact_number, new.user_number);
--     END;

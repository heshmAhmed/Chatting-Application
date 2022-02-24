-- drop -----------------------------
drop table user_invitations;
drop table user_contacts;
drop table group_users;
drop table group_chats;
drop table users;

-- creation -------------------------
create table users (
	phone_number varchar(30) primary key,
    username varchar(100) not null,
	email varchar(100) unique not null,
	pass text not null,   
	image text,
	gender varchar(10) not null,
	country varchar(20) not null,
	date_of_birth datetime not null,
	bio varchar(200),
    user_status varchar(20)
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

create table group_chats (
	id int auto_increment primary key,
	name varchar(250) not null,
    img text
);

create table group_users (
	user_number varchar(30) not null,
    group_id int not null,
    foreign key (user_number) references users(phone_number),
    foreign key (group_id) references group_chats(id)
);

-- ----------- seed ------------------------------------


 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01151303667', 'hesham', 'hesham901@gmail.com', 'cccc', 'm', 'egypt', '2022-02-18', 'hello', 'online', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('0115928056', ' Elsisi', 'elsisi@gmail.com', 'cccc', 'm', 'egypt', '2022-02-18', 'hello', 'online', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01555528056', 'hosaam', 'hosam1@gmail.com', 'cccc', 'm', 'egypt', '2022-02-18', 'hello', 'online', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01002528056', 'hatem', 'hatem@gmail.com', 'cccc', 'm', 'egypt', '2022-02-18', 'hello', 'online', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01095201234', 'shawky', 'eshawky@gmail.com', 'cccc', 'm', 'egypt', '2022-02-18', 'hello', 'online', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('0109524587', 'hamdii', 'isi901@gmail.com', 'cccc', 'm', 'egypt', '2022-02-18', 'hello', 'online', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01245879114', 'MAGJ', 'eMAGJisi901@gmail.com', 'cccc', 'm', 'egypt', '2022-02-18', 'hello', 'online', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01095012457', 'essam', 'essam901@gmail.com', 'cccc', 'm', 'egypt', '2022-02-18', 'hello', 'online', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('01012458888', 'tarek', 'tareki901@gmail.com', 'cccc', 'm', 'egypt', '2022-02-18', 'hello', 'online', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 INSERT INTO `chatting_application`.`users` (`phone_number`, `username`, `email`, `image`, `gender`, `country`, `date_of_birth`, `bio`, `user_status`, `pass`)
 VALUES ('0100215455', 'MElsisi', 'tarek@gmail.com', 'cccc', 'm', 'egypt', '2022-02-18', 'hello', 'online', '-115-106-98-17110-54-45-62-1025898-110-128-26-122-4912639390-122-81-13-5418212-11058-36108-110');
 

insert into user_contacts values('01555528056','01151303667');
insert into user_contacts values('01151303667','01555528056');
  
insert into user_contacts values('01151303667','01002528056');
insert into user_contacts values('01002528056','01151303667');
  
  
  
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

create table users (
	phone_number varchar(20) primary key,
    username varchar(50) not null,
	email varchar(100) unique not null,
	image varchar(200) default('/')  not null,
	gender varchar(1) default ('m') not null,
	country varchar(20) not null,
	date_of_birth datetime not null,
	bio varchar(200),
    user_status varchar(50)
);

create table user_contacts (
	user_number varchar(20) not null,
	contact_number varchar(20) not null,
    foreign key (user_number) references users(phone_number),
    foreign key (contact_number) references users(phone_number),
    primary key (user_number, contact_number)
);

create table user_invetations (
	sender_number varchar(20) not null,
	reciever_number varchar(20) not null,
	date datetime default(sysdate()) not null, 
	state bit,
	foreign key (sender_number) references users(phone_number),
    foreign key (reciever_number) references users(phone_number)
);

create table user_blocks (
	user_number varchar(20) not null,
	contact_number varchar(20) not null,
	foreign key (user_number) references users(phone_number),
	foreign key (contact_number) references users(phone_number),
	primary key (user_number, contact_number)
);

-- create table user_messages (
-- 	sender_number foreign key not null,
-- 	receive_number foreign key not null,
-- 	msg_body text not null,
-- date date not null, 
-- style text
-- );



-- CREATE TRIGGER CHECK_USERCONTACTS_FOREIGNKEYS 
-- 	BEFORE INSERT ON USER_CONTACTS FOR EACH ROW
--     BEGIN
-- 		IF NEW.USER_NUMBER = NEW.CONTACT_NUMBER THEN
-- 			SIGNAL SQLSTATE '5000' SET MESSAGE_TEXT = 'YOU CAN NOT CONTACT WITH YOUR NUMBER!';
-- 		END IF
--     END
    



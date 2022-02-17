create table users (
	phone_number varchar(20) primary key,
    username varchar(50) not null,
	email varchar(100) unique not null,
	pass text not null,   
	image text,
	gender varchar(1) default ('m') not null,
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

create table user_invetations (
	sender_number varchar(20) not null,
	reciever_number varchar(20) not null,
	date datetime default(sysdate()) not null, 
	state bit,
	foreign key (sender_number) references users(phone_number),
    foreign key (reciever_number) references users(phone_number)
);

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

CREATE TRIGGER AFTER_INSERT_IN_CONTACTS
	AFTER INSERT ON user_contacts FOR EACH ROW
    BEGIN
		INSERT INTO user_contacts VALUES (new.contact_number, new.user_number);
    END;

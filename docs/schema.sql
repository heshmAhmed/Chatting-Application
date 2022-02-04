create table user_status (
	id int primary key,
	status varchar(20) unique not null
);

create table users (
	phone_number varchar(20) primary key,
	status_id int not null,
    first_name varchar(50) not null,
	last_name varchar(50) not null,
	email varchar(100) unique not null,
	picture varchar(200) default('/')  not null,
	gender varchar(1) default ('m') not null,
	country varchar(20) not null,
	date_of_birth datetime not null,
	bio varchar(200),
    created_at datetime not null default (sysdate()),
	foreign key (status_id) references user_status(id)
);

create table user_contacts (
	user_number varchar(20) not null,
	contact_number varchar(20) not null,
	is_blocked bit default (0), 
	blocks bit default(0),    
    foreign key (user_number) references users(phone_number),
    foreign key (contact_number) references users(phone_number),
    primary key (user_number, contact_number)
);

create table user_invetations (
	inviter_number varchar(20) not null,
	invitee_number varchar(20) not null,
	date datetime default(sysdate()) not null, 
	state bit,
	foreign key (inviter_number) references users(phone_number),
    foreign key (invitee_number) references users(phone_number)
);

-- CREATE TRIGGER CHECK_USERCONTACTS_FOREIGNKEYS 
-- 	BEFORE INSERT ON USER_CONTACTS FOR EACH ROW
--     BEGIN
-- 		IF NEW.USER_NUMBER = NEW.CONTACT_NUMBER THEN
-- 			SIGNAL SQLSTATE '5000' SET MESSAGE_TEXT = 'YOU CAN NOT CONTACT WITH YOUR NUMBER!';
-- 		END IF
--     END
    



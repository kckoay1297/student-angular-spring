DROP TABLE IF EXISTS STUDENT;
DROP sequence IF EXISTS STUDENT_ID_SEQ;

create sequence STUDENT_ID_SEQ start 1;

create table STUDENT (
	STUDENT_ID bigint auto_increment  not null,
	STUDENT_NAME varchar(80) not null,
	NRIC varchar(15) not null, 
	GENDER varchar(8) not null, 
	EMAIL varchar(40), 
	PHONE_NUMBER varchar(30),  
	PRIMARY KEY  (STUDENT_ID), 
	UNIQUE KEY (NRIC)
);

insert into STUDENT (STUDENT_NAME, NRIC, GENDER, EMAIL, PHONE_NUMBER) values ('Koay Kuan Choang','931224095345', 'male', 'kuanchoang@email.com', '0122212578');
insert into STUDENT (STUDENT_NAME, NRIC, GENDER, EMAIL, PHONE_NUMBER) values ('Ahmad Mazlan','941224095345','male', 'mazlan@email.com', '0163214678');
insert into STUDENT (STUDENT_NAME, NRIC, GENDER, EMAIL, PHONE_NUMBER) values ('Santhini Anthony','951224095345','female', 'santini93@email.com', '0177272778');
insert into STUDENT (STUDENT_NAME, NRIC, GENDER, EMAIL, PHONE_NUMBER) values ('Lee Anthony','961224095345','male', 'lee_59@email.com', '012953933');
insert into STUDENT (STUDENT_NAME, NRIC, GENDER, EMAIL, PHONE_NUMBER) values ('Ali Mohamad','971224095345','male', 'ali_95@email.com', '0133571768');
insert into STUDENT (STUDENT_NAME, NRIC, GENDER, EMAIL, PHONE_NUMBER) values ('Christine Lee','981224095345','female', 'christine.lee95@email.com', '01112212578');

DROP TABLE IF EXISTS COURSE;
DROP sequence IF EXISTS COURSE_ID_SEQ;

create sequence COURSE_ID_SEQ start 1;

create table COURSE (
	COURSE_ID bigint auto_increment  not null,
	COURSE_NAME varchar(80) not null,
	DESCRIPTION varchar(200) not null,
	PRIMARY KEY  (COURSE_ID)
);

insert into COURSE (COURSE_NAME, DESCRIPTION) values ('Pengajian AM','General studies about Malaysia');
insert into COURSE (COURSE_NAME, DESCRIPTION) values ('Physic 1','Begineer level of physics');
insert into COURSE (COURSE_NAME, DESCRIPTION) values ('Mathematics T','Scientific mathematics.');

DROP TABLE IF EXISTS STUDENT_COURSE;
DROP sequence IF EXISTS STUDENT_COURSE_ID_SEQ;

create sequence STUDENT_COURSE_ID_SEQ start 1;

create table STUDENT_COURSE (
	STUDENT_COURSE_ID bigint auto_increment  not null,
	COURSE_ID bigint not null,
	STUDENT_ID bigint not null,
	PRIMARY KEY  (STUDENT_COURSE_ID)
);

insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (1, 1);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (2, 1);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (3, 1);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (1, 2);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (3, 2);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (4, 2);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (1, 3);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (2, 3);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (4, 3);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (1, 4);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (2, 4);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (3, 4);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (1, 5);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (3, 5);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (4, 5);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (1, 6);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (2, 6);
insert into STUDENT_COURSE (COURSE_ID, STUDENT_ID) values (4, 6);

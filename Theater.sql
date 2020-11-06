CREATE TABLE  member (
                member_no varchar(10),
                tel 		CHAR(13) unique, 
                member_id VARCHAR2(20) UNIQUE,
                password 	VARCHAR2(20)  NOT NULL,
                name 		VARCHAR2(10) ,
                birth 		DATE NOT NULL,
                email varchar2(50),
                CONSTRAINT pk_member_member_no PRIMARY KEY(member_no));

CREATE TABLE  movie (
	title 		VARCHAR2(30),
            run_time 		NUMBER(3,0) NOT NULL, --200�� �̻� ��ȭ ����x
	director 		VARCHAR2(30) NOT NULL,
	actor 		VARCHAR2(50) NOT NULL,
	audi_num 	NUMBER NOT NULL ,
   	CONSTRAINT pk_movie_title PRIMARY KEY(title));

CREATE TABLE reserve (
            reserve_no 	NUMBER, --���Ź�ȣ PK
            tel 		CHAR(13), -- ��ȭ��ȣ FK(from member)
            theater_no 	varCHAR2(1), --�󿵰� ��ȣ FK(from theater)
            start_time 	DATE, -- �󿵽ð� FK(from theater)
            seat_no  		VARCHAR2(40) NOT NULL, --�¼���ȣ (�ִ� 8��)
            person_num 	NUMBER NOT NULL, -- �ο�
            pay_sys 		VARCHAR2(4) DEFAULT 'ī��', -- �������
            pay_money 	NUMBER NOT NULL, -- �����ݾ�
     	CONSTRAINT pk_reserve_reserve_no PRIMARY KEY(reserve_no),
       	CONSTRAINT fk_reserve_tel FOREIGN KEY(tel) REFERENCES member(tel),
       	CONSTRAINT fk_reserve_theater FOREIGN KEY (theater_no,start_time) REFERENCES theater(theater_no,start_time),
       	CONSTRAINT check_reserve_pay_sys CHECK (pay_sys IN ('ī��','����')));

CREATE TABLE theater(
	theater_no 	varchar2(1), --�󿵰� ��ȣ PK
	start_time 	date,  -- �󿵽ð�
	title 		varchar2(30), -- ���� FK(from movie)
	seat_num	 	number NOT NULL, -- �¼� ����
	CONSTRAINT pk_theater_theater_no PRIMARY KEY(theater_no,start_time),
	CONSTRAINT fk_theater_title FOREIGN KEY (title) REFERENCES movie(title));

CREATE sequence seq_reserve_no
minvalue 0
start with 1
increment by 1;

CREATE sequence seq_member_no
minvalue 0
start with 1
increment by 1;

desc member;


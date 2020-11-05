CREATE TABLE  member (
                member_id 	VARCHAR2(20),
                password 	VARCHAR2(20)  NOT NULL,
                name 		VARCHAR2(10) ,
                tel 		CHAR(13)  NOT NULL, -- '-'하이픈 포함/PK
                birth 		DATE NOT NULL,
                email varchar2(50),

            CONSTRAINT pk_member_tel PRIMARY KEY(tel));

CREATE TABLE  movie (
	title 		VARCHAR2(30),
            run_time 		NUMBER(3,0) NOT NULL, --200분 이상 영화 존재x
	director 		VARCHAR2(30) NOT NULL,
	actor 		VARCHAR2(50) NOT NULL,
	audi_num 	NUMBER NOT NULL ,

   	CONSTRAINT pk_movie_title PRIMARY KEY(title));

CREATE TABLE reserve (
	reserve_no 	NUMBER, --예매번호 PK
            tel 		CHAR(13), -- 전화번호 FK(from member)
	theater_no 	CHAR(1), --상영관 번호 FK(from theater)
	theater_time 	DATE, -- 상영시각 FK(from theater)
	seat_no  		VARCHAR2(40) NOT NULL, --좌석번호 (최대 8명)
            person_num 	NUMBER NOT NULL, -- 인원
            pay_sys 		VARCHAR2(4) DEFAULT '카드', -- 결제방식
            pay_money 	NUMBER NOT NULL, -- 결제금액

     	CONSTRAINT pk_reserve_reserve_no PRIMARY KEY(reserve_no),
       	CONSTRAINT fk_reserve_tel FOREIGN KEY(tel) REFERENCES member(tel),
       	CONSTRAINT fk_reserve_theater FOREIGN KEY (theater_no,theater_time) REFERENCES theater(theater_no,theater_time),
       	CONSTRAINT check_reserve_pay_sys CHECK (pay_sys IN ('카드','현금')));

CREATE TABLE theater(
	theater_no 	char(1), --상영관 번호 PK
	theater_time 	date,  -- 상영시각
	title 		varchar2(30), -- 제목 FK(from movie)
	seat_num	 	number NOT NULL, -- 좌석 갯수

	CONSTRAINT pk_theater_theater_no PRIMARY KEY(theater_no,theater_time),
	CONSTRAINT fk_theater_title FOREIGN KEY (title) REFERENCES movie(title));

CREATE sequence seq_reserve_no
start with 1
increment by 1;




drop table member;
drop table reserve;
drop table movie;
drop table theater;
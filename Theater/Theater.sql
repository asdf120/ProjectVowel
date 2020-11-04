create table member ( member_id varchar2(20),
                password varchar2(15) not null,
                tel varchar2(13) not null,
                name varchar2(10) not null,
                birth varchar2(6) not null,
                email varchar2(50) not null,
            constraint pk_member_member_id primary key(member_id));
            
CREATE TABLE MOVIE (TITLE VARCHAR2(30 BYTE) NOT NULL ENABLE, 
    RUN_TIME NUMBER NOT NULL ENABLE, 
	DIRECTOR VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	ACTOR VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	AUDI_NUM NUMBER NOT NULL ENABLE, 
   constraint pk_movie_title primary key(title)); 
   
create table reserve(reserve_no number,
            member_id varchar2(20),
            title varchar2(30),
            theater varchar(1) not null,
            see_date date not null,
            person_num number not null,
            pay_sys varchar(5) default '카드',
            pay_money number not null,
        constraint pk_reserve_reserve_no primary key(reserve_no),
        constraint fk_reserve_member_id foreign key(member_id) references member(member_id),
        constraint fk_reserve_movie foreign key(title) references movie(title),
        constraint check_reserve_pay_sys check(pay_sys in('카드','현금')));
        
-- 고객 예매번호 시퀀스
create sequence seq_reserve_no3
start with 10000
increment by 1000;

select seq_reserve_no3.nextval from dual;

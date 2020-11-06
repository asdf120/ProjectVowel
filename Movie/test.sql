insert into theater (theater_no,start_time,title,seat_num)
values (1,(sysdate + 1/24)+8,'위플래시',40);

select theater_no, to_char(start_time,'mm/dd hh24:mm:ss'), title from theater;

select * from movie;

-- 현재~7일뒤까지 상영중인 영화
select distinct(t.title)
from movie m inner join theater t
on m.title = t.title
where t.start_time <= (sysdate + 7);

select * from v$parameter where name like '%job%';

-- 아이디, 이름, 전화번호, 이메일, 예매번호 출력 (예매내역이 있는 사람만 출력됨)
SELECT m.member_id id, m.name name,m.tel tel, m.email email, r.reserve_no reserve_no
FROM member m inner join reserve r
on m.tel = r.member_tel 
where m.name like '%김용관%';
select * from member;

desc member;

insert into member values
(1, password('1111'), '김상건', 40, '여자', 'test@test.co.kr');


select id, name, age, gender, email 
  from member 
 where id = 1 and passwd = password('1111');
 
select id, name, age, gender, email    from member   where id = '1' and passwd = password('1111')
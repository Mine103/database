 > create table school(
studentid varchar2(100),
studentname varchar2(100),
schoolname varchar2(100),
birthday date,
gender char(1),
constraint studentid_pk primary key(studentid),
CONSTRAINT gender_check check(gender in('M', 'F'))
);
 
 > create table score(
eng number,
kor number,
math number,
grade number,
semester number,
s_no number,
studentid varchar(100),
constraint studentid_fk foreign key(studentid) references school(studentid)
);

 > alter table school add CONSTRAINT check(gender in('M', 'F'));

 > drop table school;
drop table score;

 > select * from school;
select * from score;

 > insert into school
values('id', 'name', 'sname', '2000-01-01', 'M');
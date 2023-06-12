> drop table score;
> 
> drop table school;

> create table school(
studentid varchar2(100) primary key,
studentname varchar2(100),
schoolname varchar2(100),
birthday date,
gender char(1),
constraint gender_ch check(gender in('M', 'F'))
);
> 
> create table score(
studentid varchar2(100),
grade number,
class number,
semester number,
kor number,
math number,
eng number,
constraint studentid_fk foreign key (studentid) references school(studentid) on delete cascade
);

>insert into school(studentid,studentname,schoolname,birthday,gender)
values('Hong','홍길동','하이미디어고등학교','2004-02-01','M');
> 
>insert into school(studentid,studentname,schoolname,birthday,gender)
values('Kim','김민재','하이미디어고등학교','2004-11-01','M');
> 
>insert into school(studentid,studentname,schoolname,birthday,gender)
values('Yoon','윤아름','하이미디어고등학교','2004-12-31','F');
>insert into school(studentid,studentname,schoolname,birthday,gender)
values('Park','박은탁','하이미디어고등학교','2004-07-05','M');
>insert into school(studentid,studentname,schoolname,birthday,gender)
values('Lee','이성경','하이미디어고등학교','2004-08-10','F');
>insert into school(studentid,studentname,schoolname,birthday,gender)
values('Ahn','안효섭','하이미디어고등학교','2004-04-17','M');
>insert into school(studentid,studentname,schoolname,birthday,gender)
values('Cha','차은재','하이미디어고등학교','2004-06-12','F');
>insert into school(studentid,studentname,schoolname,birthday,gender)
values('Seo','서우진','하이미디어고등학교','2004-11-26','M');
>insert into school(studentid,studentname,schoolname,birthday,gender)
values('Kang','강동주','하이미디어고등학교','2004-06-27','M');
>insert into school(studentid,studentname,schoolname,birthday,gender)
values('Yoo','유연석','하이미디어고등학교','2004-04-11','M');

insert into score(studentid, grade, class, semester, kor, math, eng)
values('Hong', '1', '1', '1', '7', '35', '89');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Hong', '1', '1', '2', '68', '3', '40');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Hong', '2', '1', '1', '88', '7', '97');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Hong', '2', '1', '2', '17', '59', '21');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Hong', '3', '1', '1', '9', '38', '92');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Hong', '3', '1', '2', '51', '31', '90');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kim', '1', '1', '1', '25', '71', '79');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kim', '1', '1', '2', '8', '36', '35');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kim', '2', '1', '1', '93', '68', '31');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kim', '2', '1', '2', '3', '60', '100');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kim', '3', '1', '1', '54', '44', '40');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kim', '3', '1', '2', '95', '90', '9');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoon', '1', '1', '1', '39', '71', '71');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoon', '1', '1', '2', '78', '90', '81');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoon', '2', '1', '1', '18', '58', '50');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoon', '2', '1', '2', '44', '15', '11');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoon', '3', '1', '1', '95', '5', '3');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoon', '3', '1', '2', '38', '20', '77');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Park', '1', '1', '1', '2', '7', '42');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Park', '1', '1', '2', '9', '10', '79');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Park', '2', '1', '1', '26', '60', '61');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Park', '2', '1', '2', '13', '49', '9');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Park', '3', '1', '1', '3', '30', '72');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Park', '3', '1', '2', '50', '94', '73');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Lee', '1', '1', '1', '19', '97', '84');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Lee', '1', '1', '2', '58', '54', '10');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Lee', '2', '1', '1', '77', '9', '73');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Lee', '2', '1', '2', '13', '9', '75');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Lee', '3', '1', '1', '81', '63', '17');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Lee', '3', '1', '2', '10', '28', '71');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Ahn', '1', '2', '1', '91', '45', '7');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Ahn', '1', '2', '2', '83', '23', '53');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Ahn', '2', '2', '1', '10', '71', '37');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Ahn', '2', '2', '2', '73', '78', '17');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Ahn', '3', '2', '1', '83', '25', '18');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Ahn', '3', '2', '2', '98', '90', '14');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Cha', '1', '2', '1', '98', '48', '64');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Cha', '1', '2', '2', '25', '19', '98');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Cha', '2', '2', '1', '42', '99', '5');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Cha', '2', '2', '2', '85', '92', '18');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Cha', '3', '2', '1', '30', '60', '52');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Cha', '3', '2', '2', '46', '29', '16');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Seo', '1', '2', '1', '88', '1', '77');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Seo', '1', '2', '2', '41', '5', '25');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Seo', '2', '2', '1', '5', '4', '96');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Seo', '2', '2', '2', '16', '100', '74');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Seo', '3', '2', '1', '78', '48', '61');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Seo', '3', '2', '2', '22', '35', '75');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kang', '1', '2', '1', '42', '30', '28');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kang', '1', '2', '2', '77', '33', '98');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kang', '2', '2', '1', '80', '95', '41');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kang', '2', '2', '2', '37', '7', '74');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kang', '3', '2', '1', '20', '21', '32');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Kang', '3', '2', '2', '92', '58', '54');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoo', '1', '2', '1', '57', '31', '79');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoo', '1', '2', '2', '33', '15', '88');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoo', '2', '2', '1', '45', '68', '58');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoo', '2', '2', '2', '46', '50', '88');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoo', '3', '2', '1', '91', '90', '39');
insert into score(studentid, grade, class, semester, kor, math, eng)
values('Yoo', '3', '2', '2', '88', '86', '9');

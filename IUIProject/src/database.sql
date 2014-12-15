drop table appuser;
drop table appuserdata;
drop table appuseradress;
drop table apphobbies;
/

create table appuser (
        id number,
        firstName varchar2(30),
        lastName varchar2(30),
        userName varchar2(30),
        password varchar2(40),
        constraint appuser_pk primary key (id),
        constraint app_username_uk unique (userName)
);
/
select * from appuser;
select * from appuserdata;

insert into apphobbies (id,name) values (1,'Gry');
insert into apphobbies (id,name) values (2,'Film');
insert into apphobbies (id,name) values (3,'Jedzenie');
insert into apphobbies (id,name) values (4,'Zakupy');

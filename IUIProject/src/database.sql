drop table appuser cascade constraints;
drop table appuserdata cascade constraints;
drop table appuseradress cascade constraints;
drop table apphobbies cascade constraints;
drop table appcomments cascade constraints;
drop table apptopiccategory cascade constraints;
drop table apptopic cascade constraints;
drop table apptopic_appcomments cascade constraints;
drop table apphobbies_appuserdata cascade constraints;
drop table appuserdata_apphobbies cascade constraints;
drop table TB_HOBBY_USER cascade constraints;

drop table person;


select * from appuser;
select * from appuserdata;
select * from apptopics;
select * from apptopiccategory;
select * from appuadress;

insert into apphobbies (id,name) values (1,'Gry');
insert into apphobbies (id,name) values (2,'Film');
insert into apphobbies (id,name) values (3,'Jedzenie');
insert into apphobbies (id,name) values (4,'Zakupy');
insert into apphobbies (id,name) values (5,'Inne');

insert into apptopiccategory (id,name) values (1,'Gry');
insert into apptopiccategory (id,name) values (2,'Film');
insert into apptopiccategory (id,name) values (3,'Jedzenie');
insert into apptopiccategory (id,name) values (4,'Zakupy');
insert into apptopiccategory (id,name) values (5,'Inne');

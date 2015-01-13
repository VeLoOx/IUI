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
drop table udatahobbies cascade constraints;
drop table top_comm cascade constraints;
drop table udatafavoritetopics cascade constraints;
drop table udatafavoriteusers cascade constraints;
drop table udataratedtopics cascade constraints;

drop table appadress;

drop table person;


select * from appuser;
select * from appuserdata;
select * from apptopic;
select * from apptopiccategory;
select * from appuadress;

insert into apphobbies (id,name) values (1,'Gry');
insert into apphobbies (id,name) values (2,'Film');
insert into apphobbies (id,name) values (3,'Jedzenie');
insert into apphobbies (id,name) values (4,'Zakupy');
insert into apphobbies (id,name) values (5,'Muzyka');
insert into apphobbies (id,name) values (6,'Sport');
insert into apphobbies (id,name) values (7,'Kultura');
insert into apphobbies (id,name) values (8,'Sztuka');
insert into apphobbies (id,name) values (9,'Inne');

insert into apptopiccategory (id,name) values (1,'Gry');
insert into apptopiccategory (id,name) values (2,'Film');
insert into apptopiccategory (id,name) values (3,'Jedzenie');
insert into apptopiccategory (id,name) values (4,'Zakupy');
insert into apptopiccategory (id,name) values (5,'Muzyka');
insert into apptopiccategory (id,name) values (6,'Sport');
insert into apptopiccategory (id,name) values (7,'Kultura');
insert into apptopiccategory (id,name) values (8,'Sztuka');
insert into apptopiccategory (id,name) values (9,'Inne');

insert into apphobbies (id,name) values (1,'Games');
insert into apphobbies (id,name) values (2,'Movies');
insert into apphobbies (id,name) values (3,'Food');
insert into apphobbies (id,name) values (4,'Shoping');
insert into apphobbies (id,name) values (5,'Music');
insert into apphobbies (id,name) values (6,'Sport');
insert into apphobbies (id,name) values (7,'Culture');
insert into apphobbies (id,name) values (8,'Art');
insert into apphobbies (id,name) values (9,'Others');

insert into apptopiccategory (id,name) values (1,'Games');
insert into apptopiccategory (id,name) values (2,'Movies');
insert into apptopiccategory (id,name) values (3,'Food');
insert into apptopiccategory (id,name) values (4,'Shoping');
insert into apptopiccategory (id,name) values (5,'Music');
insert into apptopiccategory (id,name) values (6,'Sport');
insert into apptopiccategory (id,name) values (7,'Culture');
insert into apptopiccategory (id,name) values (8,'Art');
insert into apptopiccategory (id,name) values (9,'Others');

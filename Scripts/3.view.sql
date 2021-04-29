use pro_Library;

create or replace view vw_pro_Library_mem
as
select P.P_NO
     , P.P_NAME
     , P.P_BIRTH
     , P.P_PHONE
     , P.P_CELLPHONE
     , P.P_ADDRESS
     , M.M_ID
 from Profile p 
 join memberp m on p.P_NO = m.P_NO;
      
select * from vw_pro_Library_mem;
select * from vw_Book_Information;
      
-- bookinto
select B_NO, B_NAME, B_DIVISION, B_RENTAL from vw_Book_Information where B_NO = ?
select B_NO, B_NAME, B_DIVISION, B_RENTAL from vw_Book_Information where B_NAME = ?
select B_NO, B_NAME, B_DIVISION, B_RENTAL from vw_Book_Information where B_DIVISION = ?
select B_NO, B_NAME, B_DIVISION, B_RENTAL from vw_Book_Information where B_RENTAL = ?

create view vw_Book_Information 
as select B_NO, B_NAME, B_DIVISION, B_RENTAL
from Book_Information;



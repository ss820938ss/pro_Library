use Library;

create or replace view vw_pro_Library
as
select P.P_NO
     , P.P_NAME
     , B.B_NO as BOOK_NO
     , B.B_NAME as BOOK_NAME
     , P.P_BIRTH
     , P.P_PHONE
     , P.P_CELLPHONE
     , P.P_ADDRESS
     , B.B_DIVISION
     , B.B_RENTAL
 from Profile p join RENTAL_RETURN r
      left join profile c on p.p_name = c.p_no
      join Book_Information b;
-- profile
select P_NO, P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS from profile;
select P_NO, P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS from profile where P_NO = ?;
insert into title values (?, ?, ?, ?, ?, ?);
update Profile set P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS = ? where P_NO = ?;
delete from Profile where P_NO = ?;

-- book_information
select B_NO, B_NAME, B_DIVISION, B_RENTAL from book_information;
select B_NO, B_NAME, B_DIVISION, B_RENTAL from book_information where B_NO = ?
insert into Book_Information values (?, ?, ?, ?)
update book_information set B_NO = ?, B_NAME = ?, B_DIVISION = ?, B_RENTAL = ? where B_NO = ?
delete from book_information where B_NO = ? 

-- BookRegister
select B_NO, B_NAME, B_DIVISION from bookregister;
select B_NO, B_NAME, B_DIVISION from bookregister where B_NO = ?
insert into bookregister values (?, ?, ?)
update bookregister set B_NO = ?, B_NAME = ?, B_DIVISION = ? where B_NO = ?
delete from bookregister b where B_NO = ?

-- RentalReturn
select P_NO, B_NO, B_R_DATE, B_RETURN, B_OVERDUE from rental_return
select P_NO, B_NO, B_R_DATE, B_RETURN, B_OVERDUE from rental_return where P_NO = ?
insert into rental_return values (?, ?, ?, ?, ?)
update rental_return set P_NO = ?, B_NO = ?, B_R_DATE = ?, B_RETURN = ?, B_OVERDUE = ? where P_NO = ?
delete from rental_return where P_NO = ?
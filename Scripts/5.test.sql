select P_NO, P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS from profile;

select P_NO, P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS from profile where P_NO = ?;

insert into title values (?, ?, ?, ?, ?, ?);

update Profile set P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS = ? where P_NO = ?;

delete from Profile where P_NO = ?;
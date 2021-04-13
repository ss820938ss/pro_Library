-- 계정 권한 부여
grant all 
   on pro_Library.* 
   to 'user_pro_Library'@'localhost' identified by 'rootroot';

-- file 권한(backup, load) -- root만 권한 부여 가능
GRANT File 
   ON *.* 
   TO 'user_pro_Library'@'localhost';
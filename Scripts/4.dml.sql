use pro_library;

-- 회원정보 입력데이터
select * from profile;
	
insert into profile(P_NO, P_NAME, P_BIRTH, P_PHONE, P_CELLPHONE, P_ADDRESS) values
	(12001, '홍길동', '1907-04-05', '042-421-1739', '010-9741-5821', '대전'),
	(12002, '김연수', '1985-03-01', '064-446-8695', '010-4568-5581', '제주'),
	(12003, '김지원', '1986-07-08', '053-548-7898', '010-9111-5556', '대구'),
	(12004, '문희원', '1980-01-08', '052-221-1231', '010-7777-7777', '울산'),
	(12005, '유일한', '1979-02-05', '051-111-2222', '010-4566-8886', '부산'),
	(12006, '김동수', '1981-11-23',  '02-668-8887', '010-1231-1211', '서울'),
	(12007, '배진태', '1982-07-07', '044-500-7333', '010-7877-7777', '세종'),
	(12008, '류은수', '1983-03-01', '062-233-1122', '010-7444-1474', '광주'),
	(12009, '김동철', '1987-04-26', '061-887-4454', '010-8525-1235', '순천'),
	(12010, '최홍석', '1990-04-05', '054-555-7897', '010-3214-6547', '포항'),
	(12011, '김동수', '1983-01-08', '043-529-8457', '010-9566-4228', '제천');
	
	
-- 도서정보 입력데이터
select * from Book_Information;

insert into Book_Information(B_NO, B_NAME, B_DIVISION) values
	(40001, 'The elements of statistical learning', '수학'),
	(40002, 'Computer vision : a modern approach', '컴퓨터'),
	(40003, 'MATLAB for engineers', '전자'),
	(40004, 'CUBA by example', '수학'),
	(40005, 'An introduction to 3D computer vision', '컴퓨터'),
	(40006, 'Numerical methoods', '수학'),
	(40007, 'Image-based modeling', '컴퓨터'),
	(40008, 'Machine learning', '컴퓨터'),
	(40009, 'Probabilistic robotics', '통계'),
	(40010, 'Pattern recognition and machine learning', '컴퓨터');
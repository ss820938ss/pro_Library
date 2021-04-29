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

insert into Book_Information(B_NO, B_NAME, B_DIVISION, B_RENTAL) values
	(40001, 'The elements of statistical learning', '수학', null),
	(40002, 'Computer vision : a modern approach', '컴퓨터', null),
	(40003, 'MATLAB for engineers', '전자', null),
	(40004, 'CUBA by example', '수학', null),
	(40005, 'An introduction to 3D computer vision', '컴퓨터', null),
	(40006, 'Numerical methoods', '수학', null),
	(40007, 'Image-based modeling', '컴퓨터', null),
	(40008, 'Machine learning', '컴퓨터', null),
	(40009, 'Probabilistic robotics', '통계', null),
	(40010, 'Pattern recognition and machine learning', '컴퓨터', null),
	(40011, 'The elements of statistical learning', '수학', null),
	(40012, 'Computer vision : a modern approach', '컴퓨터', null),
	(40013, 'MATLAB for engineers', '전자', null),
	(40014, 'CUBA by example', '수학', null),
	(40015, 'An introduction to 3D computer vision', '컴퓨터', null),
	(40016, 'Numerical methoods', '수학', null),
	(40017, 'Image-based modeling', '컴퓨터', null),
	(40018, 'Machine learning', '컴퓨터', null),
	(40019, 'Probabilistic robotics', '통계', null),
	(40020, 'Pattern recognition and machine learning', '컴퓨터', null),
	(40021, 'The elements of statistical learning', '수학', null),
	(40022, 'Computer vision : a modern approach', '컴퓨터', null),
	(40023, 'MATLAB for engineers', '전자', null),
	(40024, 'CUBA by example', '수학', null),
	(40025, 'An introduction to 3D computer vision', '컴퓨터', null),
	(40026, 'Numerical methoods', '수학', null),
	(40027, 'Image-based modeling', '컴퓨터', null),
	(40028, 'Machine learning', '컴퓨터', null),
	(40029, 'Probabilistic robotics', '통계', null),
	(40030, 'Pattern recognition and machine learning', '컴퓨터', null);
	
-- 회원계정 입력데이터
select * from pro_library.memberp;

insert into Memberp(P_NO, M_ID, M_PASS) values
	(12001, 'member1', password('1234')),
	(12002, 'member2', password('1234')),
	(12003, 'member3', password('1234')),
	(12004, 'member4', password('1234')),
	(12005, 'member5', password('1234')),
	(12006, 'member6', password('1234')),
	(12007, 'member7', password('1234')),
	(12008, 'member8', password('1234')),
	(12009, 'member9', password('1234')),
	(12010, 'member10', password('1234')),
	(12011, 'member11', password('1234'));
			   
-- 도서기본정보
select * from pro_Library.Book_Dinfo;

insert into Book_Dinfo(B_NO, B_NAME, B_DIVISION, B_IMG) values
	(40001, 'The elements of statistical learning', '수학', 'image/b1.jpg'),
	(40002, 'Computer vision : a modern approach', '컴퓨터', 'image/b2.jpg'),
	(40003, 'MATLAB for engineers', '전자', 'image/b3.jpg'),
	(40004, 'CUBA by example', '수학', 'image/b4.jpg'),
	(40005, 'An introduction to 3D computer vision', '컴퓨터', 'image/b5.jpg'),
	(40006, 'Numerical methoods', '수학', 'image/b6.jpg'),
	(40007, 'Image-based modeling', '컴퓨터', 'image/b7.jpg'),
	(40008, 'Machine learning', '컴퓨터', 'image/b8.jpg'),
	(40009, 'Probabilistic robotics', '통계', 'image/b9.jpg'),
	(40010, 'Pattern recognition and machine learning', '컴퓨터', 'image/b10.jpg'),
	(40011, 'The elements of statistical learning', '수학', 'image/b1.jpg'),
	(40012, 'Computer vision : a modern approach', '컴퓨터', 'image/b2.jpg'),
	(40013, 'MATLAB for engineers', '전자', 'image/b3.jpg'),
	(40014, 'CUBA by example', '수학', 'image/b4.jpg'),
	(40015, 'An introduction to 3D computer vision', '컴퓨터', 'image/b5.jpg'),
	(40016, 'Numerical methoods', '수학', 'image/b6.jpg'),
	(40017, 'Image-based modeling', '컴퓨터', 'image/b7.jpg'),
	(40018, 'Machine learning', '컴퓨터', 'image/b8.jpg'),
	(40019, 'Probabilistic robotics', '통계', 'image/b9.jpg'),
	(40020, 'Pattern recognition and machine learning', '컴퓨터', 'image/b10.jpg'),
	(40021, 'The elements of statistical learning', '수학', 'image/b1.jpg'),
	(40022, 'Computer vision : a modern approach', '컴퓨터', 'image/b2.jpg'),
	(40023, 'MATLAB for engineers', '전자', 'image/b3.jpg'),
	(40024, 'CUBA by example', '수학', 'image/b4.jpg'),
	(40025, 'An introduction to 3D computer vision', '컴퓨터', 'image/b5.jpg'),
	(40026, 'Numerical methoods', '수학', 'image/b6.jpg'),
	(40027, 'Image-based modeling', '컴퓨터', 'image/b7.jpg'),
	(40028, 'Machine learning', '컴퓨터', 'image/b8.jpg'),
	(40029, 'Probabilistic robotics', '통계', 'image/b9.jpg'),
	(40030, 'Pattern recognition and machine learning', '컴퓨터', 'image/b10.jpg');

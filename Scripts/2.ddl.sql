-- 도서관리프로그램
DROP SCHEMA IF EXISTS pro_Library;

-- 도서관리프로그램
CREATE SCHEMA pro_Library;

-- 회원정보
CREATE TABLE pro_Library.Profile (
	P_NO        INT(5)      NOT NULL COMMENT '회원번호', -- 회원번호
	P_NAME      VARCHAR(20) NULL     COMMENT '회원이름', -- 회원이름
	P_BIRTH     VARCHAR(10) NULL     COMMENT '생년월일', -- 생년월일
	P_PHONE     VARCHAR(13) NULL     COMMENT '전화번호', -- 전화번호
	P_CELLPHONE VARCHAR(13) NULL     COMMENT '휴대전화', -- 휴대전화
	P_ADDRESS   VARCHAR(20) NULL     COMMENT '주소' -- 주소
)
COMMENT '회원정보';

-- 회원정보
ALTER TABLE pro_Library.Profile
	ADD CONSTRAINT PK_Profile -- 회원정보 기본키
		PRIMARY KEY (
			P_NO -- 회원번호
		);

-- 도서정보
CREATE TABLE pro_Library.Book_Information (
	B_NO       INT(5)      NOT NULL COMMENT '도서번호', -- 도서번호
	B_NAME     VARCHAR(40) NULL     COMMENT '도서제목', -- 도서제목
	B_DIVISION VARCHAR(4)  NULL     COMMENT '도서구분', -- 도서구분
	B_RENTAL   VARCHAR(4)  NULL     COMMENT '대출여부' -- 대출여부
)
COMMENT '도서정보';

-- 도서정보
ALTER TABLE pro_Library.Book_Information
	ADD CONSTRAINT PK_Book_Information -- 도서정보 기본키
		PRIMARY KEY (
			B_NO -- 도서번호
		);

-- 대출/반납
CREATE TABLE pro_Library.RENTAL_RETURN (
	P_NO      INT(5) NOT NULL COMMENT '회원번호', -- 회원번호
	B_NO      INT(5) NOT NULL COMMENT '도서번호', -- 도서번호
	B_R_DATE  DATE   NULL     COMMENT '도서대여일', -- 도서대여일
	B_RETURN  DATE   NULL     COMMENT '도서반납일', -- 도서반납일
	B_OVERDUE DATE   NULL     COMMENT '도서연체일' -- 도서연체일
)
COMMENT '대출/반납';

-- 도서등록
CREATE TABLE pro_Library.BookRegister (
	B_NO       INT(5)      NOT NULL COMMENT '도서번호', -- 도서번호
	B_NAME     VARCHAR(40) NULL     COMMENT '도서제목', -- 도서제목
	B_DIVISION VARCHAR(4)  NULL     COMMENT '도서구분' -- 도서구분
)
COMMENT '도서등록';

-- 도서등록
ALTER TABLE pro_Library.BookRegister
	ADD CONSTRAINT PK_BookRegister -- 도서등록 기본키
		PRIMARY KEY (
			B_NO -- 도서번호
		);

-- 회원계정
CREATE TABLE pro_Library.Memberp (
	P_NO   INT(5)      NOT NULL COMMENT '회원번호', -- 회원번호
	M_ID   VARCHAR(40) NULL     COMMENT '회원ID', -- 회원ID
	M_PASS CHAR(41)    NULL     COMMENT '회원PASS' -- 회원PASS
)
COMMENT '회원계정';

-- 회원계정
ALTER TABLE pro_Library.Memberp
	ADD CONSTRAINT PK_Memberp -- 회원계정 기본키
		PRIMARY KEY (
			P_NO -- 회원번호
		);

-- 도서기본정보
CREATE TABLE pro_Library.Book_Dinfo (
	B_NO       INT(5)       NOT NULL COMMENT '도서번호', -- 도서번호
	B_NAME     VARCHAR(40)  NULL     COMMENT '도서제목', -- 도서제목
	B_DIVISION VARCHAR(4)   NULL     COMMENT '도서구분', -- 도서구분
	B_IMG      VARCHAR(40) 	NULL     COMMENT '도서표지' -- 도서표지
)
COMMENT '도서기본정보';

-- 도서기본정보
ALTER TABLE pro_Library.Book_Dinfo
	ADD CONSTRAINT PK_Book_Dinfo -- 도서기본정보 기본키
		PRIMARY KEY (
			B_NO -- 도서번호
		);

-- 대출/반납
ALTER TABLE pro_Library.RENTAL_RETURN
	ADD CONSTRAINT FK_Book_Information_TO_RENTAL_RETURN -- 도서정보 -> 대출/반납
		FOREIGN KEY (
			B_NO -- 도서번호
		)
		REFERENCES pro_Library.Book_Information ( -- 도서정보
			B_NO -- 도서번호
		);

-- 대출/반납
ALTER TABLE pro_Library.RENTAL_RETURN
	ADD CONSTRAINT FK_Profile_TO_RENTAL_RETURN -- 회원정보 -> 대출/반납
		FOREIGN KEY (
			P_NO -- 회원번호
		)
		REFERENCES pro_Library.Profile ( -- 회원정보
			P_NO -- 회원번호
		);

-- 도서등록
ALTER TABLE pro_Library.BookRegister
	ADD CONSTRAINT FK_Book_Information_TO_BookRegister -- 도서정보 -> 도서등록
		FOREIGN KEY (
			B_NO -- 도서번호
		)
		REFERENCES pro_Library.Book_Information ( -- 도서정보
			B_NO -- 도서번호
		);

-- 회원계정
ALTER TABLE pro_Library.Memberp
	ADD CONSTRAINT FK_Profile_TO_Memberp -- 회원정보 -> 회원계정
		FOREIGN KEY (
			P_NO -- 회원번호
		)
		REFERENCES pro_Library.Profile ( -- 회원정보
			P_NO -- 회원번호
		);
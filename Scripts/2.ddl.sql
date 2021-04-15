-- 도서관리프로그램
DROP SCHEMA IF EXISTS pro_library;

-- 도서관리프로그램
CREATE SCHEMA pro_library;

-- 회원정보
CREATE TABLE pro_library.Profile (
	P_NO        INT(6)      NOT NULL COMMENT '회원번호', -- 회원번호
	P_NAME      VARCHAR(20) NULL     COMMENT '회원이름', -- 회원이름
	P_BIRTH     VARCHAR(10) NULL     COMMENT '생년월일', -- 생년월일
	P_PHONE     VARCHAR(13) NULL     COMMENT '전화번호', -- 전화번호
	P_CELLPHONE VARCHAR(13) NULL     COMMENT '휴대전화', -- 휴대전화
	P_ADDRESS   VARCHAR(20) NULL     COMMENT '주소' -- 주소
)
COMMENT '회원정보';

-- 회원정보
ALTER TABLE pro_library.Profile
	ADD CONSTRAINT PK_Profile -- 회원정보 기본키
		PRIMARY KEY (
			P_NO -- 회원번호
		);

-- 도서정보
CREATE TABLE pro_library.Book_Information (
	B_NO       INT(6)      NOT NULL COMMENT '도서번호', -- 도서번호
	B_NAME     VARCHAR(40) NULL     COMMENT '도서제목', -- 도서제목
	B_DIVISION VARCHAR(4)  NULL     COMMENT '도서구분', -- 도서구분
	B_RENTAL   VARCHAR(4)  NULL     COMMENT '대출여부' -- 대출여부
)
COMMENT '도서정보';

-- 도서정보
ALTER TABLE pro_library.Book_Information
	ADD CONSTRAINT PK_Book_Information -- 도서정보 기본키
		PRIMARY KEY (
			B_NO -- 도서번호
		);

-- 대출/반납
CREATE TABLE pro_library.RENTAL_RETURN (
	P_NO      INT(6) NOT NULL COMMENT '회원번호', -- 회원번호
	B_NO      INT(6) NOT NULL COMMENT '도서번호', -- 도서번호
	B_R_DATE  DATE   NULL     COMMENT '도서대여일', -- 도서대여일
	B_RETURN  DATE   NULL     COMMENT '도서반납일', -- 도서반납일
	B_OVERDUE DATE   NULL     COMMENT '도서연체일' -- 도서연체일
)
COMMENT '대출/반납';

-- 도서등록
CREATE TABLE pro_library.BookRegister (
	B_NO       INT(6)      NOT NULL COMMENT '도서번호', -- 도서번호
	B_NAME     VARCHAR(40) NULL     COMMENT '도서제목', -- 도서제목
	B_DIVISION VARCHAR(4)  NULL     COMMENT '도서구분' -- 도서구분
)
COMMENT '도서등록';

-- 도서등록
ALTER TABLE pro_library.BookRegister
	ADD CONSTRAINT PK_BookRegister -- 도서등록 기본키
		PRIMARY KEY (
			B_NO -- 도서번호
		);

-- 대출/반납
ALTER TABLE pro_library.RENTAL_RETURN
	ADD CONSTRAINT FK_Book_Information_TO_RENTAL_RETURN -- 도서정보 -> 대출/반납
		FOREIGN KEY (
			B_NO -- 도서번호
		)
		REFERENCES pro_library.Book_Information ( -- 도서정보
			B_NO -- 도서번호
		);

-- 대출/반납
ALTER TABLE pro_library.RENTAL_RETURN
	ADD CONSTRAINT FK_Profile_TO_RENTAL_RETURN -- 회원정보 -> 대출/반납
		FOREIGN KEY (
			P_NO -- 회원번호
		)
		REFERENCES pro_library.Profile ( -- 회원정보
			P_NO -- 회원번호
		);
		
-- 도서등록
ALTER TABLE pro_library.BookRegister
	ADD CONSTRAINT FK_Book_Information_TO_BookRegister -- 도서정보 -> 도서등록
		FOREIGN KEY (
			B_NO -- 도서번호
		)
		REFERENCES pro_library.Book_Information ( -- 도서정보
			B_NO -- 도서번호
		);
		
CREATE TABLE T_MEMBER(
	ID						VARCHAR(10)		PRIMARY KEY,
	PWD					VARCHAR(10)		NOT NULL,
	NAME					VARCHAR(50),
	EMAIL					VARCHAR(50)		NOT NULL,
	JOIN_DATE_TIME		TIMESTAMP		DEFAULT CURRENT_TIMESTAMP(),
	JOIN_DATE			DATE				AS (DATE(JOIN_DATE_TIME))
);

INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL)
VALUES('hong', '1212', '홍길동', 'hong@gmail.com');

INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL)
VALUES('lee', '1212', '이순신', 'lee@test.com');

INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL)
VALUES('kim', '1212', '김유신', 'kim@jweb.com');

SELECT * FROM T_MEMBER;
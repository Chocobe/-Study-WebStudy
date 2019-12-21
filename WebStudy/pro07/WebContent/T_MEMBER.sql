CREATE TABLE T_MEMBER(
	id						VARCHAR(10)		PRIMARY KEY,
	pwd					VARCHAR(10)		NOT NULL,
	name					VARCHAR(50),
	email					VARCHAR(50)		NOT NULL,
	joinDateTime		TIMESTAMP		DEFAULT CURRENT_TIMESTAMP(),
	joinDate			DATE				AS (DATE(joinDateTime))
);

INSERT INTO T_MEMBER(id, pwd, name, email)
VALUES('hong', '1212', '홍길동', 'hong@gmail.com');

INSERT INTO T_MEMBER(id, pwd, name, email)
VALUES('lee', '1212', '이순신', 'lee@test.com');

INSERT INTO T_MEMBER(id, pwd, name, email)
VALUES('kim', '1212', '김유신', 'kim@jweb.com');

SELECT * FROM T_MEMBER;

DELETE FROM t_member;
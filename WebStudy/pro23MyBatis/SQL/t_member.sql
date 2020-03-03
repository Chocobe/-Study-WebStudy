CREATE TABLE t_member(
	id				VARCHAR(30) PRIMARY KEY,
	pwd			VARCHAR(30)	NOT NULL,
	NAME			VARCHAR(30) NOT NULL,
	email			VARCHAR(30),
	joinDate		TIMESTAMP DEFAULT CURRENT_TIMESTAMP()
);

DESC t_member;


INSERT INTO t_member(id,
							pwd,
							NAME,
							email)
VALUES('id_1',
		 'pwd_1',
		 'name_1',
		 'email_1');
		 
		 
INSERT INTO t_member(id,
							pwd,
							NAME,
							email)
VALUES('id_2',
		 'pwd_2',
		 'name_2',
		 'email_2');
		 
		 
INSERT INTO t_member(id,
							pwd,
							NAME,
							email)
VALUES('id_3',
		 'pwd_3',
		 'name_3',
		 'email_3');
		 
		 
SELECT * FROM t_member ORDER BY joinDate DESC;
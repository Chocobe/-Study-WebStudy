-- 게시판 테이블 생성
DROP TABLE IF EXISTS t_board;

CREATE TABLE t_board(
	articleNO			INT				PRIMARY KEY,
	parentNO				INT				DEFAULT 0,
	title					VARCHAR(500)	NOT NULL,
	content				VARCHAR(4000)	NOT NULL,
	imageFileName		VARCHAR(30),
	writeDateTime		TIMESTAMP		DEFAULT CURRENT_TIMESTAMP(),
	writeDate			DATE				AS (DATE(writeDateTime)),
	id						VARCHAR(10),
	FOREIGN KEY(id)	REFERENCES	t_member(id)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;


-- 테스트 글 추가
INSERT INTO t_board(articleNO, parentNO, title, content, imageFileName, id)
VALUES(1, 0, '테스트글 입니다', '테스트글 입니다', NULL, 'hong');

INSERT INTO t_board(articleNO, parentNO, title, content, imageFileName, id)
VALUES(2, 0, '안녕하세요', '상품후기 입니다', NULL, 'hong');

INSERT INTO t_board(articleNO, parentNO, title, content, imageFileName, id)
VALUES(3, 2, '답변 입니다', '상품후기에 대한 답변 입니다', NULL, 'hong');

INSERT INTO t_board(articleNO, parentNO, title, content, imageFileName, id)
VALUES(4, 0, '김유신 입니다.', '김유신 테스트글 입니다', NULL, 'kim');

INSERT INTO t_board(articleNO, parentNO, title, content, imageFileName, id)
VALUES(5, 3, '답변 입니다.', '상품 좋습니다', NULL, 'lee');

INSERT INTO t_board(articleNO, parentNO, title, content, imageFileName, id)
VALUES(6, 2, '상품후기 입니다', '이순신씨의 상품 사용후기를 올립니다!!', NULL, 'lee');


SELECT * FROM t_board ORDER BY articleNO DESC;

DELETE FROM t_board;

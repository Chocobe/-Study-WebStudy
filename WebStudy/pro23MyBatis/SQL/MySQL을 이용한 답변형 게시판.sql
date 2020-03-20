CREATE TABLE board2(
	idx				INT AUTO_INCREMENT,
	groupIdx			INT DEFAULT NULL,
	groupPattern	VARCHAR(100) DEFAULT NULL,
	layer				INT DEFAULT NULL,
	
	title				VARCHAR(100) NOT NULL,
	content			VARCHAR(100) NOT NULL,
	writer			VARCHAR(100) NOT NULL,
	regDateTime		TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	
	PRIMARY KEY(idx)
);

DROP TABLE board2;
SELECT * FROM board2;


-- 1. 글 작성 - 1번글
INSERT INTO board2(title, content, writer)
VALUES('제목_1', '내용_1', '영우');
-- 2. idx값 찾기
SELECT * FROM board2
WHERE title='제목_1' AND content='내용_1' AND writer='영우'
ORDER BY regDateTime DESC
LIMIT 1;
-- 3. 트리값 보정
UPDATE board2
SET groupIdx = 1, groupPattern='1', layer=0
WHERE idx=1;


-- 1. 글 작성 - 2번글
INSERT INTO board2(title, content, writer)
VALUES('제목_2', '내용_2', '영우');
-- 2. idx값 찾기
SELECT * FROM board2
WHERE title='제목_2' AND content='내용_2' AND writer='영우'
ORDER BY regDateTime DESC
LIMIT 1;
-- 3. 트리값 보정
UPDATE board2
SET groupIdx = 2, groupPattern='2', layer=0
WHERE idx=2;


-- 1. 글 작성 - 3번글
INSERT INTO board2(title, content, writer)
VALUES('제목_3', '내용_3', '영우');
-- 2. idx값 찾기
SELECT * FROM board2
WHERE title='제목_3' AND content='내용_3' AND writer='영우'
ORDER BY regDateTime DESC
LIMIT 1;
-- 3. 트리값 보정
UPDATE board2
SET groupIdx = 3, groupPattern='3', layer=0
WHERE idx=3;


-- 1차 댓글 작성

-- 1.
INSERT INTO board2(title, content, writer)
VALUES('제목_2_1', '내용_2_1', '김');
-- 2.
SELECT * FROM board2
WHERE title='제목_2_1' AND content='내용_2_1' AND writer='김'
ORDER BY regDateTime DESC
LIMIT 1;
-- 3.
UPDATE board2
SET groupIdx = 2, groupPattern = '2-1', layer=1
WHERE idx=4;


-- 1.
INSERT INTO board2(title, content, writer)
VALUES('제목_2_1_1', '내용_2_1_1', '이');
-- 2.
SELECT * FROM board2
WHERE title='제목_2_1_1' AND content='내용_2_1_1' AND writer='이'
ORDER BY regDateTime DESC
LIMIT 1;
-- 3.
UPDATE board2
SET groupIdx = 2, groupPattern = '2-1-1', layer=2
WHERE idx=5;


-- 1.
INSERT INTO board2(title, content, writer)
VALUES('제목_2_2', '내용_2_2', '김');
-- 2.
SELECT * FROM board2
WHERE title='제목_2_2' AND content='내용_2_2' AND writer='김'
ORDER BY regDateTime DESC
LIMIT 1;
-- 3.
UPDATE board2
SET groupIdx = 2, groupPattern = '2-2', layer=1
WHERE idx=6;


-- 1.
INSERT INTO board2(title, content, writer)
VALUES('제목_2_1_2', '내용_2_1_2', '이');
-- 2.
SELECT * FROM board2
WHERE title='제목_2_1_2' AND content='내용_2_1_2' AND writer='이'
ORDER BY regDateTime DESC
LIMIT 1;
-- 3.
UPDATE board2
SET groupIdx = 2, groupPattern = '2-1-2', layer=2
WHERE idx=7;



-- 트리형으로 조회
SELECT (CASE layer
				WHEN 0 THEN title
				ELSE CONCAT(CONCAT(LPAD('', layer * 4, ' '), '└ RE: '), title)
		  END) AS title,
		 
		 content,
		 writer,
		 regDateTime,
		 
		 idx, groupIdx, groupPattern, layer
FROM board2
ORDER BY groupIdx DESC, groupPattern ASC;
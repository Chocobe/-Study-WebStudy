CREATE TABLE treeboard(
	idx				INT AUTO_INCREMENT,
	groupIdx			INT,
	groupPattern	VARCHAR(300),
	layer				INT,
	
	id					VARCHAR(100) NOT NULL,
	title				VARCHAR(100) NOT NULL,
	content			VARCHAR(100) NOT NULL,
	
	PRIMARY KEY(idx)
);

DESC treeboard;
DROP TABLE treeboard;
SELECT * FROM treeboard;


-- [ 데이터 입력 ] : 입력 트랜잭션
-- 1. 글 작성
INSERT INTO treeboard(id, title, content)
VALUES('id_1', 'title_1', 'content_1');
-- 2. 작성글 idx 조회
SELECT * FROM treeboard WHERE id='id_1' AND title='title_1' AND content='content_1';
-- 3. 트리 데이터 보정
UPDATE treeboard SET groupIdx = 1, groupPattern = '1', layer = 0
WHERE idx = 1;


-- 1. 글 작성
INSERT INTO treeboard(id, title, content)
VALUES('id_2', 'title_2', 'content_2');
-- 2. 작성글 idx 조회
SELECT * FROM treeboard WHERE id='id_2' AND title='title_2' AND content='content_2';
-- 3. 트리 데이터 보정
UPDATE treeboard SET groupIdx = 2, groupPattern = '2', layer = 0
WHERE idx = 2;

-- 1. 글 작성
INSERT INTO treeboard(id, title, content)
VALUES('id_3', 'title_3', 'content_3');
-- 2. 작성글 idx 조회
SELECT * FROM treeboard WHERE id='id_3' AND title='title_3' AND content='content_3';
-- 3. 트리 데이터 보정
UPDATE treeboard SET groupIdx = 3, groupPattern = '3', layer = 0
WHERE idx = 3;


-- [ 1차 댓글 작성 ]
-- 1. 댓글 작성
INSERT INTO treeboard(id, title, content)
VALUES('id_2_1', 'title_2_1', 'content_2_1');
-- 2. 작성 댓글 idx 조회
SELECT * FROM treeBoard WHERE id='id_2_1' AND title='title_2_1' AND content='content_2_1';
-- 3. 트리 데이터 보정
UPDATE treeboard SET groupIdx = '2', groupPattern = '2_1', layer = 1
WHERE idx = 4;


-- 1. 댓글 작성
INSERT INTO treeboard(id, title, content)
VALUES('id_3_1', 'title_3_1', 'content_3_1');
-- 2. 작성 댓글 idx 조회
SELECT * FROM treeboard WHERE id='id_3_1' AND title='title_3_1' AND content='content_3_1';
-- 3. 트리 데이터 보완
UPDATE treeboard SET groupIdx = '3', groupPattern = '3_1', layer = 1
WHERE idx = 5;


-- 1. 댓글 작성
INSERT INTO treeboard(id, title, content)
VALUES('id_2_2', 'title_2_2', 'content_2_2');
-- 2. 작성 댓글 idx 조회
SELECT * FROM treeboard WHERE id='id_2_2' AND title='title_2_2' AND content='content_2_2';
-- 3. 트리 데이터 보완
UPDATE treeboard SET groupIdx = '2', groupPattern = '2_2', layer = 1
WHERE idx = 6;


-- [ 2차 댓글 작성 ]
-- 1. 댓댓글 작성
INSERT INTO treeboard(id, title, content)
VALUES('id_2_1_1', 'title_2_1_1', 'content_2_1_1');
-- 2. 작성 댓댓글 idx 조회
SELECT * FROM treeboard WHERE id='id_2_1_1' AND title='title_2_1_1' AND content='content_2_1_1';
-- 3. 트리 데이터 보완
UPDATE treeboard SET groupIdx = '2', groupPattern = '2_1_1', layer = 2
WHERE idx = 7;


-- [ 트리형으로 전체 조회 ]
SELECT (CASE layer
				WHEN 0
				THEN title
				
				ELSE CONCAT(CONCAT(LPAD('', layer * 4, ' '), '└ RE: '), title)
		  END) AS title,
		  content,
		  id,
		  
		  idx, groupIdx, groupPattern, layer
FROM treeboard
ORDER BY groupIdx DESC, groupPattern ASC;
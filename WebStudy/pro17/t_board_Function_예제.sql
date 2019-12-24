-- 계층형 함수 구현하기 예제
CREATE TABLE animal(
	id		INT	UNSIGNED NOT NULL AUTO_INCREMENT,
	p_id	INT	UNSIGNED DEFAULT 0,
	nm		VARCHAR(50),
	PRIMARY KEY(id)
);

INSERT INTO animal(p_id, nm)
VALUES(0, '동물');

INSERT INTO animal(p_id, nm)
VALUES(1, '말');

INSERT INTO animal(p_id, nm)
VALUES(1, '닭');

INSERT INTO animal(p_id, nm)
VALUES(2, '얼룩말');

INSERT INTO animal(p_id, nm)
VALUES(2, '조랑말');

INSERT INTO animal(p_id, nm)
VALUES(3, '흰닭');

INSERT INTO animal(p_id, nm)
VALUES(3, '검은닭');

INSERT INTO animal(p_id, nm)
VALUES(5, '망아지');

INSERT INTO animal(p_id, nm)
VALUES(6, '흰병아리');

INSERT INTO animal(p_id, nm)
VALUES(7, '검은병아리');

INSERT INTO animal(p_id, nm)
VALUES(9, '흰달걀');

INSERT INTO animal(p_id, nm)
VALUES(10, '검은달걀');


SELECT * FROM animal;



-- fnc_hierachi()
DROP FUNCTION IF EXISTS fnc_hierarchi;
 
DELIMITER $$
 
CREATE FUNCTION  fnc_hierarchi() RETURNS INT
 
NOT DETERMINISTIC
 
READS SQL DATA
 
BEGIN
 
    DECLARE v_id INT;
    DECLARE v_parent INT;    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET @id = NULL;
 
    SET v_parent = @id;
    SET v_id = -1;
 
    IF @id IS NULL THEN
        RETURN NULL;
    END IF;
 
    LOOP
    
    SELECT MIN(id)
      INTO @id 
      FROM ANIMAL
     WHERE p_id = v_parent
       AND id > v_id;
 
    IF (@id IS NOT NULL) OR (v_parent = @start_with) THEN
       SET @level = @level + 1;
    RETURN @id;
    END IF;
    
    SET @level := @level - 1;
 
    SELECT id, p_id
      INTO v_id , v_parent 
        FROM ANIMAL
       WHERE id = v_parent;
   
    END LOOP;
 
END
 
$$
 
DELIMITER ;


-- 계층형으로 조회하기
SELECT CASE WHEN LEVEL-1 > 0 then CONCAT(CONCAT(REPEAT('    ', level  - 1),'┗'), ani.nm)
                 ELSE ani.nm
           END AS nm
     , ani.id
     , ani.p_id
     , fnc.level
  FROM
     (SELECT fnc_hierarchi() AS id, @level AS level
        FROM (SELECT @start_with:=0, @id:=@start_with, @level:=0) vars
          JOIN ANIMAL
         WHERE @id IS NOT NULL) fnc
  JOIN ANIMAL ani ON fnc.id = ani.id
-- WHERE ani.p_id = 2
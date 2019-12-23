-- articleNO
-- parentNO
-- title


-- t_board 테이블 계층형 함수
DROP FUNCTION IF EXISTS fnc_hierarchi;
 
DELIMITER $$
 
CREATE FUNCTION  fnc_hierarchi() RETURNS INT
 
NOT DETERMINISTIC
 
READS SQL DATA
 
BEGIN
 
    DECLARE v_articleNO INT;
    DECLARE v_parentNO INT;    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET @articleNO = NULL;
 
    SET v_parentNO = @articleNO;
    SET v_articleNO = -1;
 
    IF @articleNO IS NULL THEN
        RETURN NULL;
    END IF;
 
    LOOP
    
    SELECT MIN(articleNO)
      INTO @articleNO
      FROM t_board
     WHERE parentNO = v_parentNO
       AND articleNO > v_articleNO;
 
    IF (@articleNO IS NOT NULL) OR (v_parentNO = @start_with) THEN
       SET @level = @level + 1;
    RETURN @articleNO;
    END IF;
    
    SET @level := @level - 1;
 
    SELECT articleNO, parentNO
      INTO v_articleNO , v_parentNO
        FROM t_board
       WHERE articleNO = v_parentNO;
   
    END LOOP;
 
END
 
$$
 
DELIMITER ;



-- 계층형으로 SELECT
SELECT CASE WHEN LEVEL-1 > 0 then CONCAT(CONCAT(REPEAT('    ', level  - 1),'┗'), board.title)
                 ELSE board.title
           END AS title
     , board.articleNO
     , board.parentNO
     , fnc.level
  FROM
     (SELECT fnc_hierarchi() AS articleNO, @level AS level
        FROM (SELECT @start_with:=0, @articleNO:=@start_with, @level:=0) vars
          JOIN t_board
         WHERE @articleNO IS NOT NULL) fnc
  JOIN t_board board ON fnc.articleNO = board.articleNO
#	MySQL (t_board_Function.sql)

*	``DELIMITER 기호`` : 명령분리문자를 ``기호``로 변경한다.

	*	MySQL에서 프로시저나 함수는 (;)으로 명령분리되는 명령어들의 집합이다. 이를 프로시저나 함수의 단위로 만들기 위해 일시적으로 명령분리문자를 변경하여 사용한다.
	
	```sql
	DELIMITER $$
	
	함수나 프로시저 정의 BEGIN
	...
	END
	$$
	
	DELIMITER ;
	``` 
	
*	``READS SQL DATA`` : 읽기 전용 함수임을 명시한다.

*	``BEGIN`` ~ ``END`` : 함수의 동작을 정의한다.

*	``DECLARE 변수명 타입`` : Stored Procedure 변수

	*	가장 좁은 범위 변수(지역변수와 비슷한 개념)

*	``@변수명`` : 세션변수

	*	세션 내에서 사용되는 변수(전역변수와 비슷한 개념)
	
*	``DECLARE CONTINUE HANDLER FOR NOT FOUND SET @articleNO = NULL;``

	* 커서가 마지막에 도착했을 때의 값을 정의한다. (세션변수 articleNO에 NULL을 대입)
	
*	``SELECT 컬럼명1, 컬럼명2, ... INTO 변수1, 변수2, ... FROM 테이블명 WHERE 조건;``

	*	``SELECT``한 컬럼들을 매칭되는 변수에 담는다.
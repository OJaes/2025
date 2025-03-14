USE practice_sql;

-- 데이터 조작어(DML)
-- 테이블에 데이터 삽입, ㅈ회, 수정, 삭제할 때 사용

-- INSERT : 테이블에 레코드를 삽입하는 명령어

-- 1. 모든 칼럼에 대하여 삽입
-- INSERT INTO 테이블명 VALUES(데이터1, 데이터2 ,....);
-- 테이블 구조의 컬럼 순서에 맞게 모든 데이터 입력해야 함.
INSERT INTO example_table VALUES ('A', "B");

-- 2. 특정 칼럼을 선택하여 삽입
-- INSERT INTO 테이블명(칼럼명1, 칼럼명2)
-- VALUES (데이터1, 데이터2);
-- 지정한 칼럼의 순서와 데이터의 순서가 일치해야 함
-- 만약 DEFAULT 값이 NOT NULL인 칼럼은 반드시 데이터 삽입이 필요함
INSERT INTO example_table (example_column2)
VALUES ('선택데이터');


-- SELECT : 테이블에서 레코드를 조회할 때 사용하는 명령어

-- 1. 모든 데이터 조회
-- SELECT * FROM 테이블명
SELECT * FROM example_table;

-- 2. 컬럼 선택 조회
-- SELECT 조회할 칼럼, .... FROM 테이블명;
SELECT example_column2 FROM example_table;

-- 3. 레코드 선택 조회
-- SELECT * FROM 테이블명 WHERE
SELECT * FROM example_table WHERE column1 IS NULL;


-- UPDATE : 테이블에서 레코드를 수정할 때 사용하는 명령어
-- UPDATE 테이블명 SET 컬러명 = 변경할데이터, ... WHERE 조건;
UPDATE example_table SET column1 = 'B';

UPDATE example_table SET COLUMN1 = 'C' where example_column2 = 'B';

-- DELETE : 테이블에서 레코드를 삭제할 때 사용하는 명령어
-- DELETE FROM 테이블명 WHERE 조건;
DELETE FROM example_table WHERE column1 = 'c';
DELETE FROM example_table;

-- DROP TABLE : DDL 테이블 구조 전체 제거
-- TRUNCATE TABLE : DDL 테이블 구조만 남기고 상태 초기화
-- DELETE FROM : DML 테이블 레코드만 제거

TRUNCATE TABLE example_table;

CREATE TABLE auto_table(
	idx INT PRIMARY KEY AUTO_INCREMENT,
    num INT
);

INSERT INTO auto_table (num) VALUES (0);
SELECT * FROM auto_table;

DELETE FROM auto_table;					-- auto_increment는 그대로 저장해둔 상태. 즉 값만 초기화
TRUNCATE TABLE auto_table;				-- auto_increment까지 전부 처음부터 시작. 즉 초기화
DROP TABLE auto_table;

-- INSERT INTO SELECT : 삽입 작업시에 조회 결과를 사용하여 삽입
INSERT INTO example_table
SELECT * FROM example_table WHERE column1 IS NULL;

SELECT * FROM example_table;























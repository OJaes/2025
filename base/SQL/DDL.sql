# 주석
-- 주석
-- 일반적인 주석은 --을 사용
-- DDL(데이터 정의어)
-- 데이터베이스를 DB, 테이블, 인덱스, 사용자를 정의하고 관리하는데 사용되는 언어

-- CREATE : 구조를 생성하는 명령어
-- CREATE 생성할구조 구조이름 [구조별 옵션];

-- 데이터베이스 생성
CREATE DATABASE practice_sql;
-- 데이터베이스 사용 : 데이터베이스 작업을 수행하기 전에 반드시 사용할 DB를 선택해야 함
USE practice_sql;

-- 테이블 생성
CREATE TABLE example_table (
	example_column1 INT,
    example_column2 BOOLEAN
);


-- 컬럼의 데이터 타입
CREATE TABLE data_type (
	int_c INT,
	double_c DOUBLE,
    float_c FLOAT,
    boolean_c BOOLEAN,
    -- VARCHAR은 문자열 길이를 같이 지정해줘야 함(가변길이 문자열)
    varchar_c VARCHAR(5),
    -- TEXT : 고정된 크기를 가지는 문자열 (64KB) // INDEX, DEFAULT 제약조건 사용 불가
    text_c TEXT,
    -- DATE : 날짜
    date_c DATE,
    -- DATETIME : 날짜 및 시간
    datetime_c DATETIME
);

-- 사용자 생성
-- CREATE USER '사용자명'@'접속IP' IDENTIFIED BY '비밀번호';
CREATE USER 'developer'@'%' IDENTIFIED BY 'pass';

CREATE USER 'guest'@'192.168.100.247' IDENTIFIED BY 'qwer1234';

-- DROP : 데이터 구조 (스키마)를 삭제할 대 사용하는 명령어
-- DROP 구조이름(스키마명)

-- 사용자 삭제
DROP USER 'guest'@'192.168.1.101';

-- 테이블 삭제
DROP TABLE data_type;

-- 데이터베이스 삭제
DROP DATABASE practice_sql;

-- ALTER : 데이터 구조 변경하는 명령어

-- 테이블 컬럼 추가
ALTER TABLE example_table ADD example_column3 VARCHAR(10);

-- 테이블 컬럼 삭제
ALTER TABLE example_table DROP example_column3;

-- 테이블 컬럼 수정
ALTER TABLE example_table MODIFY example_column2 TEXT;

-- 테이블 컬럼 전체 수정
ALTER TABLE example_table CHANGE example_column1 column1 VARCHAR(5);

-- 데이터베이스 문자셋 수정
ALTER DATABASE practice_sql DEFAULT CHARACTER SET UTF8;



    
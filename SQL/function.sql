USE practice_sql;

-- 조건문
-- CASE: 특정 값을 비교해서 일치하는 작업을 수행

-- CASE 컬럼
--       WHEN 비교값1 THEN 비교값1과 컬럼이 일치할 때 결과
--       WHEN 비교값2 THEN 비교값2와 컬럼이 일치할 때 결과
--       ...
--       ELSE 비교값1과 비교값2가 모두 컬럼과 일치하지 않을때 결과
-- END

-- CASE
--       WHEN 조건 표현식1 THEN 조건 표현식1이 참일 때 결과
--       WHEN 조건 표현식2 THEN 조건 표현식2가 참일 때 결과
--       ...
--       ELSE 위의 모든 표현식이 거짓일 때 결과
-- END

SELECT date, (
   CASE
      WHEN amount > 100000 THEN '고액'
        WHEN amount > 50000 THEN '일반'
        ELSE '소액'
   END
    ) '금액'
    FROM sale;
    
-- 함수
-- 문자열 함수: 문자열 데이터를 처리할 때 사용되는 함수

-- CONCAT(문자열,문자열, ....): 문자열 결합
-- CONCAT('안녕', '하세요', '!') -> '안녕하세요!'

-- LENGTH(문자열): 문자열 길이 반환
-- LENGTH('안녕하세요!') -> 16

-- SUBSTRING(문자열, 시작위치, 개수): 문자열의 특정 부분을 반환
-- SUBSTRING('안녕하세요!', 2,3) 여기서는 인덱스가 아니라 (시작위치,몇개)임. -> '녕하세'

-- TRIM(문자열): 문자열의 앞뒤 공백 제거
-- TRIM('   안녕   ') ->'안녕'

-- UPPER(문자열): 문자열을 모두 대문자로 변환
-- UPPER('abc') -> 'ABC'

-- LOWER(문자열): 문자열을 모두 소문자로 변환
-- LOWER('ABC') -> 'abc'

-- REPLACE(문자열, 이전문자열, 바꿀문자열): 문자열의 특정 문자열을 다른 문자열로 변환
-- REPLACE('I am Ironman', 'Ironman', 'Hulk') -> 'I am Hulk'

-- 숫자 함수: 숫자 연산과 관련된 함수

-- ABS(숫자): 절대값 반환
-- ABS(-99) -> 99

-- CEIL(숫자): 올림값 반환
-- CEIL(4.2) -> 5

-- FLOOR(숫자): 내림값 반환
-- FLOOR(4.7) -> 4

-- ROUND(숫자, 소수점자릿수): 반올림값 반환
-- ROUND(3.14159, 2) -> 3.14

-- 날짜 함수: 닐찌와 시간을 처리하는 함수

-- NOW(): 현재 날짜 및 시간 반환
SELECT NOW();

-- CURDATE(): 현재 날짜 반환
SELECT CURDATE();

-- CURTIME(): 현재 시간 반환
SELECT CURTIME();

-- DATEDIFF(날짜, 날짜): 두 날짜 간의 차이 반환
SELECT DATEDIFF('2025-01-01','2025-01-20');

-- DATE_FORMAT(날짜, 문자열포멧): 날짜를 특정 형식으로 변환
SELECT DATE_FORMAT(CURDATE(), '%Y.%m.%d.');

-- 조건 함수: 특정 조건에 따라 결과를 반환하는 함수
-- IF(조건 표현식, 참일때, 거짓일때): 조건에 따른 값을 반환
SELECT amount, IF(amount > 100000, '고액','일반')
FROM sale;

-- IFNULL(컬럼, 널일때값): 값이 NULL이면 지정한 값으로 반환
SELECT note, IFNULL(note,'비어있음')
FROM transaction;

-- NULLIF(컬럼,컬럼): 두값이 같으면 null을 반환
SELECT 
unique_column, 
not_unique_column, 
NULLIF(unique_column, not_unique_column) 'NULLIF'
FROM unique_table;

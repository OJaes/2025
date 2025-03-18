USE practice_sql;

-- 거래내역 테이블
-- 거래번호 정수
-- 거래일자 날짜
-- 거래구분 가변문자열10
-- 내역 장문의 문자열
-- 금액 실수
-- 세금 실수
-- 비고 장문의 문자열

CREATE TABLE transaction(
transaction_number Int,
transaction_date DATE,
transaction_type VARCHAR(10),
breakdown text,
amount float,
tax float,
note text
);

insert into transaction value(1,'2025-01-16','구매','기타자재',100000,10000,null); 

insert into transaction value(2,'2025-01-16','판매','영양제',70000,7000,'종합비타민');

insert into transaction value(3,'2025-01-17','판매','영양제',120000,12000,'종합비타민');  

insert into transaction value(4,'2025-01-17','구매','책상',400000,40000,'4개 구매');

insert into transaction value(5,'2025-01-17','구매','의자',200000,20000,'4개 구매');  

insert into transaction value(6,'2025-01-20','판매','의약외품',100000,10000,'소염 진통제');  
insert into transaction value(7,'2025-01-21','판매','의약외품',50000,5000,'소염 진통제');  
insert into transaction value(8,'2025-01-21','구매','기타자재',10000,1000,'볼펜 및 노트');  
insert into transaction value(9,'2025-01-24','판매','의료기기',800000,80000,'휠체어');  
insert into transaction value(10,'2025-01-25','판매','의료기기',50000,5000,'체온계');  

select * from transaction;
-- 연산자

-- 산술 연산자
-- + - * / %

SELECT amount + tax FROM transaction;

-- 비교 연산자
-- 좌항과 우항을 비교하는 연산자
-- WHERE 절에서 자주 사용됨. 원하는 레코드를 정확히 조회하는데 중요한 역할을 수행함
-- = : 좌항과 우항이 같으면 TRUE
SELECT * FROM transaction
WHERE transaction_type = '구매';

-- <>, != : 좌항과 우항이 다르면 TRUE
SELECT * FROM transaction
WHERE transaction_type <> '구매';

SELECT * FROM transaction
WHERE breakdown != '영양제';

-- < : 좌항이 우항보다 작으면 TRUE
-- <= : 좌항이 우항보다 작거나 같으면 TRUE
-- > : 좌항이 우항보다 크면 TRUE
-- >= : 좌항이 우항보다 크거나 같으면 TRUE

SELECT * FROM transaction
WHERE amount < 70000;

SELECT * FROM transaction
WHERE amount <= 70000;

SELECT * FROM transaction
WHERE amount > 70000;

SELECT * FROM transaction
WHERE amount >= 70000;

ALTER TABLE transaction ADD complete BOOLEAN;

SELECT * FROM transaction;

UPDATE transaction SET complete = true
WHERE transaction_number % 3 = 1;

UPDATE transaction SET complete = false
WHERE transaction_number % 3 = 2;

UPDATE transaction SET note = null
WHERE transaction_number = 6;

-- <=> : 좌항과 우항이 모두 null이면 true
SELECT * FROM transaction
WHERE note <=> complete;

-- IS : 좌항이 우항과 같으면 TRUE(키워드)
-- IS NOT : 좌항이 우항과 다르면 TRUE(키워드)
SELECT * FROM transaction
WHERE complete IS TRUE;

SELECT * FROM transaction
where complete is not null;

-- BETWEEN min AND max : 좌항이 min보다 크거나 같으면서 MAX보다 작거나 같으면 TRUE
-- NOT BETWEEN min AND max : 좌항이 min 보다 적거나 MAX 보다 크면 TRUE
SELECT * FROM transaction
WHERE transaction_date BETWEEN '2025-01-18' AND '2025-01-22';

SELECT * FROM transaction
WHERE amount NOT BETWEEN 70000 AND 100000;

-- IN() : 주어진 리스트 중에 하나라도 일치하면 TRUE
-- NOT IN() : 주어진 리스트 중에 하나라도 일치하지 않으면 TRUE
SELECT * FROM transaction
WHERE breakdown IN('영양제', '의약외품');


-- 논리 연산자

-- AND, && : 좌항과 우항이 모두 TRUE이면 TRUE
-- OR, || : 좌항이나 우항 중 하나라도 TRUE 이면 TRUE

SELECT * FROM transaction
WHERE amount > 100000 AND transaction_type = '구매';

SELECT * FROM transaction
WHERE transaction_date >= '2025-01-20' || breakdown = '기타자재';

-- XOR : 좌항과 우항이 서로 다르면 TRUE
SELECT * FROM transaction
-- WHERE transaction_date >= '2025-01-20' XOR breakdown = '기타자재';
WHERE transaction_date >= '2025-01-20' AND breakdown != '기타자재' OR transaction_date < '2025-01-20' AND breakdown = '기타자재';

-- NOT, ! : 부정연산자
SELECT * FROM transaction
WHERE NOT (transaction_type = '구매');

-- LIKE 연산자 : 문자열을 패턴을 기준으로 비교하고자 할 때 사용
-- _ : 임의의 한 문자
-- % : 임의의 문자
SELECT * FROM transaction
WHERE transaction_date LIKE '2025-01-%';

SELECT * FROM transaction
WHERE transaction_date LIKE '2025-01-__';

SELECT * FROM transaction
WHERE breakdown LIKE '의_';

SELECT * FROM transaction
WHERE breakdown LIKE '의%';

-- 정렬
-- ORDER BY: 조회 결과를 기준으로 특정 컬럼에 대해 정렬
-- ASC, DESC : 오름차순, 내림차순
SELECT * FROM transaction
ORDER BY amount ASC;

SELECT * FROM transaction
ORDER BY amount DESC;

SELECT * FROM transaction
ORDER BY transaction_type, amount DESC;

-- 중복 제거 내용
-- DISTINCT : SELECT 결과 테이블에서 칼럼 조합의 중복을 제거
SELECT DISTINCT transaction_type FROM transaction;
SELECT DISTINCT transaction_type, breakdown FROM transaction;
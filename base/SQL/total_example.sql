create database school;
USE school;

-- 학생 테이블 ( 학번, 이름, 주소, 전화번호)
create table student (
	student_number VARCHAR(5) not null unique, -- PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(15) NOT NULL,
    address TEXT NOT NULL,
    tel_number varchar(13) unique,
    constraint student_pk
    PRIMARY KEY (student_number)
    );
    
-- 교사(교번, 이름, 주소, 휴대전화번호, 직급)
create table teacher(
	teacher_number varchar(10) not null UNIQUE, -- primary key AUTO_INCREMENT,
    name varchar(15) not null,
    address text not null,
    telnumber varchar(13) unique,
    position varchar(50) not null default('일반교사'),
    constraint teacher_pk
    primary key (teacher_number)
);

-- 교실(교실 번호, 층, 좌석)
create table classroom(
	classroom_number int not null unique AUTO_INCREMENT, -- primary key AUTO_INCREMENT,
    floor int not null check(floor > 0),
    seats int not null check( seats >= 0),
    CONSTRAINT classroom_pk
    PRIMARY KEY (classroom_number)
    );
    
-- 수업은 교실과 교사에 종속적
-- 수업(수업 코드, 이름)
-- 교실_fk 정수 NN (교실 - 교실번호)
-- 담당교사_fk varchar(10) NN (교사 - 교번)
create table class(
	class_code varchar(3) not null unique,  -- primary key AUTO_INCREMENT,
    name varchar(50) not null,
    classroom int not null,
    charge_teacher varchar(10) not null,
    
    CONSTRAINT class_pk
    PRIMARY KEY (class_code),
    constraint classroom_class_fk FOREIGN KEY (classroom)
    REFERENCES classroom(classroom_number),
    constraint teacher_class_fk FOREIGN KEY (charge_teacher)
    REFERENCES teacher(teacher_number)
);
-- 수업은 교실, 교사와는 1:1 관계
-- 학생과는 1:n의 관계
-- 단, 수업은 반드시 교실 및 교사가 존재해야 하고 1명 이상의 학생이 수업을 들어야 한다.
-- 교실, 교사는 여러 수업을 진행할 수 있고, 학생은 여러 수업을 수강할 수 있음

-- 교실 : 수업 = 1:n
-- 교사 : 수업 = 1:n / 학생 : 수업 = n : m
-- n의 위치에 fk를 걸어준다

-- 수강(학번, 수업코드)
-- n:m의 관계이므로 관계 테이블 형성
-- 부가적인 기능 모두 구현
-- 성적 int 

create table class_regist (
	student_number varchar(5) not null,
    class_code varchar(3) not null,
	score int,
    CONSTRAINT class_regist_pk PRIMARY KEY (student_number, class_code),
    CONSTRAINT class_regist_student_fk
    FOREIGN KEY(student_number) REFERENCES student (student_number),
    CONSTRAINT class_regist_class_fk
    FOREIGN KEY (class_code) REFERENCES class (class_code)
);

-- 기본 레코드 삽입
INSERT INTO student VALUES ('25001', '홍길동', '부산광역시 부산진구', null);
INSERT INTO student VALUES ('25002', '김철수', '부산광역시 동구', '010-1111-1111');
INSERT INTO student VALUES ('25003', '이영희', '부산광역시 부산진구', '010-1111-2222');
INSERT INTO student VALUES ('25004', '홍길순', '부산광역시 수영구', null);
INSERT INTO student VALUES ('25005', '박보검', '부산광역시 동구', '010-1111-3333');
INSERT INTO student VALUES ('25006', '권지용', '부산광역시 동구', '010-1111-4444');
INSERT INTO student VALUES ('25007', '김태희', '부산광역시 부산진구', '010-1111-5555');
INSERT INTO student VALUES ('25008', '배수지', '부산광역시 중구', null);
INSERT INTO student VALUES ('25009', '남주혁', '부산광역시 부산진구', '010-1111-6666');
INSERT INTO student VALUES ('25010', '한가인', '부산광역시 수영구', '010-1111-7777');

INSERT INTO teacher VALUE ('2000010101', '이성계', '부산광역시 강서구', '010-2222-1111', '교장');
INSERT INTO teacher VALUE ('2000010102', '이방과', '부산광역시 북구', '010-2222-2222', '교감');
INSERT INTO teacher VALUE ('2010010101', '이방원', '대구광역시 달성구', '010-2222-3333', '일반교사');
INSERT INTO teacher VALUE ('2010010102', '이도', '부산광역시 부산진구', '010-2222-4444', '일반교사');
INSERT INTO teacher VALUE ('2010010103', '이향', '부산광역시 강서구', '010-2222-5555', '교생');


INSERT INTO classroom (floor, seats) VALUES (1, 20);
INSERT INTO classroom (floor, seats) VALUES (1, 20);
INSERT INTO classroom (floor, seats) VALUES (2, 30);
INSERT INTO classroom (floor, seats) VALUES (3, 30);

SELECT * FROM classroom;

INSERT INTO class VALUES ('KR1', '국어', 3, '2010010101');
INSERT INTO class VALUES ('KR2', '국어', 1, '2010010103');
INSERT INTO class VALUES ('MT1', '수학', 2, '2010010102');
INSERT INTO class VALUES ('MT2', '수학', 1, '2010010103');
INSERT INTO class VALUES ('EN1', '영어', 2, '2010010101');
INSERT INTO class VALUES ('EN2', '영어', 3, '2010010102');

SELECT * FROM class;

INSERT INTO class_regist VALUES (25001, 'KR1', 100);
INSERT INTO class_regist VALUES (25001, 'MT2', 50);
INSERT INTO class_regist VALUES (25001, 'EN1', 70);
INSERT INTO class_regist VALUES (25002, 'KR2', 80);
INSERT INTO class_regist VALUES (25002, 'MT1', 100);
INSERT INTO class_regist VALUES (25002, 'EN2', 100);
INSERT INTO class_regist VALUES (25003, 'KR2', 40);
INSERT INTO class_regist VALUES (25003, 'MT2', 80);
INSERT INTO class_regist VALUES (25003, 'EN2', 65);
INSERT INTO class_regist VALUES (25004, 'KR1', 70);
INSERT INTO class_regist VALUES (25004, 'MT1', 80);
INSERT INTO class_regist VALUES (25004, 'EN1', 40);
INSERT INTO class_regist VALUES (25005, 'KR1', 100);
INSERT INTO class_regist VALUES (25005, 'MT1', 80);
INSERT INTO class_regist VALUES (25005, 'EN2', 60);
INSERT INTO class_regist VALUES (25006, 'KR2', 60);
INSERT INTO class_regist VALUES (25006, 'MT1', 80);
INSERT INTO class_regist VALUES (25006, 'EN1', 100);
INSERT INTO class_regist VALUES (25007, 'KR2', 75);
INSERT INTO class_regist VALUES (25007, 'MT2', 95);
INSERT INTO class_regist VALUES (25007, 'EN1', 75);
INSERT INTO class_regist VALUES (25008, 'KR1', 95);
INSERT INTO class_regist VALUES (25008, 'MT2', 75);
INSERT INTO class_regist VALUES (25008, 'EN2', 95);
INSERT INTO class_regist VALUES (25009, 'KR1', 100);
INSERT INTO class_regist VALUES (25009, 'MT1', 100);
INSERT INTO class_regist VALUES (25009, 'EN1', 100);
INSERT INTO class_regist VALUES (25010, 'KR2', 70);
INSERT INTO class_regist VALUES (25010, 'MT2', 70);
INSERT INTO class_regist VALUES (25010, 'EN2', 80);

SELECT * FROM class_regist;


-- 1. 수업의 수업코드, 수업이름, 담당교사 이름, 담당교사 직급을 조회하는 쿼리문
SELECT c.class_code '수업 코드', c.name '수업 이름', t.name '담당 교사', t.position '교사 직급'
FROM class c
left outer join teacher t
on c.charge_teacher = t.teacher_number;


-- 2. MT1 수업을 수강하는 학생의 이름, 주소, 전화번호, 점수를 조회하는 쿼리문
SELECT S.name, S.address, S.tel_number, R.score
FROM student S
LEFT OUTER JOIN 
	(SELECT score, student_number
    FROM class_regist
    where class_code = 'MT1') R
ON R.student_number = S.student_number;

-- 3. 부산진구에 거주하고 있는 교사가 강의중인 수업의 수업코드와 수업 이름을 조회하는 쿼리문
SELECT class_code, name
FROM class
WHERE charge_teacher IN
	(SELECT teacher_number
    FROM teacher
	WHERE address LIKE '%부산진구%');

-- 4. 수업 코드별 (GROUP BY) 점수의 평균, 최대, 최소 값을 구하는 쿼리문(AVG, MAX, MIN)
SELECT class_code, AVG(score) '평균', MAX(score) '최대', MIN(score) '최소'
FROM class_regist GROUP BY class_code;

-- 5. 수업의 평균 점수가 80점 이상인 수업의 수업이름과 담당 교사의 이름을 조회하는 쿼리문

SELECT C.name, T.name
FROM class C LEFT JOIN teacher T
ON C.charge_teacher = T.teacher_number
WHERE C.class_code IN (
	SELECT Sub.class_code
	FROM 
		(SELECT class_code, AVG(score) 'avg'
		FROM class_regist
		GROUP BY class_code
		HAVING avg >= 80) Sub);
    
-- 6. 수업의 수업코드, 수업이름, 담당교사 이름, 담당교사 직급, 최저 점수, 최대 점수를 조회하는 쿼리문
-- class - class_code -> class_regist.MIN,MAX(score) GROUP BY class_code, charge_teacher -> teacher.name, teacher.position , 

 SELECT 
	C.class_code '수업 코드',
    C.name '수업 이름',
    T.name '담당교사 이름',
    T.position '담당교사 직급',
    SUB.min '최저 점수',
    SUB.max '최대 점수'
 FROM class C 
 LEFT JOIN teacher T ON C.charge_teacher = T.teacher_number
LEFT JOIN(SELECT MIN(score) 'min', MAX(score)'max', class_code
		 FROM class_regist
		 GROUP BY class_code) SUB
	ON C.class_code = SUB.class_code;

-- 7. 전과목 평균 점수가 90점 이상인 학생이 수강중인 교실의 층 및 좌석수를 구하는 쿼리문
-- classroom - class(classroomnumber) - class_regist (classcode)(avg) - student(student_number)
SELECT 
    floor '층',
    seats '좌석 수'
FROM classroom
WHERE classroom_number IN (
    SELECT DISTINCT classroom
    FROM class
    WHERE class_code IN (
        SELECT DISTINCT class_code
        FROM class_regist
        WHERE student_number IN (
            SELECT student_number
            FROM (SELECT 
                    student_number,
                    AVG(score) 'avg'
                FROM class_regist
                GROUP BY student_number
                HAVING avg >= 90
                ) SUB
            )
    )
);
-- 		SELECT CRT.class_code DISTINCT class_code
-- 		FROM class_regist CRT
-- 		LEFT JOIN 
-- 			(SELECT student_number, AVG(score) avg
-- 			FROM class_regist
-- 			GROUP BY student_number
-- 			HAVING avg >= 90) SUB
-- 		ON CRT.student_number = SUB.student_number
-- 		GROUP BY class_code
-- 		) SUB2



-- 7. 전과목 평균 점수가 90점 이상인 학생이 수강중인 교실의 층 및 좌석수를 구하는 쿼리문





















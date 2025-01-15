CREATE DATABASE school;

use school;

CREATE TABLE student(				-- 테이블 명은 무조건 단수 형태로
	student_numbers varchar(5),		-- 분류를 위한 코드로 보기 때문에 varchar
    name VARCHAR(15),				-- 1글자에 3byte 정도 잡기 때문에 5글자로 가정하면 15
    address text,			-- text여도 상관없음.
    telnumber varchar(13)			
);
									-- 테이블명은 겹칠 수 없으나 칼럼은 테이블이 다르면 상관없음
CREATE TABLE class(
	class_code varchar(3),
    name varchar(25),
    classroom int,					-- 다른 테이블의 코드로 연결
    charged_teacher varchar(10)		-- 다른 테이블의 코드로 연결
);

CREATE TABLE class_room(
	class_room_number int,
    floor int,
    seats int
);

CREATE TABLE teachers(
	teacher_number varchar(10),
    name varchar(15),
    address text,
    teacher_phone varchar(13),
    position varchar(25)
);

create user 'school_developer'@'%' IDENTIFIED BY 'school123';
create user 'school_developer'@'localhost' IDENTIFIED BY 'school123';
package com.korit.spring_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.korit.spring_basic.dto.Lombok;

@SpringBootApplication
public class SpringBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBasicApplication.class, args);
	}

	void method(){
		Lombok lombok = new Lombok("a", 1, false, true);
		Lombok lombok2 = new Lombok("a", 1);

		lombok.getField1();
		lombok.getField2();
		lombok.isField3(); // 기본형 boolean은 get이 아닌 is 사용 
		lombok.getField4();

		lombok2.setField3(false);
		lombok2.setField4(null);
		};
	}




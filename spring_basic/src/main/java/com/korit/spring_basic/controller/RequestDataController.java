package com.korit.spring_basic.controller;

import org.hibernate.validator.internal.metadata.facets.Validatable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korit.spring_basic.dto.Validation;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
// http://127.0.0.1:8080/request-data/**
@RequestMapping("/request-data")
public class RequestDataController {
  
  // @RequestParam(): Query String Parameter로 매개변수를 받는 방법
  // Query String Parameter - URL에 쿼리를 추가하여 데이터를 전송하는 방법 (/path?name=value&name=value)

  // GET http://127.0.0.1:8080/request-data/request-param
  @GetMapping("/request-param")
  public String requestParam(
    @RequestParam("name") String name,
    @RequestParam(name="age", required=false) Integer age
  ) {
    return "이름 : " + name + ", 나이 : " + age;
  }

  // @PathVariable() : request의 url 패턴에 따라 데이터를 추출하는 방법
  // GET http://127.0.0.1:8080/request-data/path-variable
  // 만약 PathVariable로 받아오는 매개변수가 선택적이라면 Path를 여러개 지정해야 함
  // @GetMapping("/path-variable/{name}/{ho}")
  @GetMapping({// 문자열 배열로도 사용 가능
    "/path-variable/{name}/{ho}",
    "/path-variable/{name}/",
    "/path-variable/{name}"
  })
  public String pathVariable(
    @PathVariable("name") String name,    // 최신 버전은 매개변수와 주소변수의 이름이 같으면 안해도 되지만, 구버전은 작성해주어야 함
    @PathVariable(name="ho", required=false) String ho
  ){
    return "이름 : " + name + ", 묘호 : " + ho;
  }
  
  // path variable을 이용한 방법은 다른 메서드의 url 패턴과 겹칠 수 있음에 유의할 것
  // /path-variable/{data}/other X
  // /path-variable/other/{data} X
@GetMapping("/{variable}") // 주소 겹치면 bad request:400
public String sample(
  @PathVariable("variable") String variable
  ){
    return variable;
  }

  


  //@RequestBody() : POST, PUT, PATCH에서 Request Body로 전송한 데이터를 메서드에서 매개변수로 받기위한 방법
  @PostMapping("/request-body")
  public String requestBody(
    @RequestBody() RequestBodyDto requestBody
  ) {   
    // return requestBody.getName();
      return "이름 : " + requestBody.getName() + ", 나이 : " + requestBody.getAge();
  }

  @PostMapping("/validation")
  public String validation(@RequestBody @Valid Validation requestBody) {
      return requestBody.toString();
  }

}

// DTO(Data Transfer Object)
  // - 데이터를 서로 다른 계층간에 전송하기 위한 객체
  // - 캡슐화가 되어 있음, 비즈니스 로직은 포함하지 않음
  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  class RequestBodyDto {
    private String name;
    private Integer age;    
}

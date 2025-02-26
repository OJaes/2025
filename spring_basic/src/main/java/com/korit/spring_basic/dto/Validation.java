package com.korit.spring_basic.dto;
// client request body 데이터 유효성 검사
// - sptring-boot-starter-validation 의존성 사용
// - 스프링 프레임워크에서 제공하는 유효성 검사 인터페이스 라이브러리
// - 클라이언트가 서버로 데이터를 전송할 때 유효한 데이터일 때만 서버에 데이터를 전송할 수 있도록 도움을 줌

import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Validation {
    // @NotNull : null을 허용하지 않음
    @NotNull
    private String notNull;

    // 기본형 데이터 타입은 @NotNull 필수 지정 못함
    // Wrapper 타입으로 지정해줘야 함
    @NotNull
    private Integer intNotNull;

    // @NotEmpty : "문자열"에서 null, 빈 문자열 허용 x
    @NotEmpty
    private String notEmpty;

    // @NotBlank : "문자열"에서 null, 빈 문자열, 공백으로만 이루어진 공백 문자열 허용 x
    @NotBlank
    private String notBlank;

    // ! NotBlank와 NotEmpty를 문자열이 아닌 타입에서 사용하지 않도록 해야 함

    // @Length(min=?, max=?) : 문자열 타입에서 길이의 최소, 최대를 검사할수 있음
    // null에 대한 검사는 수행하지 않음
    @Length(min=3, max=8)
    @NotNull
    private String length;

    // @Size(min=?, max=?) : 배열 타입에서 배열의 최소 크기, 최대 크기 검사사
    @Size(min=3, max=8)
    private List<Integer> size;

    // @Min(), @Max() : 정수의 최소 최대를 검사할 수 있음
    @Min(1)
    @Max(15)
    private Integer minMax;

    // @Range(minx=?, max=?) : 정수의 최대 최소값 검사
    @Range(min=5, max=15)
    private Integer range;

    //@Pattern(regexp = 정규식) : 정규식을 이용해 문자열의 패턴 검사 
    @Pattern(regexp="^[a-zA-z]*$")
    private String pattern;
}
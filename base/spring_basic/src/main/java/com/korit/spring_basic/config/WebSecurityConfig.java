package com.korit.spring_basic.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.korit.spring_basic.filter.JwtAuthenticationFilter;
import com.korit.spring_basic.handler.OAuth2SuccessHandler;
import com.korit.spring_basic.service.implement.OAuth2UserServiceImplement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

// Spring Web 보안 설정
//@Configurable :
// - Spring Bean으로 등록되지 않은 클래스에서 @Autowired를 사용할 수 있도록 하는 어노테이션션
@Configurable
// @Configuration
// '메서드'가 호출 시에 Spring Bean으로 등록되게 할 수 있는 어노테이션
@Configuration
// @EnableWebSecurity:
// - Spring Web Security와 관련된 설정을 지원하는 어노테이션
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final OAuth2UserServiceImplement oAuth2UserService;
    private final OAuth2SuccessHandler auth2SuccessHandler;

    // Web Security 설정을 지정하는 메서드
    // @Bean :
    // @Component를 사용하지 못하거나 사용하고 싶지 않을 때 Spring bean으로 등록할 수 있도록 하는 어노테이션(클래스가 아닌 메서드 등록록)
    // WebSecurityConfig 클래스의 인스턴스 생성을 Spring에게 넘기지 않고 configure 메서드 호출만 Spring에게 넘기는 것   
    @Bean
    public SecurityFilterChain configure(HttpSecurity security) throws Exception{


        // Class::method
        // 메서드 참조, 특정 클래스의 메서드를 참조할 때 사용
        // - 매개변수로 메서드를 전달하고자 할 때 자주 사용
        security
        // Basic 인증 방식에 대한 설정
        // Basic 인증 방식 미사용으로 지정
        .httpBasic(HttpBasicConfigurer::disable)
        // Session
        // 웹 애플리케이션에서 클라이언트에 대한 정보를 유지하기 위한 기술
        // 서버 측에서 클라이언트에 대한 정보를 유지하는 방법
        // REST API 서버에서는 Session을 유지하지 않음

        // Session 유지 방식에 대한 설정
        // Session 유지를 하지 않는 설정
        .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

        // CSRF( cross-site req Forgery)
        // - 클라이언트가 자신의 의도와 무관하게 공격행위를 하는 것
        // - 흔히 공격자가 정당한 클라이언트의 세션을 탈취하여 공격을 수행함

        // csrf 취약점애 대한 대비 설정
        // csrf 취약점에 대한 대비를 하지 않겠다고 가정
        .csrf(CsrfConfigurer::disable)

        // CORS 정책 설정
        .cors(cors -> cors.configurationSource(configurationSource()))
        
        // 인가 작업
        // 특정 자원에 대해 접근 주체가 권한이 있는지 판단
        // - 요청 URL의 패턴(자원)에 따라 인가가 필요한 직업인지 지정하는 설정( 자원에 대한 권한 지정 )
        // - 모든 클라이언트가 접근할 수 있도록 허용
        // - 인증된 모든 클라이언트가 접근할 수 있도록 허용
        // - 인증된 클라이언트 중 특정 권한을 가진 클라이언트만 접근할 수 있도록 허용
        .authorizeHttpRequests(request -> request
        // requestMatchers() : URL 패턴, HTTP 메서드, URL 패턴 + HTTP 메서드마다 접근 권한을 부여하는 메서드
        // permitAll(): 모든 클라이언트가 접근할 수 있도록 지정
        // authenticated() : 인증된 모든 클라이언트가 접근할 수 있도록 지정
        // hasRole(권한) : 권한을 가진 클라이언트만 접근할 수 있도록 지정(매개변수로 전달하는 권한명은 ROLE_를 제외한 실제 권한명)
        .requestMatchers("/basic", "/basic/**", "/security", "/security/**", "/oauth2/**").permitAll() //url 패턴
        .requestMatchers(HttpMethod.PATCH).authenticated() // http 메서드
        .requestMatchers(HttpMethod.POST, "/user", "/user/**").hasRole("USER")
        // anyRequest(): 나머지 모든 요청에 대한 처리
        )
        //oauth2 인증 처리
        .oauth2Login(oauth2 -> oauth2
        // 사용자가 oauth2 인증을 위한 요청 URL 지정
            .authorizationEndpoint(endPoint -> endPoint.baseUri("/security/sns"))
            // http://localhost:8080/security/sns/github

            // OAUTH2 인증 완료 후 인증 서버에서 들어오는 URL 지정정
            .redirectionEndpoint(endPoint -> endPoint.baseUri("/oauth2/callback/*"))
            // OAUTH2 인증 완료 후 사용자 정보를 처리할 서비스 지정
            .userInfoEndpoint(endPoint -> endPoint.userService(oAuth2UserService))
            // OAUTH2 서비스 처리 후 성공시 실행할 기능능
            .successHandler(auth2SuccessHandler))
        // http://localhost:8080/oauth2/authrization/github
        //!
        // 인증 및 인가 과정에서 발생한 예외를 직접 처리
        .exceptionHandling(exception -> exception.authenticationEntryPoint(new FailedAuthenticationEntryPoint()))


        // 필터 등록
        // addFilterBefore(추가할 필터 인스턴스, 특정 필터 클래스): 특정 필터 이전에 지정한 필터를 등록
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        //설정 완료
        return security.build();
    }

    @Bean
    protected CorsConfigurationSource configurationSource(){
        CorsConfiguration configuration = new CorsConfiguration();
        // 출처 지정
        configuration.addAllowedOrigin("*");
        // HTTP 메서드 지정
        configuration.addAllowedMethod("*");
        // HTTP Request Header 지정
        configuration.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

//!
// 인증 및 인가 실패 처리를 위한 커스텀 예외 (AuthenticationEntryPoint 인터페이스 구현)
class FailedAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        
            authException.printStackTrace();
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("{\"message\": \" 인증 및 인가에 실패했습니다.\"}");

    }


}
package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
/*
@ComponentScan은 @Component가 붙은 모든 클래스를 스프링 빈으로 등록한다.
이떄 스프링 빈의 기본 이르은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다.
@Component("명명") 이런식으로 이름을 따로 부여할 수 있다.
@Component를 자동으로 다 찾음

 */
@ComponentScan(
        // 탐색 package 지정
        // basePackages = "hello.core.member",
        // 지정하지 않으면, AutoAppConfig(@ComponentScan) 하위 패키지를 다 확인하게 된다. 클래스 위치로 지정하는것이 관례, basePackages는 생략함.
        // 예제에서 AppConfig 파일 제외하기 위함.
        /*
        사실 애노테이션에는 상속관계라는 것이 업다. 애노테이션이 특정 애노테이션이 들고 있는 것을 인식할 수 있는건 자바 기능이 아니라 스프링 기능이다.
        @Component
        @Controller
        @Service
        @Repository
        @Configuration
         */
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)


)
/*
AutoAppConfig 동작시
AutoAppConfig 클래스를 기준으로 하위 패키지에 대해서 컴포넌트 스캔이 일어나게 되는데,
FixDiscountPolicy, RateDiscountPolicy  2개에 모두 @Component를 달아준 상황이다.
따라서 
NoUniqueBeanDefinitionException
가 발생한다. 해결방법으로 총 3가지가 있다.

@Autowired 필드명 매칭
-> @Autowired매칭 규칙 정리
   1. 타입 매칭
   2. 타입 매칭의 결과가 2개 이상일때는 필드명, 파라미터 명으로 빈 이름 매칭

@Qualifier
 추가 구분자를 붙여주는 방법


@Primary 사용

우선 순위: quilifier가 primary보다 우선순위가 높다. -> 기본적으로 spring은 자동보다 수동이 우선순위가 더 높다.
 */
public class AutoAppConfig {
}

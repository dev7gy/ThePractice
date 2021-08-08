package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext; // close 함수를 제공하지 않음.
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
/*
스프링 빈의 이벤트 라이프사이클
스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 주입 -> 초기화 콜백 사용 -> 소멸전 콜백 -> 스프링 종료
초기화 콜백: 빈이 생성되고, 빈의 의존관계 주입이 완료된 후 호출
소멸전 콜백: 빈이 소멸되기 직전에 호출

# 객체의 생성과 초기화를 분리하자
# 싱글톤 빈들은 스프링 컨테이너가 종료될 때 싱글톤 빈들도 함꼐 종료되기 때문에 스프링 컨테이너가 종료되기 직전에 소멸전 콜백이 일어난다.
 */

public class BeanLIfeCycleTest {
    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    // AutoCloseable 인터페이스 공부해보면 좋음.
    @Configuration
    static class LifeCycleConfig {
        // @PostConstruct - @PreDestroy를 사용하는 것을 권장 - 하지만, 단점은 외부라이브러리에 적용하기 어렵다.
        @Bean //(initMethod = "init", destroyMethod = "close") //@Bean(initMethod = "init", destroyMethod = "") 여도 추론 기능을 통해 될거다.
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}

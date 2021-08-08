package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean(
                "memberService", MemberService.class);

        // on demand static
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);

        // on demand static
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    // 구현된 타입으로 조회하는건 좋지 않음. 역할과 구현 중에서 역할에 의존해야하기 때문에
    @Test
    @DisplayName("구현된 타입으로 조회")
    void findBeanByInstanceType() {
        MemberService memberService = ac.getBean(MemberServiceImpl.class);

        // on demand static
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("타입이 없을때")
    void findBeanByNameX() {
//      ac.getBean("xxxx", MemberService.class);
//        MemberService xxxx = ac.getBean("xxxx", MemberServiceImpl.class);

        // on demand static
        org.junit.jupiter.api.Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }
}
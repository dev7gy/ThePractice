package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption () {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        /* Member 는 스프링빈으로 등록되어져 있는것이 아니기 때문에 오류가 난다.
        @Autowired(required = true)
        public void defaultTrue(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }
        */

        @Autowired(required = false) // false에다가 Member가 스프링 객체가 아니면 아예 함수가 호출이 안된다.
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired(required = false)
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean1 = " + noBean3);
        }
    }
}

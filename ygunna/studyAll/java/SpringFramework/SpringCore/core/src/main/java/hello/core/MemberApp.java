package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * [회원]
 * 회원을 가입하고 조회할 수 있다.
 * 회원은 일반과 VIP 두 가지 등급이 있다.
 * 회원 데이터는 자체 DB를 구축할 수 있고
 * , 외부 시스템과 연동할 수 있다. (미확정)
 */
public class MemberApp {
    public static void main(String[] args) {
        /** Spring 적용하면서 주석처리
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        */

        // ApplicationContext 는 SpringContainer
        // 스프링 컨테이너는 싱글톤 레지스트리
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        /**
         기본적으로 이름이 메소드 이름으로 등록됨.
         @Bean
         public MemberService memberService()

         등록된 bean 을 가져옴.
         12:35:58.409 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'appConfig'
         12:35:58.418 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'memberService'
         12:35:58.452 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'memberRepository'
         12:35:58.455 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'orderService'
         12:35:58.457 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'discountPolicy'
         */
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        /*
         JAVA 코드로만 작성한 프로그램.
          - 회원 도메인 설계의 문제점.
           > 이 코드의 설계상 문제점은 무엇일까요?
           > 다른 저장소를 변경할때 OCP원칙을 잘 준수할까요?
           > DIP를 잘 지키고 있을까요?
         */
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember((1L));

        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }
}

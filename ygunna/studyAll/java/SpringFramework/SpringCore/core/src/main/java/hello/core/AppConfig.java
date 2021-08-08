package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 구성(tjfwjd) 영역 -- Application 의 공연 기획자 -->사용영역 코드는 건드릴 필요가 없다.
/*
singleton을 위해 존재. 이 코드에서 분명 memberRepository()가 눈에 보이는 것만 해도 2번 호출된다. 그러면 singleton이 깨지지 않을까?
왜 아래처럼 memberRepository가 한번만 호출될까..?
CALL AppConfig.memberService
CALL AppConfig.memberRepository
CALL  AppConfig.orderService
 */
/*
@Configuration 을 달아주지 않으면, memberRepository()은 자바 코드 그대로 3번 호출되어 싱글톤을 유지하지 않는다.
 */
@Configuration
public class AppConfig {
    /**
     * public 역할() {
     *  return 구현  구현부분만 이후에 바꾸면 됨.
     * }
     */
    @Bean(name="memberService")
    public MemberService memberService() {
        System.out.println("CALL AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("CALL AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("CALL  AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * [주문과 할인 정책]
 * 회원은 상품을 주문할 수 있다.
 * 회원 등급에 따라 할인 정책을 적용할 수 있다.
 * 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라.
 * (나중에 변경 될 수 있다.)
 * 할인 정책은 변경 가능성이 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을
 * 미루고 싶다. 최악의 경우 할인을 적용하지 않을 수 도 있다. (미확정)
 */
public class OrderApp {
    public static void main(String[] args) {
        /** Spring 적용하면서 주석처리
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService(); //new MemberServiceImpl();
        OrderService orderService = appConfig.orderService(); //new OrderServiceImpl();
        */
        // ApplicationContext 는 SpringContainer
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        // ctrl + alt + v
        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}

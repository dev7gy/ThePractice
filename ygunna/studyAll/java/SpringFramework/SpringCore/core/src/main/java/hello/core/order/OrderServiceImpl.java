package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    // 생성자 주입을 사용하면 final을 사용해서 컴파일 시점에 막아줄 수 있다. -> 컴파일 오류가 가장 좋은 방식
    private final MemberRepository memberRepository; // = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    /**
     * DIP 적용을 위해 구현 객체를 여기서 만들지 않음.
     */
    private final DiscountPolicy discountPolicy; //= new RateDiscountPolicy();

    /*
    생성자에 @Autowired를 지정하면 스프링 컨테이너가 자동으로 스프링 빈을 찾아서 주입한다.
    이때 기본 조회 전략은 타입이 같은 빈을 찾아서 주입한다.
    geteBean(MemberRepository.class)와 동일하다.
     */

    /* Lombok @RequiredArgsConstuctor 을 통해서 생성자를 작성하지 않음. ctrl + f12로 함수 진짜로 생성되었는지 확인
    */
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // @Configuration 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

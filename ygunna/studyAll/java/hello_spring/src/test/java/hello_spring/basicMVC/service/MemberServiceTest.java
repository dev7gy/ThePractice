package hello_spring.basicMVC.service;

import hello_spring.basicMVC.domain.Member;
import hello_spring.basicMVC.repository.MemMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    /**
     * MemverService나 여기서
     * NEW한거나 굳이 다른 객체로 사용할 필요가 있나?
     */
    MemberService memberService;
    MemMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        /**
         * MemberService 입장에서 MemberRepository 를 직접 생성하지 않고 주입받는다.
         * DI 의존성 주입.
         */
        memberRepository = new MemMemberRepository();
        // 외부에서 넣어주게 바꿔야함.
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
/*
        try {
            memberService.join(member2);
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
 */

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
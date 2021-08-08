package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;// = new MemoryMemberRepository();
    // 의존관계가 인터페이스뿐만 아니라 구현까찌 모두 의존하는 문제점이 있음
    
    // 생성자를 통한 주입
    @Autowired //ac.getBean(MemberRepository.class) 랑 유사한 어노테이션
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findByID(memberId);
    }

    // @Configuration 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

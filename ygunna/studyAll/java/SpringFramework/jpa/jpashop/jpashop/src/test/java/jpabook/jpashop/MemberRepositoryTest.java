package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

// @RunWith -> 나 스프링과 관련된걸 테스트할거야
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    /*
    error: No EntityManager with actual transaction available for current thread
    중요! entity manager를 통한 변경은 모두 transaction 안에서 이루어져야 한다!
     */
    @Test
    @Transactional // test에서는 transactional 끝나고 rollback을 한다.
    @Rollback(false)
    public void testMember() throws  Exception {
        // given
        Member member = new Member();
        member.setUsername("memberA");

        // when
        // extract 변수 저장 단축키: ctrl + alt + v
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

        /*
         같은 transaction 안에서 저장하고 조회한다면 영속성 컨텍스트가 같다.
         같은 영속성 컨텍스트 안에서는 id값이 같으면 같은 엔티티로 식별한다.
         같은 영속성 컨텍스트에서는 식별자가 같으면 같은 엔티티로 인식한다. - 1차 캐시에서 가져온 것.
         */
        Assertions.assertThat(findMember).isEqualTo(member);
        System.out.println("findMember == member: " + (findMember == member));
    }
}
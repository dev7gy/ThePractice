package hello_spring.basicMVC.repository;

import hello_spring.basicMVC.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemMemberRepositoryTest {
    MemMemberRepository repository = new MemMemberRepository();

    /*
    테스트는 순서가 보장되지 않음.
    그래서 다른 테스트가 영향을 줄 수 있음
    그래서 테스트 돌리면서 들어간 데이터를 Clear 해줘야함.

    테스트는 의존관계가 없어야함.
     */
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member1);

        Member result = repository.findByName(member1.getName()).get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member1);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}

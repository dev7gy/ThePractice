package hello_spring.basicMVC.repository;

import hello_spring.basicMVC.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    // JPA를 사용하려면 Entity Manager를 주입받아야함.
    private  final EntityManager entityManager;

    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Member save(Member member) {
        entityManager.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    // pk로 검색안하려면, jpql이 피ㄹ요.
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = entityManager.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // jpql 객체를 대상으로 쿼리 날리기
        List<Member> result = entityManager.createQuery("select m from Member m", Member.class)
                .getResultList();
        return result;
    }
}

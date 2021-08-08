package jpabook.jpashop;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// TEST 코드 만드는 단축키: Shift + Ctrl + T
// Repository -> Entity 같은걸 찾아주는 역할, DAO와 유사...
@Repository
public class MemberRepository {

    // jpa를 쓰기 때문에 Entity 매니저가 필요함.
    // springboot가 주입을 해주게 되어있음.
    @PersistenceContext
    EntityManager em;

    // 왜 멤버를 반환하지 않을까? ID만 반환한다. 커맨드랑 쿼리를 분리해라
    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}

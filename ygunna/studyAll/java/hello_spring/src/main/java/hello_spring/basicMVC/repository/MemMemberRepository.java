package hello_spring.basicMVC.repository;

import hello_spring.basicMVC.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        for (Member member: store.values()) {
            if ( member.getName().equals(name) ) {
                return Optional.ofNullable(member);
            }
        }
        return Optional.ofNullable(null);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}

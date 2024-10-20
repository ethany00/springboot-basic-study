package spring.spring_basic_study.repository;

import spring.spring_basic_study.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepositoy{

    private static Map<Long , Member> store = new HashMap<>();
    private static long sequnce = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequnce);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}

package spring.spring_basic_study.repository;

import jakarta.persistence.EntityManager;
import spring.spring_basic_study.domain.Member;

import java.util.List;
import java.util.Optional;

public class JpaMemberrepository implements MemberRepositoy{

    // jpa를 사용하려면 주입받아야함
    private final EntityManager em;

    public JpaMemberrepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(em.find(Member.class, id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name",Member.class).setParameter("name",name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

}

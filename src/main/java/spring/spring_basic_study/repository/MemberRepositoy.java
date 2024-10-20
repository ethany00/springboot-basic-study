package spring.spring_basic_study.repository;

import spring.spring_basic_study.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepositoy {

    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}

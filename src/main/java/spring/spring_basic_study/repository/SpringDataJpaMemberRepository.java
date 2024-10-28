package spring.spring_basic_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.spring_basic_study.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepositoy {
    @Override
    Optional<Member> findByName(String name);

}

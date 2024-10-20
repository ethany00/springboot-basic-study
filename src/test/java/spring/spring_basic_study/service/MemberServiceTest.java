package spring.spring_basic_study.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.spring_basic_study.domain.Member;
import spring.spring_basic_study.repository.MemoryMemberRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach(){
        // 실행 전 주입
        // DI
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach(){
        // 매서드 단위 테스트가 끝날 때 콜백
        // 전부 clear
        memoryMemberRepository.clearStore();
    }
    

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);


        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    void duplicatedMember(){
        // given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        // when

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("존재 회원");

        /*try {
            memberService.join(member2);

            fail();
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("존재 회원");
        }*/


        // then


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
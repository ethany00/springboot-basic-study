package spring.spring_basic_study.service;

import spring.spring_basic_study.domain.Member;
import spring.spring_basic_study.repository.MemberRepositoy;
import spring.spring_basic_study.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemoryMemberRepository memoryMemberRepository;

    public MemberService(MemoryMemberRepository memoryMemberRepository) {
        // DI 외부에서 객체를 생성해서 직접 주입
        this.memoryMemberRepository = memoryMemberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member){
        // 중복 이름 회원
        vaildateDuplicatedMember(member);
        memoryMemberRepository.save(member);
        return member.getId();
    }

    private void vaildateDuplicatedMember(Member member) {
        memoryMemberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("존재 회원");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memoryMemberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memoryMemberRepository.findById(memberId);
    }

}

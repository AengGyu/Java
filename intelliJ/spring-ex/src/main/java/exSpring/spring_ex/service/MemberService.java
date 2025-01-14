package exSpring.spring_ex.service;

import exSpring.spring_ex.domain.Member;
import exSpring.spring_ex.repository.MemberRepository;
import exSpring.spring_ex.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 회원 서비스 코드를 DI(의존성 주입)이 가능하게 변경
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

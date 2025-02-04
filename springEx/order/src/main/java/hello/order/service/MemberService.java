package hello.order.service;

import hello.order.domain.Member;
import hello.order.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(Member member){
        memberRepository.save(member);
    }

    public Member findMember(Long id){
        return memberRepository.findById(id);
    }

    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }
}

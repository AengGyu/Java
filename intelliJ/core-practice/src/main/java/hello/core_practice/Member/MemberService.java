package hello.core_practice.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}

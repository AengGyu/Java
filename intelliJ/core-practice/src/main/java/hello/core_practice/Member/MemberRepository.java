package hello.core_practice.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}

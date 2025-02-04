package hello.order.repository;

import hello.order.domain.Member;

import java.util.List;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long id);
    List<Member> findAll();
}

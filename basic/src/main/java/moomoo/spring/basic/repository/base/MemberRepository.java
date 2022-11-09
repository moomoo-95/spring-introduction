package moomoo.spring.basic.repository.base;

import moomoo.spring.basic.member.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}

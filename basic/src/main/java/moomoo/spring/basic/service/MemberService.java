package moomoo.spring.basic.service;

import moomoo.spring.basic.member.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
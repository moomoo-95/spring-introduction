package moomoo.spring.basic.repository;

import moomoo.spring.basic.member.Member;
import moomoo.spring.basic.repository.base.MemberRepository;

public class DbMemberRepository implements MemberRepository {
    @Override
    public void save(Member member) {

    }

    @Override
    public Member findById(Long memberId) {
        return null;
    }
}

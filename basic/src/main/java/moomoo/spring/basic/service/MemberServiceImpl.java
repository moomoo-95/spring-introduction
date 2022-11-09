package moomoo.spring.basic.service;

import moomoo.spring.basic.member.Member;
import moomoo.spring.basic.repository.MemoryMemberRepository;
import moomoo.spring.basic.repository.base.MemberRepository;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

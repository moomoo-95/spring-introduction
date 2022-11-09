package moomoo.spring.introduction.service;

import moomoo.spring.introduction.domain.Member;
import moomoo.spring.introduction.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public String join(String name) {
        // 이름 중복 불가
        validateMember(name);

        Member member = new Member(UUID.randomUUID().toString(), name);
        return memberRepository.save(member).getId();
    }

    private void validateMember(String name) {
        memberRepository.findByName(name)
                .ifPresent(member -> {
                    throw new IllegalStateException(name + " is already name.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMember(String memberId) {
        return memberRepository.findById(memberId);
    }

    public Optional<Member> findMemberByName(String memberName) {
        return memberRepository.findByName(memberName);
    }
}

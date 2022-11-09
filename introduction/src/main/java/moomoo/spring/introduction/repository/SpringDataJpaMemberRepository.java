package moomoo.spring.introduction.repository;

import moomoo.spring.introduction.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, String>, MemberRepository {
}

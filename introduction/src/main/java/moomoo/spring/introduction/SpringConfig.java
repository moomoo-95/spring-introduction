package moomoo.spring.introduction;

import moomoo.spring.introduction.aop.TimeTraceAop;
import moomoo.spring.introduction.repository.MemberRepository;
import moomoo.spring.introduction.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    //    private final DataSource dataSource;
    //    private final EntityManager em;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //    public SpringConfig(DataSource dataSource, EntityManager em) {
    //        this.dataSource = dataSource;
    //        this.em = em;
    //    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    //    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
//
    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
}

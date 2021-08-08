package hello_spring.basicMVC;

import hello_spring.basicMVC.aop.TimeTraceAop;
import hello_spring.basicMVC.repository.*;
import hello_spring.basicMVC.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.swing.*;

@Configuration
public class SpringConfig {
    /* JPA 사용시 필요 없음.
    private DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
     */

    /* Spring Data JPA 사용시 필요없음.
    @Autowired
    private EntityManager entityManager;
    public  SpringConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

     */

    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        //return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

    /* Spring Data JPA 사용시 필요없음.
    @Bean
    public MemberRepository memberRepository() {
        // memory DB
        //return  new MemMemberRepository();

        // jdbc DB(H2)
        //return  new JdbcMemberRepository(dataSource);

        // jdbc template
        //return  new JdbcTemplateMemberRepository(dataSource);

        // jpa
        //return new JpaMemberRepository(entityManager);
    }
     */
}

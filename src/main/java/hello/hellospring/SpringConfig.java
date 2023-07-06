package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Bean
    public MemberService memberService(){
        //return new MemberService(memberRepository());
        //MemoryService는 MemberRepository 타입 파라미터가 필요하므로
        //아래 bean으로 등록한 MemberRepository를 파라미터로 넣으면 된다.
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

//    @Bean
//    public MemberRepository memberRepository(){
//        //return new MemoryMemberRepository();
//        //아래와 같이 단순히 빈으로 등록하는 객체만 바꿔도 의존성 주입을 다르게 할 수 있고
//        //이 객체에 의존성을 가지고 있는 코드가 받는 객체도 달라지게 된다.
//        //이러한 방법을 다형성을 이용한 객체지향 개발이다.
//        //return new JdbcMemberRepository(dataSource);
//        //return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}

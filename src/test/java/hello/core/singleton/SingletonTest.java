package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 조회1
        MemberService memberService1 = appConfig.memberService();

        // 조회2
        MemberService memberService2 = appConfig.memberService();

        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 테스트")
    void singletonServiceTest() {
        SingletonService s1 = SingletonService.getInstance();
        SingletonService s2 = SingletonService.getInstance();

        assertThat(s1).isEqualTo(s2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer () {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 조회1
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        // 조회2
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        assertThat(memberService1).isSameAs(memberService2);
    }
}

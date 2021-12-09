package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        // 주입할 대상 없으면 아예 호출이 안됨
        @Autowired(required = false)
        public void setNoBean1(Member member) {

        }

        // 대상 없으면 null 반환
        @Autowired
        public void setNoBean2(@Nullable Member member) {

        }

        @Autowired
        public void setNoBean2(Optional<Member> member) {

        }
    }
}

package hello.core_practice;

import hello.core_practice.Member.MemberService;
import hello.core_practice.Member.MemberServiceImpl;
import hello.core_practice.discount.DiscountPolicy;
import hello.core_practice.discount.FixDiscountPolicy;
import hello.core_practice.discount.RateDiscountPolicy;
import hello.core_practice.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class AutoAppConfigTest {

    @Test
    void basicScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        DiscountPolicy discountPolicy = orderService.getDiscountPolicy();
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }
}
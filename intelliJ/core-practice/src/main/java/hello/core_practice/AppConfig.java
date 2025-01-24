package hello.core_practice;

import hello.core_practice.Member.MemberRepository;
import hello.core_practice.Member.MemberService;
import hello.core_practice.Member.MemberServiceImpl;
import hello.core_practice.Member.MemoryMemberRepository;
import hello.core_practice.discount.DiscountPolicy;
import hello.core_practice.discount.FixDiscountPolicy;
import hello.core_practice.discount.RateDiscountPolicy;
import hello.core_practice.order.OrderService;
import hello.core_practice.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

package hello.core_practice.discount;

import hello.core_practice.Member.Member;

public interface DiscountPolicy {

    int discount(Member member,int price);
}

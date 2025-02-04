package hello.order.discount;

import hello.order.domain.Member;
import hello.order.domain.Product;

public interface DiscountPolicy {
    int calculateDiscount(Member member, Product product);
}

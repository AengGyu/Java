package hello.order.discount;

import hello.order.domain.Grade;
import hello.order.domain.Member;
import hello.order.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class GradeDiscountPolicy implements DiscountPolicy{
    @Override
    public int calculateDiscount(Member member, Product product) {
        if(member.getGrade() == Grade.GOLD){
            return (int) (product.getPrice() * 0.10);
        } else if(member.getGrade() == Grade.SILVER){
            return (int) (product.getPrice() * 0.05);
        } else {
            return 0;
        }
    }
}

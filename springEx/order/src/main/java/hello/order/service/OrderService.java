package hello.order.service;

import hello.order.discount.DiscountPolicy;
import hello.order.domain.Member;
import hello.order.domain.Order;
import hello.order.domain.Product;
import hello.order.repository.MemberRepository;
import hello.order.repository.OrderRepository;
import hello.order.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final DiscountPolicy discountPolicy;

    public Order saveOrder(Long memberId, Long productId, int quantity) {
        Member member = memberRepository.findById(memberId);
        Product product = productRepository.findById(productId);

        int discount = discountPolicy.calculateDiscount(member, product);
        int totalPrice = product.getPrice() * quantity - discount;

        Order order = new Order(null, member, product, quantity, totalPrice);
        orderRepository.save(order);

        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}

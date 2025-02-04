package hello.order.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Order {
    private Long id;
    private Member member; // 주문한 회원
    private Product product; // 주문한 상품
    private int quantity;
    private int totalPrice;
}

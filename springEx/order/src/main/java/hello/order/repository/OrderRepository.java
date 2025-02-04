package hello.order.repository;

import hello.order.domain.Order;

import java.util.List;

public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}

package hello.order.repository;

import hello.order.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryOrderRepository implements OrderRepository {

    private final List<Order> orders = new ArrayList<>();
    private long sequence = 0L;

    @Override
    public void save(Order order) {
        order.setId(++sequence);
        orders.add(order);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }
}

package hello.order.repository;

import hello.order.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryProductRepository implements ProductRepository{

    private final Map<Long, Product> store = new HashMap<>();
    private long sequence = 0L;

    @Override
    public void save(Product product) {
        product.setId(++sequence);
        store.put(product.getId(), product);
        System.out.println("save");
    }

    @Override
    public Product findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Product> findAll() {
        System.out.println("MemoryProductRepository.findAll");
        return new ArrayList<>(store.values());
    }
}

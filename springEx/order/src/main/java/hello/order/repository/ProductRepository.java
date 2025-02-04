package hello.order.repository;

import hello.order.domain.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);
    Product findById(Long id);
    List<Product> findAll();
}

package hello.order.service;

import hello.order.domain.Product;
import hello.order.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public Product getProduct(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getAllProduct(){
        System.out.println("ProductService.getAllProduct");
        return productRepository.findAll();
    }

}

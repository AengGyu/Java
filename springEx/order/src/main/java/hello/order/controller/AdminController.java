package hello.order.controller;

import hello.order.domain.Product;
import hello.order.service.MemberService;
import hello.order.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/products")
public class AdminController {

    private final ProductService productService;

    @GetMapping("/new")
    public String createForm(){
        return "products/register";
    }

    @PostMapping("/new")
    public String create(@RequestParam String name, @RequestParam int price){
        Product product = new Product(name, price);
        productService.addProduct(product);

        return "redirect:/admin/products";
    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products/list";
    }
}
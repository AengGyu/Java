package hello.order.controller;

import hello.order.domain.Order;
import hello.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orders/new")
    public String createForm(){
        return "orders/createOrder";
    }

    @PostMapping("/orders/new")
    public String create(@RequestParam Long memberId,
                         @RequestParam Long productId,
                         @RequestParam int quantity){
        orderService.saveOrder(memberId, productId, quantity);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String list(Model model){
        model.addAttribute("orders", orderService.getAllOrders());

        return "orders/list";
    }
}

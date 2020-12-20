package my.grocery.store.controllers;

import my.grocery.store.domain.User;
import my.grocery.store.services.OrderService;
import my.grocery.store.services.UserService;
import my.grocery.store.utils.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/cart")
public class CartController {
    private Cart cart;
    private OrderService orderService;
    private UserService userService;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showCart(Model model) {
        model.addAttribute("positions", cart.getPositions());
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String addProductToCart(Model model, @PathVariable("id") Long id) {
        cart.addProductById(id);
        return "redirect:/store";
    }

    @GetMapping("/make-order")
    public String makeOrder(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        orderService.createOrderFromPositions(user, cart.getPositions());
        return "redirect:/store";
    }

}

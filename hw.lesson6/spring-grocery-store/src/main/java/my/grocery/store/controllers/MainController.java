package my.grocery.store.controllers;

import my.grocery.store.domain.Product;
import my.grocery.store.exception.EntityNotFoundException;
import my.grocery.store.services.EntityNotFoundResponse;
import my.grocery.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class MainController {

    private ProductService productService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/store")
    public String storePage(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "store";
    }

    @GetMapping("/info/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id) {
        Product selectedProduct = productService.getProductById(id);
        model.addAttribute("selectedProduct", selectedProduct);
        return "info";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/store";
    }

    @ExceptionHandler
    public ResponseEntity<EntityNotFoundResponse> handleException(EntityNotFoundException ex){
        EntityNotFoundResponse response = new EntityNotFoundResponse();
        response.setName(ex.getName());
        response.setId(ex.getId());
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}

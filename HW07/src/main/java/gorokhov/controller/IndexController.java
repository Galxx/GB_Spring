package gorokhov.controller;

import gorokhov.domain.Product;
import gorokhov.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    private final ProductServiceImpl productService;


    public IndexController(ProductServiceImpl productService) {

        this.productService = productService;
        InitData.getInstance().initialize(this.productService);
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Welcome to our shop");
        return "index";
    }

    @RequestMapping(value = "/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/catalog")
    public String catalog(Model model){
        model.addAttribute("products",productService.findAll());
        return "productList";
    }

    @PostMapping("/catalog/edit")
    public String productEdit(@RequestParam Integer productId,Model model){
        model.addAttribute("product",productService.findById(productId));
        return "editProduct";
    }

    @PostMapping("/product")
    public String addUser(Product productForm){
        productService.saveAndSet(productForm);
        return "redirect:/catalog";
    }

    @PostMapping("/catalog/filter")
    public String filter(Model model,
                         @RequestParam (required = false) Double  min,
                         @RequestParam (required = false) Double max){
        model.addAttribute("products",productService.getByPrice(min == null ? 0.0 : min, max == null ? Double.MAX_VALUE : max));
        return "productList";
    }


}

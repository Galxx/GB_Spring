package gorokhov.controller;


import gorokhov.beans.Product;
import gorokhov.service.MyProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("/shop")
public class MyProductController {

    private final MyProductService productService;

    public MyProductController(MyProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        ArrayList<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "list2";
    }

    @GetMapping("/new")
    public String getFormNewProduct(Model model){
        model.addAttribute("product", new Product());
        return "new-product2";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewProduct(Product product){
        Product savedProduct = productService.save(product);
        System.out.println(savedProduct);
        return "redirect:/shop/";
    }

    @GetMapping("/get")
    public String getFormGetProduct(Model model){
        return "get-product";
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public String getProduct(@RequestParam(required = false) int id, Model model){

          Product product = productService.getProduct(id);
          model.addAttribute("product", product);
          return "product2";
    }

}



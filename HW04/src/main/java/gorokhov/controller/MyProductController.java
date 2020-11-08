package gorokhov.controller;


import gorokhov.domain.Product;
//import gorokhov.service.MyProductService;
import gorokhov.service.ProductServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/shop")
public class MyProductController {

    private final ProductServiceImpl productService;

    private int sizePage;
    private int maxPage;
    private int courentPage;

    public MyProductController(ProductServiceImpl productService) {
        this.productService = productService;

        InitData.getInstance().initialize(this.productService);

        sizePage = 4;
        courentPage = 0;
        long count = productService.count();

        if(count%sizePage > 0){
            maxPage = (int) (count/sizePage);
        }else{
            maxPage = (int) (count/sizePage-1);
        }

    }

    // http://localhost:8080/app/shop/show?min=13.43&max=23.23
    @GetMapping("/show")
    public String productsByPrice(Model model,
                                  @RequestParam (required = false) Double  min,
                                  @RequestParam (required = false) Double max){
        List<Product> products = productService.getByPrice(min == null ? 0.0 : min, max == null ? Double.MAX_VALUE : max);
        model.addAttribute("products", products);
        return "list2";
    }


    @GetMapping("/list")
    public String getFormlist(Model model){
        Pageable pageable = PageRequest.of(courentPage, sizePage);
        List<Product> products = productService.findAll(pageable);
        model.addAttribute("products", products);
        return "list3";
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String listAction(@RequestParam(required = false) String action, Model model) {

        if (action.equals("next")) {
            if (courentPage + 1 > maxPage) {
                courentPage = maxPage;
            } else {
                courentPage++;
            }
        }

        if (action.equals("prev")) {
            if (courentPage - 1 < 0) {
                courentPage = 0;
            } else {
                courentPage--;
            }
        }

        Pageable pageable = PageRequest.of(courentPage, sizePage);
        List<Product> products = productService.findAll(pageable);
        model.addAttribute("products", products);

        return "list3";

    }

}



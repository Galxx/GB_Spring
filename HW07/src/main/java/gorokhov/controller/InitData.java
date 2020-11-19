package gorokhov.controller;

import gorokhov.domain.Product;
import gorokhov.domain.Role;
import gorokhov.domain.User;
import gorokhov.service.ProductServiceImpl;
import gorokhov.service.UserService;
import gorokhov.service.UserServiceImpl;

public class InitData {

    private static InitData ourInstance = new InitData();

    private InitData() {

    }

    public static InitData getInstance() {
        return ourInstance;
    }

    public void initialize(ProductServiceImpl productService){
        Product product = new Product();
        product.setTitle("banana");
        product.setPrice(54.54);
        productService.saveAndSet(product);


        Product product1 = new Product();
        product1.setTitle("tea");
        product1.setPrice(12.12);
        productService.saveAndSet(product1);

        Product product2 = new Product();
        product2.setTitle("title2");
        product2.setPrice(12.12);
        productService.saveAndSet(product2);

        Product product3 = new Product();
        product3.setTitle("title3");
        product3.setPrice(12.12);
        productService.saveAndSet(product3);

        Product product4 = new Product();
        product4.setTitle("title4");
        product4.setPrice(14.12);
        productService.saveAndSet(product4);

        Product product5 = new Product();
        product5.setTitle("title5");
        product5.setPrice(12.12);
        productService.saveAndSet(product5);

        Product product6 = new Product();
        product6.setTitle("title6");
        product6.setPrice(15.12);
        productService.saveAndSet(product6);

        Product product7 = new Product();
        product7.setTitle("title7");
        product7.setPrice(12.12);
        productService.saveAndSet(product7);

        Product product8 = new Product();
        product8.setTitle("title8");
        product8.setPrice(15.12);
        productService.saveAndSet(product8);

        Product product9 = new Product();
        product9.setTitle("title9");
        product9.setPrice(12.12);
        productService.saveAndSet(product9);

        Product product10 = new Product();
        product10.setTitle("title10");
        product10.setPrice(12.12);
        productService.saveAndSet(product10);

        Product product11 = new Product();
        product11.setTitle("title11");
        product11.setPrice(12.12);
        productService.saveAndSet(product11);

        Product product12 = new Product();
        product12.setTitle("title12");
        product12.setPrice(12.12);
        productService.saveAndSet(product12);

    }

    public void initializeUsers(UserService userService) {

        User USER = new User();
        User ADMIN = new User();
        User MANAGER = new User();
        USER.setName("User");
        USER.setPassword("pass");
        USER.setRole(Role.USER);
        userService.save(USER);

        ADMIN.setName("Admin");
        ADMIN.setPassword("admin");
        ADMIN.setRole(Role.ADMIN);
        userService.save(ADMIN);

        MANAGER.setName("Manager");
        MANAGER.setPassword("pass2");
        MANAGER.setRole(Role.MANAGER);
        userService.save(MANAGER);

    }


}

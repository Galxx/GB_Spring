import beans.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ClientJavaConfig {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductRepository productRepository = context.getBean("productRepository", ProductRepositoryImpl.class);

        productRepository.addProduct(new Product(1,"tomate",12.34));
        productRepository.addProduct(new Product(2,"meat",42.34));

        Cart cart = context.getBean("cart", CartImpl.class);
        cart.add(1);
        cart.add(1);
        cart.add(2);
        cart.add(2);

        System.out.println(cart);

        Cart cart2 = context.getBean("cart", CartImpl.class);
        cart2.add(1);
        cart2.add(1);

        System.out.println(cart2);

    }
}

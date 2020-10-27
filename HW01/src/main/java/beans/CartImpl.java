package beans;

import beans.ApplicationContextHolder;
import beans.Cart;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

public class CartImpl implements Cart {

    ArrayList<Product> cart;

    public CartImpl() {
        this.cart = new ArrayList<>();
    }

    @Override
    public void add(int id) {

        ApplicationContext context =  ApplicationContextHolder.getApplicationContext();
        ProductRepository productRepository = context.getBean("productRepository", ProductRepositoryImpl.class);

        Product product = productRepository.getProduct(id);

        if(product != null ){ cart.add(productRepository.getProduct(id));}

    }

    @Override
    public void remove(int id) {
        for (Product product:cart) {
            if (product.getId() == id) cart.remove(product);
        }
    }

    @Override
    public String toString() {
        String toString;

        toString ="";

        for (Product product: cart) {
            toString =toString + "\n" + product.toString();
        }


        return toString;
    }
}

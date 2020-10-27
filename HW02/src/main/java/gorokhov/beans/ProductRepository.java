package gorokhov.beans;

import java.util.ArrayList;


public interface ProductRepository {

    void addProduct(Product product);

    ArrayList<Product> getAllProduct();

    Product getProduct(int id);

}

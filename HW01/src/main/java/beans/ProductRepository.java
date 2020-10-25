package beans;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository {

     void addProduct(Product product);
     ArrayList<Product> getAllProduct();
     Product getProduct(int id);

}

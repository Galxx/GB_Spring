package beans;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private ArrayList<Product> repository;

    public ProductRepositoryImpl() {
        this.repository = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        repository.add(product);
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return repository;
    }

    @Override
    public Product getProduct(int id) {

        for (Product product: repository) {
            if (product.getId()==id) return product;
        }

       return null;
    }

    @Override
    public String toString() {

        String toString;

        toString ="";

        for (Product product: repository) {
            toString =toString + "\n" + product.toString();
        }


        return toString;
    }
}

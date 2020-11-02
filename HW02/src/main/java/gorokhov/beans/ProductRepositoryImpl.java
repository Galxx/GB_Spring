package gorokhov.beans;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private ArrayList<Product> repository = new ArrayList<>();

    {
        repository.add(new Product(1,"tomate",12.34));
        repository.add(new Product(2,"meat",45.34));
    }

//    public ProductRepositoryImpl() {
//        this.repository = new ArrayList<>();
//        repository.add(new Product(1,"tomate",12.34));
//    }

    @Override
    public void addProduct(Product product) {
        repository.add(product);
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return new ArrayList<Product>(repository);
    }

    @Override
    public Product getProduct(int id) {

        for (Product product: repository) {
            if (product.getId()==id) return product;
        }

        return null;
    }

    public Product save(Product product){

        repository.add(product);
        return product;

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

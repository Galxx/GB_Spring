package gorokhov.service;

import gorokhov.beans.ProductRepositoryImpl;
import gorokhov.beans.Product;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;


@Service
public class MyProductService {

    private ProductRepositoryImpl repository;

    public MyProductService(ProductRepositoryImpl repository) {
        this.repository = repository;
    }

    public ArrayList<Product> getAll(){

        return repository.getAllProduct();
    }

    public Product getProduct(int id)
    {
        return repository.getProduct(id);
    }

    public Product save(Product product){
        return repository.save(product);
    }



}

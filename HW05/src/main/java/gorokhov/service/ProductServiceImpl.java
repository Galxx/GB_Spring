package gorokhov.service;

import gorokhov.domain.Product;
import gorokhov.repository.ProductJpaDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductServiceImpl {

    private final ProductJpaDAO productJpaDAO;


    public ProductServiceImpl(ProductJpaDAO productJpaDAO) {
        this.productJpaDAO = productJpaDAO;
    }

    @Transactional
    public void saveAndSet(Product product){
        Product savedProduct = productJpaDAO.save(product);
        productJpaDAO.save(product);
    }

    @Transactional(readOnly = true)
    public Product findById(Integer id){
        return productJpaDAO.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll(){

        return  productJpaDAO.findAll();
    }

    @Transactional(readOnly = true)
    public long count(){

        long count  = productJpaDAO.count();
        return  count;
    }


    public List<Product> getByPrice(Double start, Double end){

            return productJpaDAO.findAllByPriceBetween(start,end);

    }

}

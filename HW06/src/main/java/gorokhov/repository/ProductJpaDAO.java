package gorokhov.repository;

import gorokhov.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductJpaDAO extends JpaRepository<Product, Integer> {

    List<Product> findAllByPriceBetween(Double min,Double max);

}

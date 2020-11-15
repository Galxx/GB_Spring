package gorokhov.controller;

import gorokhov.domain.Product;
import gorokhov.dto.EntityNotFoundResponse;
import gorokhov.exception.EntityNotFoundException;
import gorokhov.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {

        this.productService = productService;

    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id){
        checkById(id);
        return productService.findById(id);
    }

    // http://localhost:8080/app/products/?min=13.43&max=23.23
    @GetMapping("/")
    public List<Product> productsByPrice(Model model,
                                  @RequestParam (required = false) Double  min,
                                  @RequestParam (required = false) Double max){
        return productService.getByPrice(min == null ? 0.0 : min, max == null ? Double.MAX_VALUE : max);

    }

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product){
        System.out.println(product);
        return productService.save(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable(name = "productId") Integer id){
        product.setId(id);
        System.out.println(product);
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id){
        checkById(id);
        productService.deleteById(id);
    }

    private void checkById(@PathVariable Integer id) {
        if(!productService.existsById(id)){
            throw new EntityNotFoundException("Product", id, "Product not found");
        }
    }

    @ExceptionHandler
    public ResponseEntity<EntityNotFoundResponse> handleException(EntityNotFoundException ex){
        EntityNotFoundResponse response = new EntityNotFoundResponse();
        response.setEntityName(ex.getEntityName());
        response.setEntityId(ex.getEntityId());
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}

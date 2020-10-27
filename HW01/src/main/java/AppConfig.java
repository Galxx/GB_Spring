import beans.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("beans")
public class AppConfig {

    @Bean(name = "productRepository")
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl();
    }

    @Bean(name = "cart")
    @Scope("prototype")
    public Cart cart(){
        return new CartImpl();
    }



}
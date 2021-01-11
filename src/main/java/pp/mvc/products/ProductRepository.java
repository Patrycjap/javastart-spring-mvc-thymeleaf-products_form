package pp.mvc.products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("woda", 2.50, 1, "spożywcze"));
        products.add(new Product("patelnia", 100.00, 2, "domowe"));
        products.add(new Product("laptop", 4000.00, 3, "inne"));
        products.add(new Product("krzesło", 650.00, 4, "domowe"));
        products.add(new Product("czekolada", 5.50, 5, "spożywcze"));
    }


    public List<Product> getAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }


}



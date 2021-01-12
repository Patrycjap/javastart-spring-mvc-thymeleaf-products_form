package pp.mvc.products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("woda", 2.50, 1, "Spożywcze"));
        products.add(new Product("patelnia", 100.00, 2, "Domowe"));
        products.add(new Product("laptop", 4000.00, 3, "Inne"));
        products.add(new Product("krzesło", 650.00, 4, "Domowe"));
        products.add(new Product("czekolada", 5.50, 5, "Spożywcze"));
    }


    public List<Product> getAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }
}



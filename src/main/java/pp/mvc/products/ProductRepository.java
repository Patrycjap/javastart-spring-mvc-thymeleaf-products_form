package pp.mvc.products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("woda", 2.50, 1, Category.SPOŻYWCZE));
        products.add(new Product("patelnia", 100.00, 2, Category.DOMOWE));
        products.add(new Product("laptop", 4000.00, 3, Category.INNE));
        products.add(new Product("krzesło", 650.00, 4, Category.DOMOWE));
        products.add(new Product("czekolada", 5.50, 5, Category.SPOŻYWCZE));
    }


    public List<Product> getAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> findByCategory(Category category) {

        List<Product> filtered = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory() == category) {
                filtered.add(product);
            }
        }
        return filtered;

    }
}



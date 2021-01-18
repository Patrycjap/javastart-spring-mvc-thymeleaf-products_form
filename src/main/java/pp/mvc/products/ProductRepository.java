package pp.mvc.products;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    private List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("woda", 2.50, 1, Category.FOOD));
        products.add(new Product("patelnia", 100.00, 2, Category.DOMESTIC));
        products.add(new Product("laptop", 4000.00, 3, Category.OTHER));
        products.add(new Product("krzesło", 650.00, 4, Category.DOMESTIC));
        products.add(new Product("czekolada", 5.50, 5, Category.FOOD));
    }

    public List<Product> getAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> findByCategory(Category category) {

        return products.stream()
            .filter(product -> product.getCategory() == category)
            .collect(Collectors.toList());
    }
}



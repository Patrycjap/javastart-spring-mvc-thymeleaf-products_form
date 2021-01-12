package pp.mvc.products;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {

    public ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<String> list = new ArrayList<>();
        list.add("Wszystkie");
        list.add("Spożywcze");
        list.add("Domowe");
        list.add("Inne");

        model.addAttribute("home", list);
        model.addAttribute("product", new Product());
        model.addAttribute("products", productRepository.getAll());
        return "home";
    }


    @GetMapping("/lista")
    public String all(Model model) {
        List<Product> products = productRepository.getAll();
        model.addAttribute("product", new Product());
        model.addAttribute("products", products);

        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        model.addAttribute("sumPrice", sum);


        return "lista";
    }

    @PostMapping("/lista")
    public String productList(Product product) {

        int maxId = 1;
        for (Product product1 : productRepository.getAll()) {
            if (product1.getId() > maxId) {
                maxId = product1.getId();
            }
        }

        product.setId(maxId + 1);
        productRepository.add(product);

        return "redirect:/lista?kategoria=wszystkie";
    }
}
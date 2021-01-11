package pp.mvc.products;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {

//    private ProductRepository productRepository;
//    public ProductController(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    private List<Product>
        products;

    public ProductController() {
        products = new ArrayList<>();
        products.add(new Product("woda", 2.50, 1, "spożywcze"));
        products.add(new Product("patelnia", 100.00, 2, "domowe"));
        products.add(new Product("laptop", 4000.00, 3, "inne"));
        products.add(new Product("krzesło", 650.00, 4, "domowe"));
        products.add(new Product("czekolada", 5.50, 5, "spożywcze"));
    }

//
//    @GetMapping("/list")
//    public String products() {
//        List<Product> products = productRepository.getAll();
//
//        String result = "";
//
//        for (Product product : products) {
//            result += product.toString() + "<br/>";
//        }
//
//        return result;
//    }


    @GetMapping("/")
    public String home(Model model) {
        List<String> list = new ArrayList<>();
        list.add("wszystkie");
        list.add("spożywcze");
        list.add("domowe");
        list.add("inne");

        model.addAttribute("home", list);
        return "home";
    }


    @GetMapping("/lista")
    public String all(Model model) {

        model.addAttribute("product", new Product());
        model.addAttribute("products", products);
        return "lista";
    }


}


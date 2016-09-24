package UI;

import BO.Product;

import java.util.*;

/**
 * Created by Degern on 2016-09-22.
 */
public class ProductVM {
    private final String name;

    private ProductVM(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public static ProductVM create(String name) {
        return new ProductVM(name);
    }

    public String getName() {
        return name;
    }

    public static List<ProductVM> getAllProducts() {
        List<ProductVM> productsVM = new ArrayList<>();
        List<Product> products = Product.getAllProducts();
        products.stream().forEach(e -> {
            productsVM.add(new ProductVM(e.getName()));
        });
        return Collections.unmodifiableList(productsVM);
    }

    public static ProductVM getProductByName(String name) {
        Optional<Product> product = Product.getProductByName(name);
        if (product.isPresent()) {
            return new ProductVM(product.get().getName());
        }
        return new ProductVM("");
    }

    public String toString() {
        return name;
    }
}

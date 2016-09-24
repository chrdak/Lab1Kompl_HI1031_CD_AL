package BO;

import DB.ProductDb;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Degern on 2016-09-22.
 */
public class Product {

    private final int productCode;
    private final String name;

    protected Product(int productCode, String name){
        this.productCode = Objects.requireNonNull(productCode);
        this.name = Objects.requireNonNull(name);
    }

    public int getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public static List<Product> getAllProducts() {
        return ProductDb.getAllProducts();
    }

    public static Optional<Product> getProductByName(String name) {
        return ProductDb.getProductByName(name);
    }
}

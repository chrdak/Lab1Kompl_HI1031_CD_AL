package BO;

import DB.ProductDAO;
import UI.ProductVM;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        return ProductDAO.getAllProducts();
    }
}

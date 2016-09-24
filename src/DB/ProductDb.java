package DB;

import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import BO.Product;

/**
 * Created by Degern on 2016-09-22.
 */
public class ProductDb extends Product {

    private ProductDb(int productCode, String name) {
        super(productCode, name);
    }

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT");
            while (rs.next()) {
                products.add(new ProductDb(rs.getInt("productCode"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(products);
    }

    public static Optional<Product> getProductByName(String name) {
        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT p where p.name = '"+name +"'");
            if (rs.next()) {
                return Optional.of(new ProductDb(rs.getInt("productCode"), rs.getString("name")));
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

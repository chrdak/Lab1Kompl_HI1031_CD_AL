package DB;

import java.util.ArrayList;
import java.sql.*;
import java.util.Collections;
import java.util.List;

import BO.Product;

/**
 * Created by Degern on 2016-09-22.
 */
public class ProductDAO extends Product {

    private ProductDAO(int productCode, String name) {
        super(productCode, name);
    }

    private static void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("\nWE LOVE PEEEN STATE\n");
        }
    }

    public static List<Product> getAllProducts() {
        connect();
        Connection con = null;
        List<Product> products = new ArrayList<>();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lab1_HI1031_CD_AL",
                    "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PRODUCT");
            while (rs.next()) {
                products.add(new ProductDAO(rs.getInt("productCode"), rs.getString("name"))); // farligt? kan få åtkomst till DAO klassen eventuellt
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.unmodifiableList(products);
    }
}

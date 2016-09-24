package DB;

import BO.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

/**
 * Created by Degern on 2016-09-24.
 */
public class UserDb extends User {
    private UserDb(String username, String password) {
        super(username, password);
    }

    public static boolean exists(String username, String password){
        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM USER user where user.name = '"+ username+"'"
                  + " AND user.password ='"  + password+"'");
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean createUser(String username, String password){

        if (exists(username, password)) {
            return false;
        }
        try {
            Statement st = ConnectionManager.getConnection().createStatement();
            st.execute("INSERT INTO USER(name,password) VALUES('"+ username+"'"
                    + ",'"  + password+"')");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}

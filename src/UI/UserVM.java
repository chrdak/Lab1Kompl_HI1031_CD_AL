package UI;

import BO.User;

/**
 * Created by Degern on 2016-09-24.
 */
public class UserVM {

    public static boolean exists(String username, String password){

        return User.exists(username,password);
    }


    public static boolean createUser(String username, String password){
        return User.createUser(username, password);
    }

}

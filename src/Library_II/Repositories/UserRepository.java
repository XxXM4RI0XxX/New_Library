package Library_II.Repositories;

import Library_II.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    List<User> users = new ArrayList<>();



    public List<User> getUsers() {
        return users;
    }

    public User getUser(int userID){return users.get(userID);}
    public void addUser(User user){
        users.add(user);
    }

    public static void printUser(User user){

    }

}

package Library_II.Repositories;

import Library_II.Entities.User;
import java.util.LinkedList;
import java.util.List;

public class UserRepository {

    static protected List<User> users = new LinkedList<>();

    // ArrayList -> Mas eficiente al buscar datos, vale vrg al borrar y agregar datos en medio del array...
    //... Esto debido a que como usa arrays para funcionar, si es un array muy grande, ocupara muchos recursos.
    // LinkedList -> Vale vrg pa buscar datos, pero es super efectivo al momento de borrar y agregar datos en posiciones especificas...
    //... Esto debido a que utiliza pointers para encontrar los datos y moverlos, haciendolo super efectivo al manipularlos, pero no al buscarlos; por que
    // al buscarlos va pointer por pointer hasta encontrar el dato requerido.

    public static List<User> getUsers() {
        return users;
    }

    public static void addUser(User user){
        users.add(user);
    }

    public static void deleteUser(User user){
        users.remove(user);
    }

    public static User getUser(User getUser){
        User userToGet=null;
        for(User users : users){
            if(users.equals(getUser))
                userToGet=users;
        }
        return userToGet;
    }


}

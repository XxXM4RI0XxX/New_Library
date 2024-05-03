package Library_II.Repositories;

import Library_II.Entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    List<User> users = new ArrayList<>();

    // ArrayList -> Mas eficiente al buscar datos, vale vrg al borrar y agregar datos en medio del array...
    //... Esto debido a que como usa arrays para funcionar, si es un array muy grande, ocupara muchos recursos.
    // LinkedList -> Vale vrg pa buscar datos, pero es super efectivo al momento de borrar y agregar datos en posiciones especificas...
    //... Esto debido a que utiliza pointers para encontrar los datos y moverlos, haciendolo super efectivo al manipularlos, pero no al buscarlos; por que
    // al buscarlos va pointer por pointer hasta encopntrar el dato requerido.

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

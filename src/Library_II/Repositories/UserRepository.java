package Library_II.Repositories;

import Library_II.Entities.Administrator;
import Library_II.Entities.Client;
import Library_II.Entities.User;
import java.util.LinkedList;
import java.util.List;

public class UserRepository {

    static public List<User> users = new LinkedList<>();

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

    public static User getUser(int userID){
        return users.get(userID);
    }

    public static void printAdmins(){
        if(users.isEmpty())
            System.out.println(">>> There's no admins here :(");
        else {
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-.-._.-._.-._.-._.-._.-._.-._._");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._._.-.-`.");
            System.out.printf("§ %2s |%20s%-20s|%6s%-6s|%12s%-11s§\n", "ID", " Ad", "min", "Birth"," date","Permi","ssions");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (User user : users) {
                if(user instanceof Administrator administrator) {
                    administrator.printProfile(users.indexOf(user)+1);
                    System.out.print(" " + administrator);
                    if (administrator.getPermissions().size() == 2)
                        System.out.print("\t\t  ");
                    if (administrator.getPermissions().size() == 1)
                        System.out.print("\t\t\t\t  ");
                    if (administrator.getPermissions().isEmpty())
                        System.out.print("\t\t\t  ");
                    System.out.print(" §");
                    System.out.println();
                }
            }
            System.out.println("`----------------------------------------------------------------------------------´");
        }
    }

    public static void printClients(){
        if(users.isEmpty())
            System.out.println(">>> There's no clients here :(");
        else {
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.,-._.-._.-._.-._.-._.-._.-._.-._.-._.");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.`.");
            System.out.printf("§ %2s |%20s%-20s|%6s%-6s|%45s%-45s§\n", "ID", "Aut", "hor", "Birth"," date", "Bo","oks");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (User user : users) {
                if (user instanceof Client client) {
                    client.printProfile(users.indexOf(client)+1);
                    client.printClientBooks();
                    System.out.println();
                }
            }
            System.out.println("`----------------------------------------------------------------------------------------------------------------------------------------------------'");
        }
    }

    public static void printReturnClients(){
        if(users.isEmpty())
            System.out.println(">>> There's no clients here :(");
        else {
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.,-._.-._.-._.-._.-._.-._.-._.-._.-._.");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.`.");
            System.out.printf("§ %2s |%20s%-20s|%6s%-6s|%45s%-45s§\n", "ID", "Aut", "hor", "Birth"," date", "Bo","oks");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (User user : users) {
                if(user instanceof Client client) {
                    if (!client.getBorrowedBooks().isEmpty()) {
                        client.printProfile(users.indexOf(user)+1);
                        client.printClientBooks();
                        System.out.println();
                    }
                }
            }
            System.out.println("`----------------------------------------------------------------------------------------------------------------------------------------------------'");
        }
    }


}

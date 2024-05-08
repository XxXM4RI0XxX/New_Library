package Library_II.Repositories;

import Library_II.Entities.Client;
import Library_II.Entities.User;

public class ClientRepositoryOptions {

    public static void selectClientBook(Client client){
        client.printBorrowedBooks();
        System.out.println("If your client doesn't have any book, cancel with (0)");
    }

    public static void selectClient(){
        UserRepository.printClients();
        System.out.println("If your client isn't in the list, you can cancel with (0)");
    }

    public static void selectReturnClient(){
        UserRepository.printReturnClients();
        System.out.println("If there's no clients with borrowed books, cancel with (0)");
    }

    public static void deleteClients(int CliID){
        User delUser = UserRepository.getUser(CliID);
        Client delClient = (Client) delUser;

        if(delClient.getBorrowedBooks().isEmpty()) {
            UserRepository.users.remove(delClient);
        }
        else{
            System.out.printf(">>> The client %s has a borrowed book... wait for %s to return it ._.\n",delClient.getProfile().getName(),delClient.getProfile().getName());
        }
    }
}

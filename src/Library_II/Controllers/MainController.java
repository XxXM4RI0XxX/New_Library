package Library_II.Controllers;

import Library_II.ConsoleReader;
import Library_II.Controllers.Filters.*;
import Library_II.Controllers.Menus.*;
import Library_II.Entities.*;

import java.util.HashMap;


public class MainController {

    private static final HashMap<String,HashMap<String,Controller>> menus = Menus.getMenus();

    public static void newMainClientMenu(User loginUser){
        HashMap<String,Controller> clientMenus = menus.get("Clients");

        Client user = (Client) loginUser;
        System.out.println("\nWelcome " + user.getProfile().getName() +" "+user.getProfile().getLastName() +" :D");
        Controller printMenu = clientMenus.get("printMenu");

        boolean flag = true;

        do{
            printMenu.execute();
            char c = ConsoleReader.readChar();
            String opt = ""+c;

            

        }while (flag);

    }

    public static void mainClientMenu(User users){
        Client user = (Client) users;
        System.out.println("\nWelcome " + user.getProfile().getName() +" "+user.getProfile().getLastName() +" :D");

        boolean flag = true;
        do {

            System.out.println("\n\t  <<<CLIENT MENU>>>");
            System.out.println("-------------------------------");
            System.out.println("1) See Books\n2) See my transactions\n0) Logout");
            char opt = ConsoleReader.readChar();
            switch (opt) {
                case '1':
                    System.out.println("-------------------------------");
                    System.out.println("1) My books\n2) Library books");
                    byte optA=ConsoleReader.readByte();
                    switch (optA){
                        case 1 -> user.printBorrowedBooks();
                        case 2 -> BookFilter.seeBooks();
                        default -> System.out.println("Invalid input...");
                    }
                    break;
                case '2':
                    TransactionClientFilter.seeClientTransactions(user);
                    break;
                case '0':
                    flag = false;
                    System.out.println("May the force be with you "+user.getProfile().getName()+" :)");
                    break;
                default:
                    System.out.println("Invalid option :o");
            }
        }
        while (flag);
        ConsoleReader.q.nextLine();
    }

    public static void mainAdminMenu(User users) {
        Administrator user = (Administrator) users;
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("Welcome " + user.getProfile().getName() +" "+ user.getProfile().getLastName()+" :D");
        System.out.print("Administrator level: " + user.getAdminLevel());
        switch (user.getAdminLevel()){
            case 1 -> System.out.println("| READ |");
            case 2 -> System.out.println("| READ ; WRITE |");
            case 3 -> System.out.println("| READ ; WRITE ; DELETE |");
            case 0 -> System.out.println("| No permissions lol |");
        }

        boolean flag = true;
        do {
            System.out.println("\n\t\t<<<ADMIN MENU>>>");
            System.out.println("-------------------------------------");
            System.out.println("\t>>> Operation controls <<<");
            System.out.println("a) Borrow book\nb) Return book\nc) See transactions");
            System.out.println("-------------------------------------");
            System.out.println("\t >>> Administration controls <<<");
            System.out.println("1) Admin books\n2) Admin clients\n3) Admin authors\n0) Logout");
            System.out.println("-------------------------------------");
            System.out.println("x) Admin administrators (only Super Admin)");
            System.out.print("-> ");

            char opt = ConsoleReader.readChar();
            
            switch (opt) {
                case 'a':
                    OperationControllers.borrowBook();
                    break;
                case 'b':
                    OperationControllers.returnBook();
                    break;
                case 'c':
                    OperationControllers.seeTransactions();
                    break;
                case '1':
                    OptionMenu.adminBookMenu(user);
                    break;
                case '2':
                    OptionMenu.adminClientMenu(user);
                    break;
                case '3':
                    OptionMenu.adminAuthorMenu(user);
                    break;
                case 'x':
                    if(user.isSuperAdmin())
                        OptionMenu.superAdminMenu();
                    else System.out.println(">>> Only Super Admin can access !");
                    break;
                case '0':
                    flag = false;
                    System.out.println("May the force be with you "+user.getProfile().getName()+" :)");
                    break;
                default:
                    System.out.println("Invalid option :o");
            }
        }while (flag);
        ConsoleReader.q.nextLine();
    }
}

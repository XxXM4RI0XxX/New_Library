package Library_II.Controllers;

import Library_II.ConsoleReader;
import Library_II.Controllers.Menus.*;
import Library_II.Entities.*;

import java.util.HashMap;
import java.util.InputMismatchException;


public class MainController {

    private static final HashMap<String,HashMap<String,Controller>> menus = Menus.getMenus();

    public static void mainMenu(User loginUser){

        HashMap<String, Controller> menu;
        System.out.println("\nWelcome " + loginUser.getProfile().getName() +" "+loginUser.getProfile().getLastName() +" :D");

        //CLIENT MENU
        if(loginUser instanceof Client user) {
            menu = menus.get("clients");
            Controller printMenu = menu.get("printMenu");

            boolean flag = true;
            do{
                try {
                    printMenu.execute(user);
                    char c = ConsoleReader.readChar();

                    if(c<48||c>50)
                        throw new InputMismatchException();
                    else {
                        String opt = String.valueOf(c);
                        if (!opt.equals("0")) {
                            Controller menuAction = menu.get(opt);
                            menuAction.execute(user);
                        } else {
                            System.out.println("May the force be with you " + user.getProfile().getName() + " :)");
                            flag = false;
                        }
                    }

                }catch (InputMismatchException e){
                    System.out.println("Invalid input...");
                }
            }while (flag);
        }
        //ADMIN MENU
        else if (loginUser instanceof Administrator user){
            menu = menus.get("admins");
            Controller printMenu = menu.get("printMenu");

            boolean flag = true;
            do{
                try{
                    printMenu.execute(user);
                    char c = ConsoleReader.readChar();

                    if((c!='a'&&c!='b'&&c!='c'&&c!='1'&&c!='2'&&c!='3'&&c!='4'&&c!='0'&&c!='x'))
                        throw new InputMismatchException();
                    else {
                        String opt = String.valueOf(c);
                        if (!opt.equals("0")) {
                            Controller menuAction = menu.get(opt);
                            menuAction.execute(user);
                        } else {
                            System.out.println("May the force be with you " + user.getProfile().getName() + " :)");
                            flag = false;
                        }
                    }
                }catch (InputMismatchException e){
                    System.out.println("Invalid input...");
                }
            }while (flag);
        }
    }

/*

    /////////////////ADMINS/////////////////
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

    //////////////////CLIENTS////////////////////
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
*/

}

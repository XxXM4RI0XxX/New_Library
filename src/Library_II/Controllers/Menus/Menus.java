package Library_II.Controllers.Menus;

import Library_II.ConsoleReader;
import Library_II.Controllers.EntitiesConstructors;
import Library_II.Controllers.EntitiesModifier;
import Library_II.Controllers.Filters.*;
import Library_II.Controllers.OperationControllers;
import Library_II.Controllers.OptionMenu;
import Library_II.Entities.Administrator;
import Library_II.Entities.Book;
import Library_II.Entities.Client;
import Library_II.Repositories.AdminRepositoryOptions;
import Library_II.Repositories.BookRepository;
import Library_II.Repositories.UserRepository;
import java.util.HashMap;
import java.util.InputMismatchException;

import static Library_II.Repositories.BookRepository.books;

public class Menus{

    protected static HashMap<String,HashMap<String,Controller>> menus = new HashMap<>();

    public static HashMap<String,HashMap<String,Controller>> getMenus(){
        return menus;
    }

    public static void setMenus(){
        ////////////////////// CLIENT MENU ///////////////////////////
        HashMap<String, Controller> clientMenu = new HashMap<>();

        clientMenu.put("printMenu", user -> {
            System.out.println("\n\t  <<<CLIENT MENU>>>");
            System.out.println("-------------------------------");
            System.out.println("1) See Books\n2) See my transactions\n0) Logout");
        });
        //SEE CLIENT BOOKS
        clientMenu.put("1", logUser -> {
            System.out.println("-------------------------------");
            System.out.println("1) My books\n2) Library books");
            //SUBMENU
            HashMap<String,Controller> subMenu = new HashMap<>();
            subMenu.put("1", user1 -> {
                Client user = (Client) user1;
                user.printBorrowedBooks();
            } );
            subMenu.put("2", user2 -> BookFilter.seeBooks() );
            ///////////
            String opt = ""+ ConsoleReader.readChar();
            Controller menuAction = subMenu.get(opt);
            menuAction.execute(logUser);
        });
        //SEE CLIENT TRANSACTIONS
        clientMenu.put("2", logUser -> {
            Client user = (Client) logUser;
            TransactionClientFilter.seeClientTransactions(user);
        });
        //SAVE CLIENT MENUS//
        menus.put("clients", clientMenu);

/////////////////////////////////////////////////////////////////////////////////////
        ////////////////////// ADMIN MENU ///////////////////////////
        HashMap<String, Controller> adminMenu = new HashMap<>();
        
        adminMenu.put("printMenu", logUser -> {
            Administrator user = (Administrator) logUser;
            System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("Welcome " + user.getProfile().getName() +" "+ user.getProfile().getLastName()+" :D");
            System.out.print("Administrator level: " + user.getAdminLevel());
            switch (user.getAdminLevel()){
                case 1 -> System.out.println("| READ |");
                case 2 -> System.out.println("| READ ; WRITE |");
                case 3 -> System.out.println("| READ ; WRITE ; DELETE |");
                case 0 -> System.out.println("| No permissions lol |");
            }
            System.out.println("\n\t\t<<<ADMIN MENU>>>");
            System.out.println("-------------------------------------");
            System.out.println("\t>>> Operation controls <<<");
            System.out.println("a) Borrow book\nb) Return book\nc) See transactions");
            System.out.println("-------------------------------------");
            System.out.println("\t >>> Administration controls <<<");
            System.out.println("1) Admin books\n2) Admin clients\n3) Admin authors\n0) Logout");
            System.out.println("-------------------------------------");
            System.out.println("x) Admin administrators (only Super Admin)");
        });
        //BORROW BOOK
        adminMenu.put("a", user -> OperationControllers.borrowBook());
        //RETURN BOOK
        adminMenu.put("b", user -> OperationControllers.returnBook());
        //SEE TRANSACTIONS
        adminMenu.put("c", user -> OperationControllers.seeTransactions());
        //ADMIN BOOKS
        adminMenu.put("1", User -> {
            Administrator user = (Administrator) User;
            OptionMenu.adminBookMenu(user);
        });
        //ADMIN CLIENTS
        adminMenu.put("2", User -> {
            Administrator user = (Administrator) User;
            OptionMenu.adminClientMenu(user);
        });
        //ADMIN AUHTORS
        adminMenu.put("3", User -> {
            Administrator user = (Administrator) User;
            OptionMenu.adminClientMenu(user);
        });
        //ADMIN ADMINS
        adminMenu.put("x", User -> {
            boolean flag = true;

            //SUBMENU
            HashMap<String,Controller> subMenu = new HashMap<>();

            subMenu.put("1", user -> UserRepository.printAdmins());
            subMenu.put("2", user -> EntitiesConstructors.adminConstructor());
            subMenu.put("3", user -> {
                System.out.println("Choose the admin you want to modify...");
                AdminRepositoryOptions.selectAdmin();
                int adminID=ConsoleReader.readInt();
                if(adminID>0 && adminID<= UserRepository.users.size()){
                    EntitiesModifier.modifyAdmins(adminID);}
                else {
                    System.out.println("Invalid input...");
                }
            });
            subMenu.put("4", user -> {
                System.out.println("Choose the admin you want to delete...");
                UserRepository.printAdmins();
                System.out.println("0) Cancel");
                int AdminID=ConsoleReader.q.nextInt();
                if(AdminID>0 && AdminID<= UserRepository.users.size()){
                    AdminRepositoryOptions.deleteAdmins(AdminID-1);}
                else {
                    System.out.println("Invalid input...");
                }
            });
            ///////////
            do {
                try {
                System.out.println("\n\t<<<Admin administration>>>");
                System.out.println("1) See admins\n2) Add new admin\n3) Modify admin\n4) Delete admin\n0) Exit");
                char c = ConsoleReader.readChar();

                if(c<48||c>52)
                    throw new InputMismatchException();
                else {
                    String opt = String.valueOf(c);
                    if (!opt.equals("0")) {
                        Controller menuAction = subMenu.get(opt);
                        menuAction.execute(User);
                    } else {
                        System.out.println("May the force be with you " + User.getProfile().getName() + " :)");
                        flag = false;
                    }
                }

            }catch (InputMismatchException | NullPointerException e){
                System.out.println("Invalid input...");
            }
            }while (flag);
        });
        //SAVE ADMIN MENUS//
        menus.put("admins",adminMenu);

/////////////////////////////////////////////////////////////////////////////////////
        /////////////////////OPTION MENUS/////////////////////
        /////BOOKFILTER////////
        HashMap<String,Controller> bookFilterMenu = new HashMap<>();
        //SHOW BORROWED BOOKS
        bookFilterMenu.put("1", user -> BookRepository.printBooks());
        //SHOW AVAILABLE BOOKS
        bookFilterMenu.put("2", user -> {
            if(books.isEmpty())
                System.out.println(">>>No books in inventory :(");
            else {
                int ID = 1;
                System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-_-._");
                System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-_.-`.");
                System.out.printf("§ %2s|%25s%-25s|%20s%-20s|%6s%-6s|%10s%-9s|%5s%-5s§\n", "ID", "Tit", "le ", "Aut", "hor", "Pub. ", "date", "IS", "BN ", "Sta", "tus");
                System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
                for (Book book : books) {
                    if(!book.getIsAvailable()) {
                        book.printBook(ID);
                        ID++;
                        System.out.println();
                    }
                }
                System.out.println("`-------------------------------------------------------------------------------------------------------------------------------------------'");
            }
        });
        //SAVE BOOKFILTER MENUS//
        menus.put("bookfilter",bookFilterMenu);
    }
}

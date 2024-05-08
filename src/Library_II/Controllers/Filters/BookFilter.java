package Library_II.Controllers.Filters;

import Library_II.ConsoleReader;
import Library_II.Controllers.Menus.Controller;
import Library_II.Controllers.Menus.Menus;
import Library_II.Entities.Book;
import Library_II.Repositories.BookRepository;

import java.util.HashMap;

import static Library_II.Repositories.BookRepository.books;

public class BookFilter {

    private static final HashMap<String,HashMap<String,Controller>> menus = Menus.getMenus();

    public static void seeBooks(){
        HashMap<String,Controller> menu = menus.get("bookfilter");
        Controller print = menu.get("menu");
        int opt = ConsoleReader.readInt();

        switch (opt){
            case 0:
                BookRepository.printBooks();
                break;
            case 1:
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
                break;
            case 2:
                if(books.isEmpty())
                    System.out.println(">>>No books in inventory :(");
                else {
                    int ID = 1;
                    System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-_-._");
                    System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-_.-`.");
                    System.out.printf("§ %2s|%25s%-25s|%20s%-20s|%6s%-6s|%10s%-9s|%5s%-5s§\n", "ID", "Tit", "le ", "Aut", "hor", "Pub. ", "date", "IS", "BN ", "Sta", "tus");
                    System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
                    for (Book book : books) {
                        if(book.getIsAvailable()) {
                            book.printBook(ID);
                            ID++;
                            System.out.println();
                        }
                    }System.out.println("`-------------------------------------------------------------------------------------------------------------------------------------------'");

                }
            }

        }
    }

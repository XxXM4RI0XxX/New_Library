package Library_II;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class ConsoleReader{

    public static Scanner q = new Scanner(System.in);

    public static void main(String[] args) {

        int x = readInt();


    }

    public static int readInt(){

        System.out.print(">> ");
        int number = q.nextInt();
        try{

        }catch (ExecutionException){

        }



    }

}

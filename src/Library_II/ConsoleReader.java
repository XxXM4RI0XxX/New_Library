package Library_II;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader{

    public static Scanner q = new Scanner(System.in);

    public static byte readByte(){
        byte number = 0;
        boolean flag=true;

        do {
            try {
                System.out.print("-> ");
                number = q.nextByte();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number...");
                q.nextLine();
            }
        }while(flag);

        return number;
    }


    public static int readInt(){
        int number = 0;
        boolean flag=true;

        do {
            try {
                System.out.print("-> ");
                float x = q.nextFloat();
                number = (int) x;
                return number;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number...");
                q.nextLine();
            }
        }while(flag);

        return number;
    }

    public static long readLong(){
        long number = 0;
        boolean flag=true;

        do {
            try {
                System.out.print("-> ");
                float x = q.nextFloat();
                number = (long) x;
                return number;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number...");
                q.nextLine();
            }
        }while(flag);

        return number;
    }

    public static float readFloat(){
        float number = 0;
        boolean flag = true;

        do{
            try {
                System.out.print("-> ");
                number = q.nextFloat();
                return number;
            } catch (InputMismatchException e){
                System.out.println("Please enter a valid number...");
                q.nextLine();
            }
        }while (flag);

        return number;
    }

    public static double readDouble(){
        double number = 0;
        boolean flag = true;

        do{
            try {
                System.out.print("-> ");
                number = q.nextDouble();
                return number;
            } catch (InputMismatchException e){
                System.out.println("Please enter a valid number...");
                q.nextLine();
            }
        }while (flag);

        return number;
    }

    public static char readChar(){
        char character = ' ';
        boolean flag = true;

        do {
            System.out.print("-> ");
            String value = q.nextLine();
            if(value.length()>1){
                System.out.println("Enter a valid character...");
            }else {
                return value.charAt(0);
            }
        }while (flag);

        return character;
    }

    public static String readString(int maxLength){ //maxLength = 0 for any length
        String line = "";

        if(maxLength>0){
            do{
                System.out.print("-> ");
                line = q.nextLine();
                if(line.length()>maxLength)
                    System.out.println(">>> Invalid length...");
                else return line;
            }while (line.length()>maxLength);
        }
        else{
            System.out.print("-> ");
            line = q.nextLine();
            return line;
        }

        return line;
    }
}

package Library_II.Controllers;

import Library_II.ConsoleReader;
import Library_II.Entities.*;
import Library_II.Repositories.*;

public class Login {

    public static void loginScreen() {
        boolean outFlag=true;

        do {
            System.out.println("\n\t\t >>>LOGIN<<<");
            String loginUsername = null;
            String username;
            User user = null;

            //VERIFY USERNAME
            do {
                System.out.println("<Left username blank to exit library system>");
                System.out.print("Username: ");
                username = ConsoleReader.readString(0);

                for(User getUser : UserRepository.getUsers()){
                    if(getUser.getUsername().equals(username)) {
                        loginUsername = getUser.getUsername();
                        user = getUser;
                    }
                }

                if (loginUsername == null && !username.isEmpty()) {
                    System.out.println("Username not found...");
                }
            } while (loginUsername == null && !username.isEmpty());

            if (!username.isEmpty()) {
                    //VERIFY PASSWORD
                    boolean flag = true;
                    do {
                        System.out.println("<Left password blank to cancel>");
                        System.out.print("Password: ");
                        String inputPassword = ConsoleReader.readString(0);
                        //Check password is the same
                        boolean checkPassword = User.checkPassword(inputPassword,user.getPassword());
                        if (checkPassword) {
                            flag = false;
                            if(user instanceof Client)
                               MainController.newMainClientMenu(user);
                            else MainController.mainAdminMenu(user);
                        } else if (inputPassword.isEmpty()){
                            System.out.println(">>> Login canceled");
                            flag=false;
                        }
                        else {
                            System.out.println("Invalid password, try again...");
                        }
                    } while (flag);

            } else {
                outFlag=false;
            }

        }while(outFlag);
    }
}

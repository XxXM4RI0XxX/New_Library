package Library_II.Repositories;

import Library_II.Entities.User;

public class AdminRepositoryOptions {

    public static void selectAdmin(){
        UserRepository.printAdmins();
        System.out.println("If your administrator isn't in the list, you can cancel with (0)");
    }

    public static void deleteAdmins(int adminID){
        User delAdmin = UserRepository.getUser(adminID);
        System.out.printf("Administrator %s %s successfully deleted :(",delAdmin.getProfile().getName(),delAdmin.getProfile().getLastName());
        UserRepository.users.remove(delAdmin);
    }

}

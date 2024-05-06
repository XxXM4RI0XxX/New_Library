package Library_II.Controllers.Menus;

import java.util.HashMap;

class Menu {
    private final HashMap<Integer, MenuItem> controller;
    private final Integer key;

    public Menu(HashMap<Integer, MenuItem> controller,Integer key) {
        this.controller = controller;
        this.key = key;
    }

    public void display() {
        System.out.println("Seleccione una opción:");
        for (Integer key : controller.keySet()){
            MenuItem menuItem = controller.get(key);
            System.out.println(key + " - " + menuItem.getKey());
        }
    }

    public void execute() {

            display();
            if (controller.containsKey(key))
                controller.get(key).execute();
             else System.out.println(">>> Invalid option...");
    }
}
//    static HashMap<String, Controller> adminMenus = new HashMap<>();
//    static HashMap<String, Controller> clientMenus = new HashMap<>();
//
//    public static void addMenu(String key, Controller controller) {
//        menus.put(key, controller);
//    }
//    public static Controller getMenu(String key){
//        return menus.get(key);
//    }
//    public static void addAdminMenu(String key, Controller controller) {
//        adminMenus.put(key, controller);
//    }
//    public static Controller getAdminMenu(String key){
//        return adminMenus.get(key);
//    }
//    public static void addClientMenu(String key, Controller controller) {
//        clientMenus.put(key, controller);
//    }
//    public static Controller getClientMenu(String key){
//        return clientMenus.get(key);
//    }


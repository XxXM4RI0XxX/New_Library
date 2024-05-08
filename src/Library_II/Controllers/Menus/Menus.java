package Library_II.Controllers.Menus;

import java.util.HashMap;

public class Menus implements Controller {

    protected static HashMap<String,HashMap<String,Controller>> menuRepository = new HashMap<>();

    public static HashMap<String,HashMap<String,Controller>> getMenus(){
        return menuRepository;
    }
    public static void writeMenus(HashMap<String,HashMap<String,Controller>> newMenu){
        menuRepository = newMenu;
    }

    public Menus() {

    }

    @Override
    public void execute() {

    }
}

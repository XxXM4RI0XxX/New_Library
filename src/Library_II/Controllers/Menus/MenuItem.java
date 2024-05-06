package Library_II.Controllers.Menus;

import Library_II.Controllers.Controller;

class MenuItem implements Controller {
    private final String key;
    private final Controller controller;

    public MenuItem(String key, Controller controller) {
        this.key = key;
        this.controller = controller;
    }

    public String getKey() {
        return key;
    }

    public void execute() {
        controller.execute();
    }
}
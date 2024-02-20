import SystemOutputs.AdminMenu;
import SystemOutputs.MainMenu;

public class Main {
    public static void main(String[] args) {
        int menuTotalSize = 100;
        boolean adminMenu = true;
        if (adminMenu)
            AdminMenu.runMenu(menuTotalSize);
        else MainMenu.runMenu(menuTotalSize);
    }
}
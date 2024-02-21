import SystemOutputs.AdminMenu;
import SystemOutputs.MainMenu;

import static SystemOutputs.HandshakeMenu.runHandshakeMenu;

public class Main {
    public static void main(String[] args) {
        int menuTotalSize = 100;
        runHandshakeMenu(menuTotalSize);
    }
}
package SystemOutputs;

import java.util.Scanner;

public class UserInterface {

    private final int menuTotalSize;
    public UserInterface(int screenSize) {
        this.menuTotalSize = screenSize;
    }



    public static int nextInt(Scanner scn) {
        int i = scn.nextInt();
        scn.nextLine();
        return i;
    }

    public static double getDoubleInput(Scanner scn) {
        double i = scn.nextDouble();
        scn.nextLine();
        return i;
    }

    public String writeMenuOption(String option, String borderChar) {
        int totalSpaces = this.menuTotalSize - option.length() - 4;
        int sideLength = totalSpaces / 2;

        StringBuilder charFilling = new StringBuilder();
        for (int i = 0; i < sideLength; i++) {
            charFilling.append(" ");
        }

        String response = borderChar + charFilling + " " + option + " " + charFilling + borderChar;
        System.out.println(response);
        return response;
    }

    public String writeMenuOption(String option) {
        return writeMenuOption(option, "*");
    }

    public static String getStringInput(Scanner scn) {
        return scn.nextLine();
    }
}

package SystemOutputs;

import java.util.Scanner;

public class MainMenu  {
    private static UserInterface userInterface;
    private static Scanner scannerObj;
    public static void runMenu(int menuTotalSize) {
        userInterface = new UserInterface(menuTotalSize);
        scannerObj = new Scanner(System.in);
        int menuChoice;
        do {
            menuChoice = mainMenu();
            switch (menuChoice) {
                case 1:
                    break;
                case 0:
                    userInterface.writeMenuOption("Saindo do menu de Administração...");
            }
            userInterface.writeMenuOption("Pressione [ENTER] para continuar");
            scannerObj.nextLine();
        } while (menuChoice != 0);
    }

    private static int mainMenu() {
        userInterface.writeMenuOption("========================================================");
        userInterface.writeMenuOption(" Menu principal (em construção) ");
        userInterface.writeMenuOption("========================================================");
        /*userInterface.writeMenuOption("[1] - Teste de Aluno");
        userInterface.writeMenuOption("[7] - Listar Enum Status de Matricula");
        userInterface.writeMenuOption("[8] - Listar Enum Cargo de Funcionários");
        */
        userInterface.writeMenuOption("[0] - Sair do Sistema");

        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("Selecione uma opção:");
        userInterface.writeMenuOption("========================================================");

        return UserInterface.nextInt(scannerObj);
    }
}

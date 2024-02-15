package SystemOutputs;

import java.util.Scanner;

public class UserInterface {

    private final int menuTotalSize;
    public UserInterface(int screenSize) {
        this.menuTotalSize = screenSize;
    }

    public int adminMenu(Scanner scannerObj, int menuTotalSize) {
        writeMenuOption("========================================================");
        writeMenuOption(" Tela de Administração do Sistema");
        writeMenuOption("========================================================");
        writeMenuOption("[1] - Teste de Aluno");
        //writeMenuOption("[] - Teste de Professor");
        //writeMenuOption("[] - Teste de Curso");
        //writeMenuOption("[] - Teste de Turma");
        writeMenuOption("");
        writeMenuOption("[7] - Listar Enum Status de Matricula");
        writeMenuOption("[8] - Listar Enum Cargo de Funcionários");
        writeMenuOption("[0] - Sair do Sistema");
        writeMenuOption("");
        writeMenuOption("Selecione uma opção:");
        writeMenuOption("========================================================");

        return nextInt(scannerObj);
    }

    public static int nextInt(Scanner scn) {
        int i = scn.nextInt();
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
}

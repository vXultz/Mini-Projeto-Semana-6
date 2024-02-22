package SystemOutputs;

import java.util.Scanner;
import Aluno.Aluno;
import Funcionario.Professor;


public class HandshakeMenu {
    private static UserInterface userInterface;
    private static Scanner scannerObj;

    public static void runHandshakeMenu(int menuTotalSize) {
        userInterface = new UserInterface(menuTotalSize);
        scannerObj = new Scanner(System.in);
        int menuChoice, signinMenuChoice;
        do {
            menuChoice = printHandshakeMenu();
            EnumUserType loggedUserType;
            switch (menuChoice) {
                case 1:
                    loggedUserType = EnumUserType.ALUNO;
                    runAlunoHandshakeMenu();
                    break;
                case 2:
                    loggedUserType = EnumUserType.PROFESSOR;
                    runProfessorHandshakeMenu();
                    break;

                case 42:
                    loggedUserType = EnumUserType.ADMIN;
                    AdminMenu.runMenu(menuTotalSize);
                    break;
                case 0:
                    userInterface.writeMenuOption("Encerrando o sistema...");
                    userInterface.writeMenuOption("Pressione [ENTER] para continuar");
                    scannerObj.nextLine();

                    break;
                default:
                    userInterface.writeMenuOption("A Opção escolhida [" + menuChoice + "] é inválida, tente novamente");
                    userInterface.writeMenuOption("Pressione [ENTER] para continuar");
                    scannerObj.nextLine();

                    break;
            }
        } while (menuChoice != 0);
    }

    private static void runProfessorHandshakeMenu() {
        int profMenuChoice;
        do {
            profMenuChoice = printSignupSigninMenu(EnumUserType.PROFESSOR);
            ProfessorMenu profMenu = new ProfessorMenu(scannerObj, userInterface);
            switch (profMenuChoice) {
                case 1:
                    Professor newProfessor = ProfessorMenu.addProfessor();
                    if (newProfessor != null)
                        profMenu.runMainMenu(newProfessor);
                    break;
                case 2:
                    userInterface.writeMenuOption("Existing Prof Workflow");
                    /*Aluno existingAluno = alunoMenu.getExistingAluno();
                    if (existingAluno != null)
                        alunoMenu.runMainMenu(existingAluno);*/
                    break;
                case 0:
                    userInterface.writeMenuOption("Voltando ao menu anterior...");
                    userInterface.writeMenuOption("Pressione [ENTER] para continuar");
                    scannerObj.nextLine();
                    break;
                default:
                    userInterface.writeMenuOption("A Opção escolhida ["+profMenuChoice+"] é inválida, tente novamente");
                    userInterface.writeMenuOption("Pressione [ENTER] para continuar");
                    scannerObj.nextLine();
                    break;
            }
        } while (profMenuChoice != 0);
    }

    private static int printHandshakeMenu() {
        userInterface.writeMenuOption("========================================================");
        userInterface.writeMenuOption(" Bem vindo ao sistema ");
        userInterface.writeMenuOption("========================================================");
        userInterface.writeMenuOption("Por favor, identifique-se:");
        userInterface.writeMenuOption("[1] - Aluno");
        userInterface.writeMenuOption("[2] - Professor");
        userInterface.writeMenuOption("[3] - Diretor");
        userInterface.writeMenuOption("[0] - Sair do Sistema");
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("Selecione uma opção:");
        userInterface.writeMenuOption("========================================================");

        return UserInterface.nextInt(scannerObj);
    }

    private static void runAlunoHandshakeMenu(){
        int alunoMenuChoice;
        do {
            alunoMenuChoice = printSignupSigninMenu(EnumUserType.ALUNO);
            AlunoMenu alunoMenu = new AlunoMenu(scannerObj,userInterface);
            switch (alunoMenuChoice) {
                case 1:
                    Aluno newAluno = alunoMenu.addAluno();
                    if (newAluno != null)
                        alunoMenu.runMainMenu(newAluno);
                    break;
                case 2:
                    Aluno existingAluno = alunoMenu.getExistingAluno();
                    if (existingAluno != null)
                        alunoMenu.runMainMenu(existingAluno);
                    break;
                case 0:
                    userInterface.writeMenuOption("Voltando ao menu anterior...");
                    break;
                default:
                    userInterface.writeMenuOption("A Opção escolhida ["+alunoMenuChoice+"] é inválida, tente novamente");
                    break;
            }
            userInterface.writeMenuOption("Pressione [ENTER] para continuar");
            scannerObj.nextLine();
        } while (alunoMenuChoice != 0);
    }
    private static int printSignupSigninMenu(EnumUserType userType){
        switch (userType) {
            case ALUNO:
                userInterface.writeMenuOption("========================================================");
                userInterface.writeMenuOption(" Login de Aluno ");
                userInterface.writeMenuOption("========================================================");
                userInterface.writeMenuOption("Você já possui uma conta cadastrada?");
                userInterface.writeMenuOption("[1] - Sou um novo Aluno");
                userInterface.writeMenuOption("[2] - Já tenho cadastro ");
                userInterface.writeMenuOption("[0] - Voltar ao menu anterior");
                userInterface.writeMenuOption("");
                userInterface.writeMenuOption("Selecione uma opção:");
                userInterface.writeMenuOption("========================================================");
                break;
            /*case FUNCIONARIO:
                userInterface.writeMenuOption("========================================================");
                userInterface.writeMenuOption(" Login de Funcionário ");
                userInterface.writeMenuOption("========================================================");
                userInterface.writeMenuOption("Qual o seu tipo de conta");
                userInterface.writeMenuOption("[1] - Professor");
                userInterface.writeMenuOption("[2] - Diretor");
                userInterface.writeMenuOption("[0] - Voltar ao menu anterior");
                userInterface.writeMenuOption("");
                userInterface.writeMenuOption("Selecione uma opção:");
                userInterface.writeMenuOption("========================================================");
                break;*/
            case PROFESSOR:
                userInterface.writeMenuOption("========================================================");
                userInterface.writeMenuOption(" Login de Professor ");
                userInterface.writeMenuOption("========================================================");
                userInterface.writeMenuOption("Você já possui uma conta cadastrada?");
                userInterface.writeMenuOption("[1] - Nova conta");
                userInterface.writeMenuOption("[2] - Já tenho cadastro ");
                userInterface.writeMenuOption("[0] - Voltar ao menu anterior");
                userInterface.writeMenuOption("");
                userInterface.writeMenuOption("Selecione uma opção:");
                userInterface.writeMenuOption("========================================================");
                break;
            case DIRETOR:
                userInterface.writeMenuOption("========================================================");
                userInterface.writeMenuOption(" Login de Diretor ");
                userInterface.writeMenuOption("========================================================");
                userInterface.writeMenuOption("Você já possui uma conta cadastrada?");
                userInterface.writeMenuOption("[1] - Nova conta");
                userInterface.writeMenuOption("[2] - Já tenho cadastro ");
                userInterface.writeMenuOption("[0] - Voltar ao menu anterior");
                userInterface.writeMenuOption("");
                userInterface.writeMenuOption("Selecione uma opção:");
                userInterface.writeMenuOption("========================================================");
                break;
        }
        return UserInterface.nextInt(scannerObj);
    }
}

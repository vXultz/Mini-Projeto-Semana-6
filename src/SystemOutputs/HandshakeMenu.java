package SystemOutputs;

import java.util.Scanner;
import Aluno.Aluno;


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
                    runAlunoHandShakeMenu();
                    break;
                case 2:
                    signinMenuChoice = printSignupSigninMenu(EnumUserType.FUNCIONARIO);
                    loggedUserType = (signinMenuChoice == 1) ?  EnumUserType.PROFESSOR : EnumUserType.DIRETOR;
                    /* chama runFuncionarioHandShakeMenu(loggedUserType) contendo seu proprio loop para garantir
                    * possibilidade de retorno ao menu anterior correto */
                    break;
                case 42:
                    loggedUserType = EnumUserType.ADMIN;
                    AdminMenu.runMenu(menuTotalSize);
                    break;
                case 0:
                    userInterface.writeMenuOption("Encerrando o sistema...");
                    break;
                default:
                    userInterface.writeMenuOption("A Opção escolhida [" + menuChoice + "] é inválida, tente novamente");
                    break;
            }
            userInterface.writeMenuOption("Pressione [ENTER] para continuar");
            scannerObj.nextLine();
        } while (menuChoice != 0);

    }
    private static int printHandshakeMenu() {
        userInterface.writeMenuOption("========================================================");
        userInterface.writeMenuOption(" Bem vindo ao sistema ");
        userInterface.writeMenuOption("========================================================");
        userInterface.writeMenuOption("Por favor, identifique-se:");
        userInterface.writeMenuOption("[1] - Aluno");
        userInterface.writeMenuOption("[2] - Funcionário");
        userInterface.writeMenuOption("[0] - Sair do Sistema");
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("Selecione uma opção:");
        userInterface.writeMenuOption("========================================================");

        return UserInterface.nextInt(scannerObj);
    }

    private static void runAlunoHandShakeMenu(){
        int alunoMenuChoice;
        do {
            alunoMenuChoice = printSignupSigninMenu(EnumUserType.ALUNO);
            switch (alunoMenuChoice) {
                case 1:
                    //se novo aluno, chama método de  cadastro de aluno
                    AlunoMenu alunoMenu = new AlunoMenu(scannerObj,userInterface);
                    Aluno newAluno = alunoMenu.addAluno();
                    alunoMenu.runMainMenu();
                    break;
                case 2:
                    //se existente, chama método de pesquisa de aluno existente
                    userInterface.writeMenuOption("chama método de pesquisa de aluno existente");
                    userInterface.writeMenuOption("chama MainMenu de aluno");
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
            case FUNCIONARIO:
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
                break;
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

package SystemOutputs;

import Aluno.Aluno;
import Curso.Curso;
import Funcionario.Professor;
import Testes.TestesAluno;
import Testes.TestesFuncionario;

import java.util.Scanner;

public class AdminMenu {
    private static UserInterface userInterface;
    private static Scanner scannerObj;

    public static void runMenu(int menuTotalSize) {
        userInterface = new UserInterface(menuTotalSize);
        scannerObj = new Scanner(System.in);
        int adminMenuChoice;
        do {
            adminMenuChoice = printMenu();
            switch (adminMenuChoice) {
                case 1:
                    TestesAluno testesAluno = new TestesAluno(userInterface);
                    Aluno alunoTeste1 = testesAluno.criarAluno("Peter Parker", 18);
                    Aluno alunoTeste2 = testesAluno.criarAluno();
                    Professor professor = new Professor("Prof Teste", 41, 10);
                    Curso newCurso = new Curso("Curso de Exemplo 1", professor);
                    Curso newCurso2 = new Curso("Curso de Exemplo 2", professor);
                    Curso newCurso3 = new Curso("Curso de Exemplo 3", professor);
                    testesAluno.matricularAluno(alunoTeste1, newCurso);
                    testesAluno.matricularAluno(alunoTeste1, newCurso2);
                    testesAluno.matricularAluno(alunoTeste1, newCurso3);
                    break;
                case 7:
                    TestesAluno testesAlunoEnum = new TestesAluno(userInterface);
                    Aluno alunoTeste7 = testesAlunoEnum.criarAluno("Peter Parker", 18);
                    testesAlunoEnum.listEnumStatusMatricula(alunoTeste7);
                    break;
                case 8:
                    TestesFuncionario testesFuncEnum = new TestesFuncionario(userInterface);
                    testesFuncEnum.listEnumCargoFuncionario();
                    break;
                case 0:
                    userInterface.writeMenuOption("Saindo do menu de Administração...");
                default:
                    userInterface.writeMenuOption("A Opção escolhida [" + adminMenuChoice + "] é inválida, tente novamente");
            }
            userInterface.writeMenuOption("Pressione [ENTER] para continuar");
            scannerObj.nextLine();
        } while (adminMenuChoice != 0);
    }

    private static int printMenu() {
        userInterface.writeMenuOption("========================================================");
        userInterface.writeMenuOption(" Tela de Administração do Sistema");
        userInterface.writeMenuOption("========================================================");
        userInterface.writeMenuOption("[1] - Teste de Aluno");
        //userInterface.writeMenuOption("[] - Teste de Professor");
        //userInterface.writeMenuOption("[] - Teste de Curso");
        //userInterface.writeMenuOption("[] - Teste de Turma");
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("[7] - Listar Enum Status de Matricula");
        userInterface.writeMenuOption("[8] - Listar Enum Cargo de Funcionários");
        userInterface.writeMenuOption("[0] - Sair do Sistema");
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("Selecione uma opção:");
        userInterface.writeMenuOption("========================================================");

        return UserInterface.nextInt(scannerObj);
    }
}

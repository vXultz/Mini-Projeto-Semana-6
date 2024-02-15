import SystemOutputs.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuTotalSize = 100;
        presentAdminMenu(menuTotalSize);
    }

    private static void presentAdminMenu(int menuTotalSize) {
        UserInterface userInterface = new UserInterface(menuTotalSize);
        Scanner scannerObj = new Scanner(System.in);
        int adminMenuChoice = 0;
        do {
            adminMenuChoice = userInterface.adminMenu(scannerObj, menuTotalSize);
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
                    testesAlunoEnum.listEnumStatusMatricula();
                    break;
                case 8:
                    TestesFuncionario testesFuncEnum = new TestesFuncionario(userInterface);
                    testesFuncEnum.listEnumCargoFuncionario();
                    break;
                case 0:
                    userInterface.writeMenuOption("Saindo do meu de Administração...");
            }
            userInterface.writeMenuOption("Pressione [ENTER] para continuar");
            scannerObj.nextLine();
        } while (adminMenuChoice != 0);
    }
}
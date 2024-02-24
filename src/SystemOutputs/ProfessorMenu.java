package SystemOutputs;

import Funcionario.DadosProfessor;
import Funcionario.Professor;
import Aluno.Aluno;
import Aluno.DadosAlunos;
import Turma.Turma;
import java.util.Objects;
import java.util.Scanner;

public class ProfessorMenu {
    private static UserInterface userInterface;
    private static Scanner scannerObj;
    private Professor currentProfessor;

    public ProfessorMenu(Scanner scannerObj, UserInterface userInterface) {
        this.scannerObj = scannerObj;
        this.userInterface = userInterface;
    }

    public static Professor addProfessor() {
        Professor newProf = getValidNewProfessor();
        if (newProf == null || newProf.getIdade() == 0 || newProf.getTempoDeCargo() == 0)
            return null;
        DadosProfessor.adicionarProfessor(newProf);
        return newProf;
    }

    private static Professor getValidNewProfessor() {
        return getValidNewProfessor(null);
    }

    private static Professor getValidNewProfessor(String profName) {
        if (profName == null || profName.isEmpty()) {
            userInterface.writeMenuOption("Digite o nome para o professor, ou 0 para cancelar:");
            profName = UserInterface.getStringInput(scannerObj);
            if (Objects.equals(profName, "0"))
                return null;
        }
        Professor existingProfessor = DadosProfessor.buscarProfessor(profName);
        if (existingProfessor != null) {
            userInterface.writeMenuOption("O Professor com nome [" + existingProfessor.getNome() + "], idade [" + existingProfessor.getIdade() + "] é inválido pois já está cadastrado.");
            userInterface.writeMenuOption("[1] Cadastrar outro professor");
            userInterface.writeMenuOption("[2] Usar o professor encontrado");
            int existingProfessorMenuChoice = UserInterface.nextInt(scannerObj);
            if (existingProfessorMenuChoice == 2)
                return existingProfessor;
            else
                return getValidNewProfessor();
        } else return new Professor(profName,getValidProfessorTempoDeCargo(),getValidProfessorIdade());
    }

    private static int getValidProfessorIdade() {
        userInterface.writeMenuOption("Digite a idade do professor, ou [0] para cancelar");
        try {
            return UserInterface.nextInt(scannerObj);
        } catch (Exception e) {
            System.err.println("Houve um erro com a idade digitada. Verifique se é uma idade válida.");
            return getValidProfessorIdade();
        }
    }

    private static int getValidProfessorTempoDeCargo() {
        userInterface.writeMenuOption("Digite o tempo de cargo do professor em meses, ou [0] para cancelar");
        try {
            return UserInterface.nextInt(scannerObj);
        } catch (Exception e) {
            System.err.println("Houve um erro com o tempo de cargo digitado. Verifique se é uma idade válida.");
            return getValidProfessorTempoDeCargo();
        }
    }
    public void runMainMenu(Professor loggedProfessor) {
        this.currentProfessor = loggedProfessor;
        boolean exit = false;
        while (!exit) {
            userInterface.writeMenuOption("Aqui será apresentado o menu do Professor [" + this.currentProfessor.getNome() + "]");
            userInterface.writeMenuOption("[1] Listar turmas");
            userInterface.writeMenuOption("[2] Adicionar aluno a turma");
            userInterface.writeMenuOption("[3] Remover aluno da turma");
            userInterface.writeMenuOption("[0] Sair");

            int choice = UserInterface.nextInt(scannerObj);

            switch (choice) {
                case 1:
                    listarAlunosTurma();
                    break;
                case 2:
                    adicionarAlunoTurma();
                    break;
                case 3:
                    removerAlunoTurma();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    userInterface.writeMenuOption("Opção inválida!");
            }
        }
    }
    private void runMainMenu(){
        userInterface.writeMenuOption("Aqui será apresentado o menu do Professor ["+ this.currentProfessor.getNome()+"]");
    }

    public void adicionarAlunoTurma() {
        if (currentProfessor != null) {
            Turma turma = currentProfessor.getTurma();
            if (turma != null) {
                System.out.println("Digite o nome do aluno que deseja adicionar à turma:");
                String nomeAluno = scannerObj.nextLine();
                Aluno aluno = DadosAlunos.buscarAluno(nomeAluno);
                if (aluno != null) {
                    currentProfessor.adicionarAlunoTurma(aluno);
                } else {
                    System.out.println("Aluno não encontrado.");
                }
            } else {
                System.out.println("O professor " + currentProfessor.getNome() + " não tem uma turma atribuída.");
            }
        } else {
            System.out.println("Não há professor logado.");
        }
    }

    public void removerAlunoTurma() {
        if (currentProfessor != null) {
            Turma turma = currentProfessor.getTurma();
            if (turma != null) {
                System.out.println("Digite o nome do aluno que deseja remover da turma:");
                String nomeAluno = scannerObj.nextLine();
                Aluno aluno = DadosAlunos.buscarAluno(nomeAluno);
                if (aluno != null) {
                    currentProfessor.removerAlunoTurma(aluno);
                } else {
                    System.out.println("Aluno não encontrado.");
                }
            } else {
                System.out.println("O professor " + currentProfessor.getNome() + " não tem uma turma atribuída.");
            }
        } else {
            System.out.println("Não há professor logado.");
        }
    }

    public void listarAlunosTurma() {
        if (currentProfessor != null) {
            currentProfessor.listarAlunosTurma();
        } else {
            System.out.println("Não há professor logado.");
        }
    }


    public static Professor getExistingProfessor() {
        userInterface.writeMenuOption("Digite o nome para o professor, ou 0 para cancelar:");
        String profName = UserInterface.getStringInput(scannerObj);
        if (Objects.equals(profName, "0"))
            return null;
        Professor existingProfessor = DadosProfessor.buscarProfessor(profName);
        if (existingProfessor != null)
            return existingProfessor;
        else {
            userInterface.writeMenuOption("O Professor com nome [" + profName + "], não foi encontrado no cadastro.");
            userInterface.writeMenuOption("[1] Tentar novamente ");
            userInterface.writeMenuOption("[2] Cadastrar um novo professor com nome[" + profName + "]");
            int existingAlunoMenuChoice = UserInterface.nextInt(scannerObj);
            if (existingAlunoMenuChoice == 2)
                return getValidNewProfessor(profName);
            else
                return getExistingProfessor();
        }
    }

    public Professor getCurrentProfessor() {
        return currentProfessor;
    }

    public void setCurrentProfessor(Professor currentProfessor) {
        this.currentProfessor = currentProfessor;
    }
}
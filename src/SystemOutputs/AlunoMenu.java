package SystemOutputs;

import java.util.Objects;
import java.util.Scanner;
import Aluno.Aluno;
import Aluno.DadosAlunos;
import Curso.Curso;

public class AlunoMenu {
    private UserInterface userInterface;
    private Scanner scannerObj;
    private Aluno currentAluno;

    public AlunoMenu(Scanner scannerObj, UserInterface userInterface) {
        this.scannerObj = scannerObj;
        this.userInterface = userInterface;
    }
    public Aluno addAluno(){
        Aluno newAluno = getValidNewAluno();
        if (newAluno == null || newAluno.getIdade() == 0)
            return null;
        DadosAlunos.adicionarAluno(newAluno);
        return newAluno;
    }

    private Aluno getValidNewAluno() {
        return getValidNewAluno(null);
    }
    private Aluno getValidNewAluno(String alunoName) {
        if (alunoName == null || alunoName.isEmpty()) {
            userInterface.writeMenuOption("Digite o nome para o aluno, ou 0 para cancelar:");
            alunoName = UserInterface.getStringInput(scannerObj);
            if (Objects.equals(alunoName, "0"))
                return null;
        }
        Aluno existingAluno = DadosAlunos.buscarAluno(alunoName);
        if (existingAluno != null) {
            userInterface.writeMenuOption("O Aluno com nome [" + existingAluno.getNome() + "], idade [" + existingAluno.getIdade() + "] é inválido pois já está cadastrado.");
            userInterface.writeMenuOption("[1] Cadastrar outro aluno");
            userInterface.writeMenuOption("[2] Usar o aluno encontrado");
            int existingAlunoMenuChoice = UserInterface.nextInt(scannerObj);
            if (existingAlunoMenuChoice == 2)
                return existingAluno;
            else
                return getValidNewAluno();
        } else return new Aluno(alunoName,getValidAlunoIdade());
    }

    private int getValidAlunoIdade() {
        userInterface.writeMenuOption("Digite a idade do aluno, ou [0] para cancelar");
        try {
            return UserInterface.nextInt(scannerObj);
        } catch (Exception e) {
            System.err.println("Houve um erro com a idade digitada. Verifique se é uma idade válida.");
            return getValidAlunoIdade();
        }
    }

    public void runMainMenu(Aluno loggedAluno) {
        this.currentAluno = loggedAluno;
        boolean exit = false;
        while (!exit) {
            userInterface.writeMenuOption("Aqui será apresentado o menu do Aluno [" + this.currentAluno.getNome() + "]");
            userInterface.writeMenuOption("[1] Listar cursos");
            userInterface.writeMenuOption("[2] Adicionar curso");
            userInterface.writeMenuOption("[3] Remover curso");
            userInterface.writeMenuOption("[4] Trancar ou ativar conta");
            userInterface.writeMenuOption("[0] Sair");

            int choice = UserInterface.nextInt(scannerObj);

            switch (choice) {
                case 1:
                    currentAluno.listarCursos();
                    break;
                case 2:
                    adicionarCurso();
                    break;
                case 3:
                    userInterface.writeMenuOption("Digite o ID do curso que deseja remover:");
                    int idCurso = UserInterface.nextInt(scannerObj);
                    removerCurso(idCurso);
                    break;
                case 4:
                    currentAluno.trancarOuAtivarConta();
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
        userInterface.writeMenuOption("Aqui será apresentado o menu do Aluno ["+ this.currentAluno.getNome()+"]");
    }

    private void adicionarCurso() {
        userInterface.writeMenuOption("Digite o nome do curso que deseja adicionar:");
        String nomeCurso = UserInterface.getStringInput(scannerObj);
        Curso curso = new Curso(nomeCurso);
        currentAluno.getListaDeCursos().add(curso);
        userInterface.writeMenuOption("Curso adicionado com sucesso!");
    }

    private void removerCurso(int id) {
        if (id >= 0 && id < currentAluno.getListaDeCursos().size()) {
            currentAluno.getListaDeCursos().remove(id);
            userInterface.writeMenuOption("Curso removido com sucesso!");
        } else {
            userInterface.writeMenuOption("ID do curso inválido!");
        }
    }

    public Aluno getExistingAluno() {
        userInterface.writeMenuOption("Digite o nome para o aluno, ou 0 para cancelar:");
        String alunoName = UserInterface.getStringInput(scannerObj);
        if (Objects.equals(alunoName, "0"))
            return null;
        Aluno existingAluno = DadosAlunos.buscarAluno(alunoName);
        if (existingAluno != null)
            return  existingAluno;
        else {
            userInterface.writeMenuOption("O Aluno com nome [" + alunoName + "], não foi encontrado no cadastro.");
            userInterface.writeMenuOption("[1] Tentar novamente ");
            userInterface.writeMenuOption("[2] Cadastrar um novo aluno com nome[" +alunoName+ "]");
            int existingAlunoMenuChoice = UserInterface.nextInt(scannerObj);
            if (existingAlunoMenuChoice == 2)
                return getValidNewAluno(alunoName);
            else
                return getExistingAluno();
        }
    }

    public Aluno getCurrentAluno() {
        return currentAluno;
    }

    public void setCurrentAluno(Aluno currentAluno) {
        this.currentAluno = currentAluno;
    }

}

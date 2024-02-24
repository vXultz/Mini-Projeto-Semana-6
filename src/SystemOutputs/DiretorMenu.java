package SystemOutputs;

import Aluno.Aluno;
import Aluno.DadosAlunos;
import Funcionario.*;
import Turma.Turma;
import Turma.DadosTurma;
import Curso.Curso;

import java.util.Objects;
import java.util.Scanner;

public class DiretorMenu {
    private static UserInterface userInterface;
    private static Scanner scannerObj;
    private Diretor currentDiretor;

    public DiretorMenu(Scanner scannerObj, UserInterface userInterface) {
        this.scannerObj = scannerObj;
        this.userInterface = userInterface;
    }

    public static Diretor addDiretor() {
        Diretor newDiretor = getValidNewDiretor();
        if (newDiretor == null || newDiretor.getTempoDeCargo() == 0)
            return null;
        DadosDiretor.adicionarDiretor(newDiretor);
        return newDiretor;
    }

    private static Diretor getValidNewDiretor() {
        return getValidNewDiretor(null);
    }

    private static Diretor getValidNewDiretor(String DiretorName) {
        if (DiretorName == null || DiretorName.isEmpty()) {
            userInterface.writeMenuOption("Digite o nome para o Diretor, ou 0 para cancelar:");
            DiretorName = UserInterface.getStringInput(scannerObj);
            if (Objects.equals(DiretorName, "0"))
                return null;
        }
        Diretor existingDiretor = DadosDiretor.buscarDiretor(DiretorName);
        if (existingDiretor != null) {
            userInterface.writeMenuOption("O Diretor com nome [" + existingDiretor.getNome() + "], tempo de cargo [" + existingDiretor.getTempoDeCargo() + "] é inválido pois já está cadastrado.");
            userInterface.writeMenuOption("[1] Cadastrar outro Diretor");
            userInterface.writeMenuOption("[2] Usar o Diretor encontrado");
            int existingDiretorMenuChoice = UserInterface.nextInt(scannerObj);
            if (existingDiretorMenuChoice == 2)
                return existingDiretor;
            else
                return getValidNewDiretor();
        } else return new Diretor(DiretorName, getValidDiretorTempoDeCargo());
    }

    private static int getValidDiretorTempoDeCargo() {
        userInterface.writeMenuOption("Digite o tempo de cargo do Diretor em meses, ou [0] para cancelar");
        try {
            return UserInterface.nextInt(scannerObj);
        } catch (Exception e) {
            System.err.println("Houve um erro com o tempo de cargo digitado. Verifique se é um tempo em meses válido.");
            return getValidDiretorTempoDeCargo();
        }
    }

    public void runMainMenu(Diretor loggedDiretor) {
        this.currentDiretor = loggedDiretor;
        boolean exit = false;
        while (!exit) {
            userInterface.writeMenuOption("Aqui será apresentado o menu do Diretor [" + this.currentDiretor.getNome() + "]");
            userInterface.writeMenuOption("[1] Adicionar Aluno");
            userInterface.writeMenuOption("[2] Remover Aluno");
            userInterface.writeMenuOption("[3] Listar Todos Alunos");
            userInterface.writeMenuOption("[4] Adicionar Professor");
            userInterface.writeMenuOption("[5] Remover Professor");
            userInterface.writeMenuOption("[6] Listar Todos Professor");
            userInterface.writeMenuOption("[7] Criar Turma");
            userInterface.writeMenuOption("[8] Adicionar Aluno a Turma");
            userInterface.writeMenuOption("[9] Remover Aluno da Turma");
            userInterface.writeMenuOption("[10] Listar Alunos da Turma");
            userInterface.writeMenuOption("[0] Sair");

            int choice = UserInterface.nextInt(scannerObj);

            switch (choice) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    removerAluno();
                    break;
                case 3:
                    listarAlunos();
                    break;
                case 4:
                    adicionarProfessor();
                    break;
                case 5:
                    removerProfessor();
                    break;
                case 6:
                    listarProfessores();
                    break;
                case 7:
                    criarTurma();
                    break;
                case 8:
                    adicionarAlunoNaTurma();
                    break;
                case 9:
                    removerAlunoDaTurma();
                    break;
                case 10:
                    listarAlunosDaTurma();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    userInterface.writeMenuOption("Opção inválida!");
            }
        }
    }

    private void runMainMenu() {
        userInterface.writeMenuOption("Aqui será apresentado o menu do Diretor [" + this.currentDiretor.getNome() + "]");
    }

    public void promoverProfessor() {
        userInterface.writeMenuOption("Promover Professor:");
        Professor professor = ProfessorMenu.getExistingProfessor();
        if (professor != null) {
            professor.promover();
            DadosProfessor.adicionarProfessor(professor);
        }
    }

    public void listarAlunos() {
        DadosAlunos.mostrarAlunosListados();
    }

    public void adicionarAluno() {
        userInterface.writeMenuOption("Adicionar Aluno:");
        Aluno aluno = criarAluno();
        DadosAlunos.adicionarAluno(aluno);
    }

    public void removerAluno() {
        DadosAlunos.mostrarAlunosListados();
        userInterface.writeMenuOption("Digite o ID do Aluno a ser removido:");
        int id = UserInterface.nextInt(scannerObj);
        DadosAlunos.removerAluno(id);
    }

    private Aluno criarAluno() {
        userInterface.writeMenuOption("Digite o nome do Aluno:");
        String nome = UserInterface.getStringInput(scannerObj);
        userInterface.writeMenuOption("Digite a idade do Aluno:");
        int idade = UserInterface.nextInt(scannerObj);

        return new Aluno(nome, idade);
    }

    public void listarProfessores() {
        DadosProfessor.mostrarProfessoresListados();
    }

    public void adicionarProfessor() {
        userInterface.writeMenuOption("Adicionar Professor:");
        Professor professor = criarProfessor();
        DadosProfessor.adicionarProfessor(professor);
    }

    public void removerProfessor() {
        DadosProfessor.mostrarProfessoresListados();
        userInterface.writeMenuOption("Digite o ID do Professor a ser removido:");
        int id = UserInterface.nextInt(scannerObj);
        DadosProfessor.removerProfessor(id);
    }

    private Professor criarProfessor() {
        userInterface.writeMenuOption("Digite o nome do Professor:");
        String nome = UserInterface.getStringInput(scannerObj);
        userInterface.writeMenuOption("Digite a idade do Professor:");
        int idade = UserInterface.nextInt(scannerObj);
        userInterface.writeMenuOption("Digite o salário do Professor:");
        double salario = UserInterface.getDoubleInput(scannerObj);
        userInterface.writeMenuOption("Digite o tempo de cargo do Professor:");
        int tempoDeCargo = UserInterface.nextInt(scannerObj);
        userInterface.writeMenuOption("Digite o nível de cargo do Professor (INICIANTE, EXPERIENTE, AVANCADO):");
        String cargoInput = UserInterface.getStringInput(scannerObj);
        EnumCargoFuncionario cargo = EnumCargoFuncionario.valueOf(cargoInput.toUpperCase());

        return new Professor(nome, salario, tempoDeCargo, cargo, idade);
    }

    public void criarTurma() {
        userInterface.writeMenuOption("Criar Turma:");
        userInterface.writeMenuOption("Digite o ano da turma:");
        int ano = UserInterface.nextInt(scannerObj);
        userInterface.writeMenuOption("Digite o nome do curso:");
        String nomeCurso = UserInterface.getStringInput(scannerObj);
        Curso curso = new Curso(nomeCurso);
        userInterface.writeMenuOption("Selecione o professor para a turma:");
        Professor professorSelecionado = selecionarProfessorExistente();

        if (professorSelecionado != null) {
            Turma turma = new Turma(ano, curso);
            turma.setProfessor(professorSelecionado);
            DadosTurma.adicionarTurma(turma);
            userInterface.writeMenuOption("Turma criada com sucesso!");
        } else {
            userInterface.writeMenuOption("Nenhum professor selecionado. A turma não foi criada.");
        }
    }

    private Professor selecionarProfessorExistente() {
        DadosProfessor.mostrarProfessoresListados();
        userInterface.writeMenuOption("Digite o ID do professor:");
        int idProfessor = UserInterface.nextInt(scannerObj);
        return DadosProfessor.buscarProfessor(idProfessor);
    }

    public void adicionarAlunoNaTurma() {
        userInterface.writeMenuOption("Adicionar Aluno na Turma:");

        userInterface.writeMenuOption("Digite o nome do aluno:");
        String nomeAluno = UserInterface.getStringInput(scannerObj);

        Aluno aluno = DadosAlunos.buscarAluno(nomeAluno);
        if (aluno != null) {
            DadosTurma.mostrarTurmasListadas();

            userInterface.writeMenuOption("Digite o índice da turma:");
            int indiceTurma = UserInterface.nextInt(scannerObj);

            Turma turma = DadosTurma.buscarTurmaPorIndice(indiceTurma);
            if (turma != null) {
                turma.adicionarAluno(aluno);
                userInterface.writeMenuOption("Aluno adicionado na turma com sucesso!");
            } else {
                userInterface.writeMenuOption("Turma não encontrada.");
            }
        } else {
            userInterface.writeMenuOption("Aluno não encontrado.");
        }
    }

    public void removerAlunoDaTurma() {
        userInterface.writeMenuOption("Remover Aluno da Turma:");

        userInterface.writeMenuOption("Digite o nome do aluno:");
        String nomeAluno = UserInterface.getStringInput(scannerObj);

        Aluno aluno = DadosAlunos.buscarAluno(nomeAluno);
        if (aluno != null) {
            DadosTurma.mostrarTurmasListadas();

            userInterface.writeMenuOption("Digite o índice da turma:");
            int indiceTurma = UserInterface.nextInt(scannerObj);

            Turma turma = DadosTurma.buscarTurmaPorIndice(indiceTurma);
            if (turma != null) {
                turma.removerAluno(aluno);
                userInterface.writeMenuOption("Aluno removido da turma com sucesso!");
            } else {
                userInterface.writeMenuOption("Turma não encontrada.");
            }
        } else {
            userInterface.writeMenuOption("Aluno não encontrado.");
        }
    }

    public void listarAlunosDaTurma() {
        userInterface.writeMenuOption("Listar Alunos da Turma:");

        DadosTurma.mostrarTurmasListadas();

        userInterface.writeMenuOption("Digite o índice da turma:");
        int indiceTurma = UserInterface.nextInt(scannerObj);

        Turma turma = DadosTurma.buscarTurmaPorIndice(indiceTurma);
        if (turma != null) {
            turma.listarAlunos();
        } else {
            userInterface.writeMenuOption("Turma não encontrada.");
        }
    }

    public Diretor getExistingDiretor() {
        userInterface.writeMenuOption("Digite o nome para o Diretor, ou 0 para cancelar:");
        String diretorName = UserInterface.getStringInput(scannerObj);
        if (Objects.equals(diretorName, "0"))
            return null;
        Diretor existingDiretor = DadosDiretor.buscarDiretor(diretorName);
        if (existingDiretor != null)
            return existingDiretor;
        else {
            userInterface.writeMenuOption("Nenhum Diretor com nome [" + diretorName + "], não foi encontrado no cadastro.");
            userInterface.writeMenuOption("[1] Tentar novamente ");
            userInterface.writeMenuOption("[2] Cadastrar novo Diretor com nome[" + diretorName + "]");
            int existingAlunoMenuChoice = UserInterface.nextInt(scannerObj);
            if (existingAlunoMenuChoice == 2)
                return getValidNewDiretor(diretorName);
            else
                return getExistingDiretor();
        }
    }

    public Diretor getCurrentDiretor() {
        return currentDiretor;
    }

    public void setCurrentDiretor(Diretor currentDiretor) {
        this.currentDiretor = currentDiretor;
    }
}

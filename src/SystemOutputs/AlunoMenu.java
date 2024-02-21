package SystemOutputs;

import java.util.Objects;
import java.util.Scanner;
import Aluno.Aluno;
import Aluno.DadosAlunos;

public class AlunoMenu {
    private UserInterface userInterface;
    private Scanner scannerObj;
    private Aluno currentAluno;

    public AlunoMenu(Scanner scannerObj, UserInterface userInterface) {
        this.scannerObj = scannerObj;
        this.userInterface = userInterface;
    }
    //construtor para quando o aluno já estiver selecionado anteriormente
    public AlunoMenu(Scanner scannerObj, UserInterface userInterface, Aluno aluno) {
        this.scannerObj = scannerObj;
        this.userInterface = userInterface;
        this.currentAluno = aluno;
    }

    public Aluno addAluno(){
        Aluno newAluno = getValidNewAluno();
        if (newAluno == null || newAluno.getIdade() == 0)
            return null;
        DadosAlunos.adicionarAluno(newAluno);
        this.currentAluno = newAluno;
        return newAluno;
    }

    private Aluno getValidNewAluno() {
        userInterface.writeMenuOption("Digite o nome para o aluno, ou 0 para cancelar:");
        String alunoName = UserInterface.getStringInput(scannerObj);
        if (Objects.equals(alunoName, "0"))
            return null;
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

    public void runMainMenu() {
        userInterface.writeMenuOption("Aqui será apresentado o menu do Aluno ["+ this.currentAluno.getNome()+"]");
    }
}

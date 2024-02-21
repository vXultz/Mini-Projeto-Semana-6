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

    public void runMainMenu(Aluno currentAluno) {
        this.currentAluno = currentAluno;
        this.runMainMenu();
    }

    private void runMainMenu(){
        userInterface.writeMenuOption("Aqui será apresentado o menu do Aluno ["+ this.currentAluno.getNome()+"]");
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

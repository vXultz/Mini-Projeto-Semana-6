package SystemOutputs;

import java.util.Scanner;
import Aluno.Aluno;
import Aluno.DadosAlunos;

public class AlunoMenu {
    private UserInterface userInterface;
    private Scanner scannerObj;

    public AlunoMenu(Scanner scannerObj, UserInterface userInterface) {
        this.scannerObj = scannerObj;
        this.userInterface = userInterface;
    }

    public Aluno addAluno(){
        Aluno response = null;
        String nomeAluno = getValidAlunoName();
        int idadeAluno = getValidAlunoIdade();
        response = new Aluno(nomeAluno, idadeAluno);
        return response;
    }

    private String getValidAlunoName() {
        userInterface.writeMenuOption("Digite o nome para o aluno, ou 0 para cancelar:");
        String alunoName = userInterface.getStringInput(scannerObj);
        Aluno existingAluno = DadosAlunos.buscarAluno(alunoName);
        return "Zé";
    }

    private int getValidAlunoIdade() {
        return 18;
    }
}

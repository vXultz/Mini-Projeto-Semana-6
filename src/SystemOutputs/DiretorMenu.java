package SystemOutputs;

import Funcionario.DadosDiretor;
import Funcionario.Diretor;

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
        } else return new Diretor(DiretorName,getValidDiretorTempoDeCargo());
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
        this.runMainMenu();
    }
    private void runMainMenu(){
        userInterface.writeMenuOption("Aqui será apresentado o menu do Diretor ["+ this.currentDiretor.getNome()+"]");
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

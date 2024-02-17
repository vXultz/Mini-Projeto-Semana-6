package Testes;

import Funcionario.EnumCargoFuncionario;
import SystemOutputs.UserInterface;

public class TestesFuncionario {

    private final UserInterface userInterface;

    public TestesFuncionario(UserInterface userInterface) {
        this.userInterface = userInterface;
    }


    public void listEnumCargoFuncionario(){
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("Teste de .values() do Enum Cargo de Funcionário");
        for (EnumCargoFuncionario cargoFuncionario : EnumCargoFuncionario.values()){
            userInterface.writeMenuOption("Opção [" + cargoFuncionario.name()+ "], formatado para impresão:  ["+ cargoFuncionario.getFormatedValue() +"], Nível ["+ cargoFuncionario.getLevel() +"]");

        }
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("Teste de .valuesOf() do Enum Cargo de Funcionário");
        userInterface.writeMenuOption("Opção [EXPERIENTE] tem o formato para impressão: ["+ EnumCargoFuncionario.valueOf("EXPERIENTE").getFormatedValue() +"], Nivel ["+ EnumCargoFuncionario.valueOf("EXPERIENTE").getLevel()+"]");
        userInterface.writeMenuOption("Nivel [3] corresponde ao status ["+ EnumCargoFuncionario.getCargoByLevel(3) +"]");
    }
}


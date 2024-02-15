import Funcionario.EnumCargoFuncionario;

public class Diretor extends Funcionario {


    public Diretor(String nome, double salario, int tempoDeCargo, EnumCargoFuncionario cargo){
        super(nome, salario, tempoDeCargo, cargo);
    }

    public Diretor(String nome, int tempoDeCargo){
        super(nome, tempoDeCargo);
    }
}

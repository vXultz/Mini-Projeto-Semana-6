package Funcionario;

public class Diretor extends Funcionario {

    public Diretor(String nome, double salario, int tempoDeCargo, EnumCargoFuncionario cargo){
        super(nome, salario, tempoDeCargo, cargo);
    }

    public Diretor(String nome, int tempoDeCargo){
        super(nome, tempoDeCargo);
    }
    @Override
    public String toString(){
        return "Nome: " + getNome() + "/" + "Salário: " + getSalario() +
                "/" + "Cargo: " + getCargo() + "Tempo de cargo: " + getTempoDeCargo();
    }
}
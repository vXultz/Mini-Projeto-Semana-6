package Funcionario;

public class Diretor extends Funcionario {

    public Diretor(String nome, double salario, int tempoDeCargo, EnumCargoFuncionario cargo){
        super(nome, salario, tempoDeCargo, cargo);
        DadosDiretor.adicionarDiretor(this);
    }

    public Diretor(String nome, int tempoDeCargo){
        super(nome, tempoDeCargo);
        DadosDiretor.adicionarDiretor(this);
    }
    @Override
    public String toString(){
        return "Nome: " + getNome() + "\nSalário: " + getSalario() +
                "\nCargo: " + getCargo() + "\nTempo de cargo: " + getTempoDeCargo();
    }
}
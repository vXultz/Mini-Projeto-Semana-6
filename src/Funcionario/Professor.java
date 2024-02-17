package Funcionario;

public class Professor extends Funcionario {
    private int idade;

    public Professor(String nome, double salario, int tempoDeCargo, EnumCargoFuncionario cargo , int idade) {
        super(nome, salario, tempoDeCargo, cargo);
        this.idade = idade;
    }

    public Professor(String nome, int tempoDeCargo, int idade){
        super(nome, tempoDeCargo);
        this.idade = idade;
    }

    @Override
    public String toString(){
        return "Nome: " + getNome() + "/" + "Idade: " + idade +
                "/" + "Salário" + getSalario() +
                "/" + "Tempo de cargo: " + getTempoDeCargo() +
                "/" + "Cargo: " + getCargo();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
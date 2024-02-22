package Funcionario;

public class Professor extends Funcionario {
    private int idade;

    public Professor(String nome, double salario, int tempoDeCargo, EnumCargoFuncionario cargo , int idade) {
        super(nome, salario, tempoDeCargo, cargo);
        this.idade = idade;
        //Removido pois impede que a classe seja instanciada em
        // objetos temporários, ou que não concluam o processo de cadastro
        //DadosProfessor.adicionarProfessores(this);
    }

    public Professor(String nome, int tempoDeCargo, int idade){
        super(nome, tempoDeCargo);
        this.idade = idade;
        //Removido pois impede que a classe seja instanciada em
        // objetos temporários, ou que não concluam o processo de cadastro
        //DadosProfessor.adicionarProfessores(this);
    }

    @Override
    public String toString(){
        return "Nome: " + getNome() + "\nIdade: " + idade +
                "\nSalário" + getSalario() +
                "\nTempo de cargo: " + getTempoDeCargo() +
                "\nCargo: " + getCargo();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
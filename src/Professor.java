class Professor extends Funcionario {
    private int idade;

    public Professor(String nome, double salario, int tempoDeCargo, CargoDoFuncionario cargo , int idade) {
        super(nome, salario, tempoDeCargo, cargo);
        this.idade = idade;
    }

    public Professor(String nome, int tempoDeCargo, int idade){
        super(nome, tempoDeCargo);
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}




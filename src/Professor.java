class Professor extends Funcionario {
    private int idade;

    public Professor(String nome, double salario, int idade) {
        super(nome, salario);
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}




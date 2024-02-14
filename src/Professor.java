class Professor {
    private String nome;
    private int idade;
    private int tempoDeTrabalho;

    public Professor(String nome, int idade, int tempoDeTrabalho) {
        this.nome = nome;
        this.idade = idade;
        this.tempoDeTrabalho = tempoDeTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getTempoDeTrabalho() {
        return tempoDeTrabalho;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setTempoDeTrabalho(int tempoDeTrabalho) {
        this.tempoDeTrabalho = tempoDeTrabalho;
    }
}




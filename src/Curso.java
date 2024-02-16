class Curso {
    private String nome;
    private Professor professor;

    @Override
    public String toString(){
        return "Curso: " + nome + "/" + "Lecionado por: " + professor.getNome();
    }

    public Curso(String nome) {
        this.nome = nome;
    }
    public Curso(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}

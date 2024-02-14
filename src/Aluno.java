import java.util.ArrayList;
import java.util.List;

class Aluno {

    // atributos
    private String nome;
    private int idade;
    private List<Curso> listaDeCursos = new ArrayList<>();


    // construtores
    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.listaDeCursos = new ArrayList<>();
    }

//    public Aluno(String nome, int idade, Turma turmaSelecionada) {
//        this.nome = nome;
//        this.idade = idade;
//        this.listaDeCursos = new ArrayList<>();
//        this.turmaSelecionada = turmaSelecionada;
//    }

    // métodos
    public void listarCursos() {
        if (listaDeCursos.isEmpty()) {
            System.out.println(nome + " não está matriculado em nenhum curso.");
        } else {
            System.out.println("Cursos matriculados:");
            for (Curso curso : listaDeCursos) {
                System.out.println(curso.getNome());
            }
        }
    }

    // getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Curso> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(ArrayList<Curso> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

    public void setListaDeCursos(List<Curso> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

}
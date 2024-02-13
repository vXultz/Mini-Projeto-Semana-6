import java.util.ArrayList;

class Aluno {

    // atributos
    private String nome;
    private int idade;
    private ArrayList<String> listaDeCursos;


    // construtor
    public Aluno(String nome, int idade, ArrayList<String> listaDeCursos) {
        this.nome = nome;
        this.idade = idade;
        this.listaDeCursos = listaDeCursos;
    }

    // métodos
    public void listarCursos() {
        if (listaDeCursos.isEmpty()) {
            System.out.println(nome + " não está matriculado em nenhum curso.");
        } else {
            System.out.println("Cursos matriculados:");
            for (String curso : listaDeCursos) {
                System.out.println(curso);
            }
        }
    }

    public void adicionarCurso(String curso) {
        listaDeCursos.add(curso);
        System.out.println("Parabéns! Você se matriculou no curso: " + curso);
    }

    public void removerCurso(String curso) {
        if (listaDeCursos.remove(curso)) {
            System.out.println("Matrícula no curso " + curso + " cancelada!");
        } else {
            System.out.println("Você não está matriculado no curso " + curso);
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

    public ArrayList<String> getListaDeCursos() {
        return listaDeCursos;
    }

    public void setListaDeCursos(ArrayList<String> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }
}
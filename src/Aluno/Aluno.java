package Aluno;

import Curso.Curso;
import java.util.ArrayList;
import java.util.List;

public class Aluno {

    // atributos
    private String nome;
    private int idade;
    private List<Curso> listaDeCursos = new ArrayList<>();
    private EnumStatusMatricula statusMatricula;


    // construtores
    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.listaDeCursos = new ArrayList<>();
        //Removido pois impossibilita o uso da classe Aluno sem automaticamente adiciona-lo à lista do sistema
        //Haverão ocasiões em que precisamos criar um aluno temporário, sem necessáriamente adicionar a lista do sistema.
        //DadosAlunos.adicionarAluno(this);
    }

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

    @Override
    public String toString(){
        return "Nome: " + nome + "\nIdade: " + idade +
                "\nLista de curso(s)" + listaDeCursos +
                "\nStatus da matrícula" + statusMatricula;
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

    public void setListaDeCursos(List<Curso> listaDeCursos) {
        this.listaDeCursos = listaDeCursos;
    }

    public EnumStatusMatricula getStatusMatricula() {
        return statusMatricula;
    }
    public String getStatusMatricula(boolean sigla) {
        return statusMatricula.getSigla();
    }

    public void setStatusMatricula(EnumStatusMatricula statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    public void setStatusMatriculaBySigla(String sigla) {
        try {
            setStatusMatricula(EnumStatusMatricula.getStatusBySigla(sigla));
        } catch (Exception e) {
            System.err.println("Status de matrícula inválido");
        }
    }
}
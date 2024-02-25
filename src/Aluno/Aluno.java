package Aluno;

import Curso.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno {
    Scanner entrada = new Scanner(System.in);

    // atributos
    private String nome;
    private int idade;
    private List<Curso> listaDeCursos;
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
            for (int i = 0; i < listaDeCursos.size(); i++) {
                System.out.println("ID: " + i + ", Nome do curso: " + listaDeCursos.get(i).getNome());
            }
        }
    }

    public void trancarOuAtivarConta() {
        System.out.println("Digite 'A' para ativar ou 'T' para trancar a conta:");
        String opcao = entrada.nextLine();
        if (opcao.equalsIgnoreCase("A")) {
            setStatusMatricula(EnumStatusMatricula.ATIVO);
            System.out.println("Conta ativada com sucesso!");
        } else if (opcao.equalsIgnoreCase("T")) {
            setStatusMatricula(EnumStatusMatricula.TRANCADO);
            System.out.println("Conta trancada com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\nIdade: " + idade +
                "\nLista de curso(s)" + listaDeCursos +
                "\nStatus da matrícula" + statusMatricula;
    }

    public void removerCurso(String nomeCurso) {
        listaDeCursos.removeIf(curso -> curso.getNome().equalsIgnoreCase(nomeCurso));
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
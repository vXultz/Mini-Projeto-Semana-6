package Aluno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DadosAlunos {

    private static List<Aluno> listaDeAlunosTotal = new ArrayList<>();


    public static void adicionarAluno(Aluno aluno) {
        listaDeAlunosTotal.add(aluno);
    }

    public static void removerAluno(int id) {
        try {
            listaDeAlunosTotal.remove(id);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao remover aluno: " + e.getMessage());
        }
    }

    public static Aluno buscarAluno(int id) {
        try {
            return listaDeAlunosTotal.get(id);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
            return null;
        }
    }
    public static Aluno buscarAluno(String alunoName) {
        try {
            return listaDeAlunosTotal.stream().filter(value );
            Arrays.stream(values())
                    .filter(value -> value.getSigla().equals(sigla))
                    .findFirst()
                    .orElseThrow();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
            return null;
        }
    }
}

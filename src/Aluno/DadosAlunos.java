package Aluno;

import java.util.ArrayList;
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
}

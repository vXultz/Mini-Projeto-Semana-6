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
            if (id >= 0 && id < listaDeAlunosTotal.size()) {
                listaDeAlunosTotal.remove(id);
            } else {
                throw new IndexOutOfBoundsException("ID inválido. Não existe nenhum aluno com o ID informado.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao remover aluno: " + e.getMessage());
        }
    }

    public static void buscarAluno(int id) {
        try {
            Aluno alunoEncontrado = listaDeAlunosTotal.get(id);
            System.out.println(alunoEncontrado);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
        }
    }
}

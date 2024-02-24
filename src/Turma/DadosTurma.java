package Turma;


import Aluno.Aluno;

import java.util.ArrayList;
import java.util.List;

public class DadosTurma {

    private static List<Turma> listaDeTurmas = new ArrayList<>();

    public static void adicionarTurma(Turma turma) {
        listaDeTurmas.add(turma);
    }

    public static void mostrarTurmasListadas() {
        if (listaDeTurmas.isEmpty()) {
            System.out.println("Não há nenhuma turma listada.");
        } else {
            System.out.println("Turmas listadas:");
            for (int i = 0; i < listaDeTurmas.size(); i++) {
                System.out.println("\nID: " + i + " - " + listaDeTurmas.get(i).getCurso().getNome());
            }
        }
    }

    public static Turma buscarTurmaPorIndice(int indice) {
        if (indice >= 0 && indice < listaDeTurmas.size()) {
            return listaDeTurmas.get(indice);
        } else {
            System.out.println("Índice da turma inválido.");
            return null;
        }
    }

    public static void adicionarAlunoEmCursoDisponivel(int id, Aluno aluno) {
        try {
            Turma turmaDisponivelEncontrada = listaDeTurmas.get(id);
            turmaDisponivelEncontrada.adicionarAluno(aluno);
            System.out.println("Aluno matriculado com sucesso");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esse ID não pertence a nenhum curso listado.");

        }
    }
}

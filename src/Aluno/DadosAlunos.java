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
            Aluno response = listaDeAlunosTotal.stream() // transforma a lista de alunos em um stream,
                    .filter(aluno -> alunoName.equalsIgnoreCase(aluno.getNome())) //percorre o stream comparando o param alunoName com o método getName() de cada item
                    .findFirst() // retornando o item se encontrar
                    .orElse(null); //retorna null se não encontrar;
            return response;
        } catch (Exception e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
            return null;
        }
    }

    public static void mostrarAlunosListados() {
        if(listaDeAlunosTotal.isEmpty()){
            System.out.println("Não há nenhum aluno listado.");
        } else {
            System.out.println("Alunos listados:");
            for(int i = 0; i < listaDeAlunosTotal.size(); i++){
                System.out.println("\nID: " + i + "\n" + listaDeAlunosTotal.get(i));
            }
        }
    }

}

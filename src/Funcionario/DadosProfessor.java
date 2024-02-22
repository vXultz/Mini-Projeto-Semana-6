package Funcionario;

import Aluno.Aluno;

import java.util.ArrayList;
import java.util.List;

public class DadosProfessor {
    private static List<Professor> listaDeProfessores = new ArrayList<>();

    public static void adicionarProfessor(Professor professor) {
        listaDeProfessores.add(professor);
    }

    public static Professor removerProfessor (int id) {
        try {
            Professor professorRemovido = listaDeProfessores.remove(id);
            System.out.println("Professor removido com sucesso.");
            return professorRemovido;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esse ID não pertence a nenhum professor listado.");
            return null;
        }

    }

    public static Professor buscarProfessor (int id) {
        try {
            Professor professorEncontrado = listaDeProfessores.get(id);
            System.out.println("ID: " + id + "\n" + professorEncontrado);
            return professorEncontrado;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esse ID não pertence a nenhum professor listado.");
            return null;
        }
    }
    public static Professor buscarProfessor(String professorName) {
        try {
            Professor response = listaDeProfessores.stream() // transforma a lista de professores em um stream,
                    .filter(professor -> professorName.equalsIgnoreCase(professor.getNome())) //percorre o stream comparando o param professorName com o método getName() de cada item
                    .findFirst() // retornando o item se encontrar
                    .orElse(null); //retorna null se não encontrar;
            return response;
        } catch (Exception e) {
            System.out.println("Erro ao buscar professor: " + e.getMessage());
            return null;
        }
    }

    public static void mostrarProfessoresListados() {
        if(listaDeProfessores.isEmpty()){
            System.out.println("Não há nenhum professor listado.");
        } else {
            System.out.println("Professores listados:");
            for(int i = 0; i < listaDeProfessores.size(); i++){
                System.out.println("\nID: " + i + "\n" + listaDeProfessores.get(i));
            }
        }
    }

}

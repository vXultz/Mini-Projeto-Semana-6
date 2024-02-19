package Funcionario;

import java.util.ArrayList;
import java.util.List;

public class DadosProfessor {
    private static List<Professor> listaDeProfessores = new ArrayList<>();

    public void adicionarProfessores(Professor professor) {
        listaDeProfessores.add(professor);
    }

    public static void removerProfessores (int id) {
        try {
            listaDeProfessores.remove(id);
            System.out.println("Professor removido com sucesso.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esse ID não pertence a nenhum professor listado.");
        }

    }

    public static void bucarProfessor (int id) {
        try {
            Professor professorEncontrado = listaDeProfessores.get(id);
            System.out.println("ID: " + id + "\n" + professorEncontrado);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esse ID não pertence a nenhum professor listado.");
        }
    }

}

package Funcionario;

import java.util.ArrayList;
import java.util.List;

public class DadosProfessor {
    private static List<Professor> listaDeProfessores = new ArrayList<>();

    public static void adicionarProfessores(Professor professor) {
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

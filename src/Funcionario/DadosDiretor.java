package Funcionario;

import java.util.List;
import java.util.ArrayList;

public class DadosDiretor {

    private static List<Diretor> listaDiretor = new ArrayList<>();

    public static void adicionarDiretor(Diretor diretor) {
        listaDiretor.add(diretor);
    }
    // o metodo adicionarDiretor() é chamado dentro do bloco de construtor da classe Diretor
    // sempre que um Diretor for instanciado, é adicionado a listaDiretor


    public static Diretor removerDiretor(int id) {
        try {
            Diretor diretorRemovido = listaDiretor.remove(id);
            System.out.println("Diretor removido da lista!");
            return diretorRemovido;

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esse ID não pertence a nenhum diretor listado");
            return null;
        }

    }

    public static Diretor buscaDiretor(int id) {
        try {
            Diretor diretorEncontrado = listaDiretor.get(id);
            System.out.println("ID: " + id + "\n" + diretorEncontrado);
            return diretorEncontrado;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esse ID não pertence a nenhum diretor listado");
            return null;
        }
    }

    public static void mostrarDiretoresListados() {
        if (listaDiretor.isEmpty()) {
            System.out.println("Não há nenhum diretor listado.");
        } else {
            System.out.println("Diretores Listados:");
            for(int i = 0; i < listaDiretor.size(); i++){
                System.out.println("\nID: " + i + "\n" + listaDiretor.get(i));
            }
        }
    }


}
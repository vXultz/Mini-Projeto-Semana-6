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

    public static void removerDiretor(int id) {
        try {
            listaDiretor.remove(id);
            System.out.println("Diretor removido da lista!");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esse ID não pertence a nenhum diretor listado");
        }

    }

    public static void buscaDiretor(int id) {
        try {
            Diretor diretorEncontrado = listaDiretor.get(id);
            System.out.println(diretorEncontrado);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Esse ID não pertence a nenhum diretor listado");
        }
    }

    public static void mostrarDiretoresListados() {
        if (listaDiretor.isEmpty()) {
            System.out.println("Não há nenhum diretor listado.");
        } else {
            System.out.println("Diretores Listados:");
            for (Diretor diretor : listaDiretor) {
                System.out.println(diretor.getNome());
            }
        }
    }


}

package Aluno;

import java.util.ArrayList;
import java.util.List;

public class DadosAlunos{

    private List<Aluno> listaDeAlunosTotal;

    public DadosAlunos() {
        this.listaDeAlunosTotal = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        listaDeAlunosTotal.add(aluno);
    }

    public void removerAluno(int id) {
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

    public Aluno buscarAluno(int id) {
        try {
            if (id >= 0 && id < listaDeAlunosTotal.size()) {
                return listaDeAlunosTotal.get(id);
            } else {
                throw new IndexOutOfBoundsException("ID inválido. Não existe nenhum aluno com o ID informado.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
            return null;
        }
    }
}

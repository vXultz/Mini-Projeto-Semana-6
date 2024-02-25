package Testes;

import Aluno.Aluno;
import Aluno.EnumStatusMatricula;
import Curso.Curso;
import SystemOutputs.UserInterface;
import Turma.Turma;

import java.util.List;
import java.util.Random;

public class TestesAluno {

    private final UserInterface userInterface;

    public TestesAluno(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public Aluno criarAluno(String nome, int idade){
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("====== Teste de Criação do Aluno com parâmetros  ====== ");
        Aluno aluno = new Aluno(nome, idade);
        userInterface.writeMenuOption("Aluno ["+ aluno.getNome() +"], idade ["+ aluno.getIdade() +"] criado com sucesso");
        return aluno;
    }
    public Aluno criarAluno(){
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("====== Teste de Criação do Aluno com overload  ====== ");
        Random rand = new Random();
        Aluno aluno = new Aluno("Aluno teste nº "+ rand.nextInt(99) , rand.nextInt(99));
        userInterface.writeMenuOption("Aluno ["+ aluno.getNome() +"], idade ["+ aluno.getIdade() +"] criado com sucesso");
        return aluno;
    }

    public List<Curso> matricularAluno(Aluno aluno, Curso curso){
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("====== Teste de Matricula do Aluno ====== ");
        Turma turma = new Turma(2024, curso);
        turma.adicionarAluno(aluno);
        userInterface.writeMenuOption("Aluno ["+ aluno.getNome() +"], idade ["+ aluno.getIdade() +"] matriculado com sucesso.");
        userInterface.writeMenuOption(" Lista de cursos:");
        for (Curso cursoAluno: aluno.getListaDeCursos() ) {
            userInterface.writeMenuOption("Curso ["+ cursoAluno.getNome()+"] Professor [" + cursoAluno.getProfessor().getNome() +"]");
        }
        return aluno.getListaDeCursos();
    }

    public void listEnumStatusMatricula(Aluno aluno){
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("Teste de .values() do Enum Status de Matricula");
        for (EnumStatusMatricula statusMatricula : EnumStatusMatricula.values()){
            userInterface.writeMenuOption("Opção [" + statusMatricula.name()+ "] sigla ["+ statusMatricula.getSigla() +"]");

        }
        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("Teste de .valuesOf() do Enum Status de Matricula");
        userInterface.writeMenuOption("Opção [ATIVO] corresponde a sigla ["+ EnumStatusMatricula.valueOf("ATIVO").getSigla() +"]");
        userInterface.writeMenuOption("Sigla [" + EnumStatusMatricula.valueOf("FORMADO").getSigla() +"] corresponde ao status [FORMADO]");
        userInterface.writeMenuOption("Status [" + EnumStatusMatricula.getStatusBySigla("T").name() + "] corresponde a sigla [T]");

        userInterface.writeMenuOption("");
        userInterface.writeMenuOption("Teste de Try Catch com levantamento de exceção do Enum Status de Matricula");
        aluno.setStatusMatriculaBySigla("G");
        userInterface.writeMenuOption("Teste de Try Catch Finalizado");

    }
}

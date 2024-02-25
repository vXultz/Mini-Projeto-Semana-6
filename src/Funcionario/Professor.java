package Funcionario;

import Aluno.Aluno;
import Turma.Turma;

public class Professor extends Funcionario {
    private int idade;
    private Turma turma;

    public Professor(String nome, double salario, int tempoDeCargo, EnumCargoFuncionario cargo , int idade) {
        super(nome, salario, tempoDeCargo, cargo);
        this.idade = idade;
        //Removido pois impede que a classe seja instanciada em
        // objetos temporários, ou que não concluam o processo de cadastro
        //DadosProfessor.adicionarProfessores(this);
    }

    public Professor(String nome, int tempoDeCargo, int idade){
        super(nome, tempoDeCargo);
        this.idade = idade;
        //Removido pois impede que a classe seja instanciada em
        // objetos temporários, ou que não concluam o processo de cadastro
        //DadosProfessor.adicionarProfessores(this);
    }

    @Override
    public String toString(){
        return "Nome: " + getNome() + "\nIdade: " + idade +
                "\nSalário" + getSalario() +
                "\nTempo de cargo: " + getTempoDeCargo() +
                "\nCargo: " + getCargo();
    }

    public void listarAlunosTurma() {
        if (turma != null) {
            turma.listarAlunos();
        } else {
            System.out.println("O professor " + getNome() + " não tem uma turma atribuída.");
        }
    }

    public void adicionarAlunoTurma(Aluno aluno) {
        if (turma != null) {
            turma.adicionarAluno(aluno);
            System.out.println("Aluno adicionado à turma do professor " + getNome() + " com sucesso.");
        } else {
            System.out.println("O professor " + getNome() + " não tem uma turma atribuída.");
        }
    }

    public void removerAlunoTurma(Aluno aluno) {
        if (turma != null) {
            turma.removerAluno(aluno);
            System.out.println("Aluno removido da turma do professor " + getNome() + " com sucesso.");
        } else {
            System.out.println("O professor " + getNome() + " não tem uma turma atribuída.");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
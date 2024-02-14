import java.util.ArrayList;
import java.util.List;
public class Turma {
    private List<Aluno> listaDeAlunos;
    private int ano;
    private Curso curso;

    public Turma(int ano, Curso curso){
        this.ano = ano;
        this.curso = curso;
        this.listaDeAlunos = new ArrayList<>();
    }

    public void listarAlunos(){
        for(int i = 0; i < this.listaDeAlunos.size(); i++){
            System.out.println(this.listaDeAlunos.get(i).getNome());
        }
    }

    public void adicionarAluno(Aluno aluno){
        listaDeAlunos.add(aluno);
        aluno.getListaDeCursos().add(curso);
    }

    public void removerAluno(Aluno aluno) {
        listaDeAlunos.remove(aluno);
        aluno.getListaDeCursos().remove(curso);
    }

    public void removerAluno(int indiceAluno){
        if(indiceAluno >= 0 && indiceAluno < listaDeAlunos.size()){
            Aluno alunoRemovido = listaDeAlunos.remove(indiceAluno);
            alunoRemovido.getListaDeCursos().remove(curso);
        } else {
            System.out.println("Indice não encontrado");
        }
    }

    public List<Aluno> getListaDeAlunos() {
        return listaDeAlunos;
    }


    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}

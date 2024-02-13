import java.util.List;
public class Turma {
    public List<Aluno> listaDeAlunos;
    public int ano;
    public Curso curso;

    public void listarAlunos(){
        for(int i = 0; i < this.listaDeAlunos.size(); i++){
            System.out.println(this.listaDeAlunos.get(i).nome);
        }
    }

    public void adicionarAluno(Aluno aluno){
        listaDeAlunos.add(aluno);
    }

    public void removerAluno(int indiceAluno){
        if(indiceAluno >= 0 && indiceAluno < listaDeAlunos.size()){
            listaDeAlunos.remove(indiceAluno);
        } else {
            System.out.println("Indice não encontrado");
        }
    }
}

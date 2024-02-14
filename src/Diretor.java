public class Diretor extends Funcionario {

    private int tempoDeCargo;

    public Diretor(String nome, double salario){
        super(nome, salario);
    }

    public int getTempoDeCargo() {
        return tempoDeCargo;
    }

    public void setTempoDeCargo(int tempoDeCargo) {
        this.tempoDeCargo = tempoDeCargo;
    }
}

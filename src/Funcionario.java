public class Funcionario implements InterfaceFuncionario{

    private String nome;
    private double salario;
    private int tempoDeCargo;
    private CargoDoFuncionario cargo;

    public Funcionario(String nome, double salario, int tempoDeCargo, CargoDoFuncionario cargo) {
        this.nome = nome;
        this.salario = salario;
        this.tempoDeCargo = tempoDeCargo;
        this.cargo = cargo;
    }

    public Funcionario(String nome, int tempoDeCargo) {
        this.nome = nome;
        this.tempoDeCargo = tempoDeCargo;
    }

    public void promover() {
        System.out.println("Funcionário(a) " + nome + " foi promovido(a)!");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getTempoDeCargo() {
        return tempoDeCargo;
    }

    public void setTempoDeCargo(int tempoDeCargo) {
        this.tempoDeCargo = tempoDeCargo;
    }

    public CargoDoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(CargoDoFuncionario cargo) {
        this.cargo = cargo;
    }
}

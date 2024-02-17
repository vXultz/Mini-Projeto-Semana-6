import Funcionario.EnumCargoFuncionario;

public class Funcionario implements InterfaceFuncionario{

    private String nome;
    private double salario;
    private int tempoDeCargo;
    private EnumCargoFuncionario cargo;

    public Funcionario(String nome, double salario, int tempoDeCargo, EnumCargoFuncionario cargo) {
        this.nome = nome;
        this.salario = salario;
        this.tempoDeCargo = tempoDeCargo;
        this.cargo = cargo;
    }

    public Funcionario(String nome, int tempoDeCargo) {
        this.nome = nome;
        this.tempoDeCargo = tempoDeCargo;
    }

    @Override
    public void promover() {
        try {
            if (this.cargo.getLevel() >= EnumCargoFuncionario.values().length) {
                throw new RuntimeException("O funcionário já está no nível máximo!");
            }
            this.cargo = EnumCargoFuncionario.getCargoByLevel(this.cargo.getLevel() + 1);
        } catch (RuntimeException e) {
            System.out.println("Erro ao promover o funcionário: " + e.getMessage());
        } finally {
            System.out.println("Processo de promoção finalizado.");
        }
    }

//    @Override
//    public void promover() {
//        int nivelAtual = cargo.getLevel();
//        switch (nivelAtual) {
//            case 1:
//                cargo = EnumCargoFuncionario.EXPERIENTE;
//                break;
//            case 2:
//                cargo = EnumCargoFuncionario.AVANCADO;
//                break;
//            case 3:
//                System.out.println("O funcionário " + nome + " já está no nível mais alto do cargo!");
//                break;
//            default:
//                System.out.println("Nível de promoção inválido.");
//        }
//    }

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

    public EnumCargoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(EnumCargoFuncionario cargo) {
        this.cargo = cargo;
    }
}

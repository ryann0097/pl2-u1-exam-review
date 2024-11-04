package model;

public class Funcionario extends Pessoa{
    private String cargo;
    private double salario;
    private boolean disponivel;
    
    public void atenderCliente(Cliente cliente){
        disponivel = false;
        System.out.println("Atendendo cliente: " + cliente.getNome());
    }

    public void liberarFuncionario(){
        disponivel = true;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public boolean getDisponivel(){
        return this.disponivel;
    }

}

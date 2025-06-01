package model;

import enums.CARGO;

public class Funcionario extends Pessoa implements Remuneravel {

    private Double salario;
    private String matricula;
    private CARGO cargo;

    public Double getSalario() {
        return salario;
    }
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public CARGO getCargo() {
        return cargo;
    }
    public void setCargo(CARGO cargo) {
        this.cargo = cargo;
    }

    @Override
    public void aplicarBonus() {
        this.salario += 500; // Bônus fixo de 500
        System.out.println("Bônus aplicado ao funcionário " + this.getNome() + ". Novo salário: " + this.salario);
    }
}

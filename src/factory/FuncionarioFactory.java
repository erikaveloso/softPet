package factory;

import enums.CARGO;
import model.Funcionario;
import util.InputHandler;

public class FuncionarioFactory {
    public static Funcionario criarFuncionario() {
        String nome = InputHandler.getString("Nome: ");
        String cpf = InputHandler.getString("CPF: ");
        long telefone = InputHandler.getLong("Telefone: ");
        InputHandler.nextLine();
        int idade = InputHandler.getInt("Idade: ");
        InputHandler.nextLine();
        String matricula = InputHandler.getString("Matrícula: ");
        double salario = InputHandler.getDouble("Salário: ");
        InputHandler.nextLine();
        String cargoStr = InputHandler.getString("Cargo (Atendente, Tosador, Banhista, Veterinario): ");

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setTelefone(telefone);
        funcionario.setIdade(idade);
        funcionario.setMatricula(matricula);
        funcionario.setSalario(salario);
        funcionario.setCargo(CARGO.fromString(cargoStr));
        return funcionario;
    }
}

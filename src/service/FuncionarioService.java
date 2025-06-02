package service;

import model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void listar() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                System.out.println("------");
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Telefone: " + funcionario.getTelefone());
                System.out.println("Idade: " + funcionario.getIdade());
                System.out.println("Matrícula: " + funcionario.getMatricula());
                System.out.println("Salário: " + funcionario.getSalario());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("------");
            }
        }
    }

    public Funcionario buscarPorCpf(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equalsIgnoreCase(cpf)) {
                return funcionario;
            }
        }
        return null;
    }
}

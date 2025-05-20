package service;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {

    private List<Funcionario> funcionarios = new ArrayList<>();

    public void cadastrar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public Funcionario buscarPorCpf(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        return null;
    }

    public String listar() {
        StringBuilder sb = new StringBuilder("Funcionários cadastrados:\n");
        for (Funcionario f : funcionarios) {
            sb.append("- ").append(f.getNome()).append(" (CPF: ").append(f.getCpf()).append(", Cargo: ").append(f.getCargo()).append(")\n");
        }
        return sb.toString();
    }
}

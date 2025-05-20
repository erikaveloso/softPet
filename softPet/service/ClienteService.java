package service;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

    public String listar() {
        StringBuilder sb = new StringBuilder("Clientes cadastrados:\n");
        for (Cliente c : clientes) {
            sb.append("- ").append(c.getNome()).append(" (CPF: ").append(c.getCpf()).append(")\n");
        }
        return sb.toString();
    }
}

package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public void cadastrar(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listar() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                System.out.println("------");
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("Endereço: " + cliente.getEndereco());
                System.out.println("------");
            }
        }
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return cliente;
            }
        }
        return null;
    }
}

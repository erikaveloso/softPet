package factory;

import model.Cliente;
import util.InputHandler;

public class ClienteFactory {
    public static Cliente criarCliente() {
        String nome = InputHandler.getString("Nome: ");
        String cpf = InputHandler.getString("CPF: ");
        long telefone = InputHandler.getLong("Telefone: ");
        InputHandler.nextLine();
        String endereco = InputHandler.getString("Endereço: ");

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        return cliente;
    }
}

package factory;

import model.Animal;
import model.Cliente;
import service.ClienteService;
import util.InputHandler;

public class AnimalFactory {
    public static Animal criarAnimal(ClienteService clienteService) {
        String nomeAnimal = InputHandler.getString("Nome do Animal: ");
        String especie = InputHandler.getString("Espécie: ");
        String raca = InputHandler.getString("Raça: ");
        String cor = InputHandler.getString("Cor: ");
        double idade = InputHandler.getDouble("Idade (meses): ");
        InputHandler.nextLine();
        double peso = InputHandler.getDouble("Peso (kg): ");
        InputHandler.nextLine();

        String cpfTutor = InputHandler.getString("CPF do Tutor: ");
        Cliente cliente = clienteService.buscarPorCpf(cpfTutor);

        if (cliente == null) {
            System.out.println("Tutor não encontrado. Cadastre o cliente antes.");
            return null;
        }

        Animal animal = new Animal();
        animal.setNomeAnimal(nomeAnimal);
        animal.setEspecie(especie);
        animal.setRaca(raca);
        animal.setCor(cor);
        animal.setIdade(idade);
        animal.setPeso(peso);
        animal.setCliente(cliente);
        animal.setNomeTutor(cliente.getNome());
        return animal;
    }
}

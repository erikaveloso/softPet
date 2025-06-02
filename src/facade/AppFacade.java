package facade;

import factory.AnimalFactory;
import factory.ClienteFactory;
import factory.FuncionarioFactory;
import model.Animal;
import model.Cliente;
import model.Funcionario;
import service.AnimalService;
import service.ClienteService;
import service.FuncionarioService;
import util.InputHandler;

public class AppFacade {
    private AnimalService animalService = new AnimalService();
    private ClienteService clienteService = new ClienteService();
    private FuncionarioService funcionarioService = new FuncionarioService();

    public void iniciar() {
        System.out.println("Bem vindo ao sistema SoftPet");
        boolean sair = false;
        while (!sair) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Cadastrar Animal");
            System.out.println("4 - Listar Animais");
            System.out.println("5 - Cadastrar Funcionário");
            System.out.println("6 - Listar Funcionários");
            System.out.println("7 - Aplicar bônus a Funcionário");
            System.out.println("0 - Sair");

            int opcao = InputHandler.getInt("Opção: ");
            InputHandler.nextLine();

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> cadastrarAnimal();
                case 4 -> listarAnimais();
                case 5 -> cadastrarFuncionario();
                case 6 -> listarFuncionarios();
                case 7 -> aplicarBonusFuncionario();
                case 0 -> {
                    System.out.println("Saindo...");
                    sair = true;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarCliente() {
        Cliente cliente = ClienteFactory.criarCliente();
        clienteService.cadastrar(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void listarClientes() {
        clienteService.listar();
    }

    private void cadastrarAnimal() {
        Animal animal = AnimalFactory.criarAnimal(clienteService);
        if (animal != null) {
            animalService.cadastrar(animal);
            System.out.println("Animal cadastrado com sucesso!");
        }
    }

    private void listarAnimais() {
        animalService.listar();
    }

    private void cadastrarFuncionario() {
        Funcionario funcionario = FuncionarioFactory.criarFuncionario();
        funcionarioService.cadastrar(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void listarFuncionarios() {
        funcionarioService.listar();
    }

    private void aplicarBonusFuncionario() {
        String cpf = InputHandler.getString("Digite o CPF do funcionário para aplicar bônus: ");
        Funcionario f = funcionarioService.buscarPorCpf(cpf);
        if (f != null) {
            f.aplicarBonus();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
}

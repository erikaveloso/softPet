package facade;

import model.Animal;
import model.Cliente;
import model.Funcionario;
import service.AnimalService;
import service.ClienteService;
import service.FuncionarioService;

import java.util.Scanner;

public class AppFacade {
    private AnimalService animalService = new AnimalService();
    private ClienteService clienteService = new ClienteService();
    private FuncionarioService funcionarioService = new FuncionarioService();
    private Scanner scanner = new Scanner(System.in);

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

            int opcao = scanner.nextInt();
            scanner.nextLine();

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
        Cliente cliente = new Cliente();
        System.out.print("Nome: ");
        cliente.setNome(scanner.nextLine());
        System.out.print("CPF: ");
        cliente.setCpf(scanner.nextLine());
        System.out.print("Telefone: ");
        cliente.setTelefone(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Endereço: ");
        cliente.setEndereco(scanner.nextLine());
        clienteService.cadastrar(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void listarClientes() {
        System.out.println(clienteService.listar());
    }

    private void cadastrarAnimal() {
        Animal animal = new Animal();
        System.out.print("Nome do Animal: ");
        animal.setNomeAnimal(scanner.nextLine());
        System.out.print("Espécie: ");
        animal.setEspecie(scanner.nextLine());
        System.out.print("Raça: ");
        animal.setRaca(scanner.nextLine());
        System.out.print("Cor: ");
        animal.setCor(scanner.nextLine());
        System.out.print("Idade (meses): ");
        animal.setIdade(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Peso (kg): ");
        animal.setPeso(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("CPF do Tutor: ");
        String cpfTutor = scanner.nextLine();
        Cliente cliente = clienteService.buscarPorCpf(cpfTutor);
        if (cliente != null) {
            animal.setCliente(cliente);
            animal.setNomeTutor(cliente.getNome());
            animalService.cadastrar(animal);
            System.out.println("Animal cadastrado com sucesso!");
        } else {
            System.out.println("Tutor não encontrado. Cadastre o cliente antes.");
        }
    }

    private void listarAnimais() {
        System.out.println(animalService.listar());
    }

    private void cadastrarFuncionario() {
        Funcionario funcionario = new Funcionario();
        System.out.print("Nome: ");
        funcionario.setNome(scanner.nextLine());
        System.out.print("CPF: ");
        funcionario.setCpf(scanner.nextLine());
        System.out.print("Telefone: ");
        funcionario.setTelefone(scanner.nextLong());
        System.out.print("Idade: ");
        funcionario.setIdade(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Matrícula: ");
        funcionario.setMatricula(scanner.nextLine());
        System.out.print("Salário: ");
        funcionario.setSalario(scanner.nextDouble());
        scanner.nextLine();
        System.out.print("Cargo (Atendente, Tosador, Banhista, Veterinario): ");
        String cargoStr = scanner.nextLine();
        funcionario.setCargo(enums.CARGO.fromString(cargoStr));
        funcionarioService.cadastrar(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void listarFuncionarios() {
        System.out.println(funcionarioService.listar());
    }

    private void aplicarBonusFuncionario() {
        System.out.print("Digite o CPF do funcionário para aplicar bônus: ");
        String cpf = scanner.nextLine();
        Funcionario f = funcionarioService.buscarPorCpf(cpf);
        if (f != null) {
            f.aplicarBonus();
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
}

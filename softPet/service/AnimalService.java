package service;

import model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalService {
    private List<Animal> animais = new ArrayList<>();

    public void cadastrar(Animal animal) {
        animais.add(animal);
    }

    public void listar() {
        if (animais.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            for (Animal animal : animais) {
                System.out.println("------");
                System.out.println("Nome: " + animal.getNomeAnimal());
                System.out.println("Espécie: " + animal.getEspecie());
                System.out.println("Raça: " + animal.getRaca());
                System.out.println("Cor: " + animal.getCor());
                System.out.println("Idade: " + animal.getIdade());
                System.out.println("Peso: " + animal.getPeso());
                System.out.println("Tutor: " + animal.getNomeTutor());
                System.out.println("------");
            }
        }
    }

    public Animal buscarPorNome(String nome) {
        for (Animal animal : animais) {
            if (animal.getNomeAnimal().equalsIgnoreCase(nome)) {
                return animal;
            }
        }
        return null;
    }
}

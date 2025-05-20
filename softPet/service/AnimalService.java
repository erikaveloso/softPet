package service;

import model.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalService {

    private List<Animal> animais = new ArrayList<>();

    public void cadastrar(Animal animal) {
        animais.add(animal);
    }

    public void remover(String nomeAnimal, String cpfTutor) {
        Animal paraRemover = null;
        for (Animal a : animais) {
            if (a.getNomeAnimal().equalsIgnoreCase(nomeAnimal) &&
                a.getCliente() != null &&
                a.getCliente().getCpf().equals(cpfTutor)) {
                paraRemover = a;
                break;
            }
        }
        if (paraRemover != null) {
            animais.remove(paraRemover);
            System.out.println("Animal removido com sucesso.");
        } else {
            System.out.println("Animal não encontrado para remoção.");
        }
    }

    public String listar() {
        StringBuilder sb = new StringBuilder("Animais cadastrados:\n");
        for (Animal a : animais) {
            sb.append("- ").append(a.getNomeAnimal()).append(" (Tutor: ").append(a.getNomeTutor()).append(")\n");
        }
        return sb.toString();
    }

    public Animal buscarPorNome(String nomeAnimal) {
        for (Animal a : animais) {
            if (a.getNomeAnimal().equalsIgnoreCase(nomeAnimal)) {
                return a;
            }
        }
        return null;
    }
}

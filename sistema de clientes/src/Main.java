import java.util.ArrayList;
import java.util.Scanner;

// Classe Cliente
class Cliente {
    String nome;
    String email;

    Cliente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Email: " + email;
    }
}

// Classe principal
public class Main {

    // Variáveis globais (static)
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== Sistema de Clientes =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Remover cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> atualizarCliente();
                case 4 -> removerCliente();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Email do cliente: ");
        String email = scanner.nextLine();
        clientes.add(new Cliente(nome, email));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\nLista de Clientes:");
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println(i + " - " + clientes.get(i));
            }
        }
    }

    private static void atualizarCliente() {
        listarClientes();
        System.out.print("Informe o índice do cliente para atualizar: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < clientes.size()) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo email: ");
            String email = scanner.nextLine();
            clientes.set(index, new Cliente(nome, email));
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private static void removerCliente() {
        listarClientes();
        System.out.print("Informe o índice do cliente para remover: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < clientes.size()) {
            clientes.remove(index);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Índice inválido!");
        }
    }
}

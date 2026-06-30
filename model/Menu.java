package model;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirCabecalho() {
        System.out.println("╔══════════════════════════════╗");
        System.out.println("║   ARENA DE BATALHA CRIATURAS ║");
        System.out.println("╚══════════════════════════════╝");
    }

    public void exibirListaCriaturas(List<Criatura> criaturas) {
        System.out.println("\n=== CRIATURAS DISPONÍVEIS ===");
        for (int i = 0; i < criaturas.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            criaturas.get(i).exibirStatus();
        }
    }

    public int escolherCriatura(int jogador, int totalCriaturas) {
        int escolha = -1;

        while (escolha < 1 || escolha > totalCriaturas) {
            System.out.print("\nJogador " + jogador + ", escolha sua criatura (1-" + totalCriaturas + "): ");
            try {
                escolha = Integer.parseInt(scanner.nextLine().trim());
                if (escolha < 1 || escolha > totalCriaturas) {
                    System.out.println("Opção inválida, tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, digite um número.");
            }
        }

        return escolha - 1; // retorna índice
    }

    public void exibirCriaturasEscolhidas(Criatura c1, Criatura c2) {
        System.out.println("\n" + c1.getNome() + " VS " + c2.getNome());
        System.out.println("Pressione ENTER para iniciar a batalha...");
        scanner.nextLine();
    }

    public int escolherAtaque(Criatura criatura) {
        List<Ataque> ataques = criatura.getAtaques();
        int escolha = -1;

        System.out.println("\nEscolha o ataque de " + criatura.getNome() + ":");
        for (int i = 0; i < ataques.size(); i++) {
            Ataque a = ataques.get(i);
            System.out.println("[" + (i + 1) + "] " + a.getNome() +
                    " | Dano: " + a.getDanoBase() +
                    " | Tipo: " + a.getTipo() +
                    " | Precisão: " + a.getPrecisao());
        }

        while (escolha < 1 || escolha > ataques.size()) {
            System.out.print("Digite o número do ataque: ");
            try {
                escolha = Integer.parseInt(scanner.nextLine().trim());
                if (escolha < 1 || escolha > ataques.size()) {
                    System.out.println("Opção inválida, tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, digite um número.");
            }
        }

        return escolha - 1; // retorna índice
    }

    public boolean perguntarNovaBatalha() {
        System.out.print("\nDeseja jogar novamente? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();
        return resposta.equals("s");
    }

    public void exibirEncerramento() {
        System.out.println("\nObrigado por jogar!");
    }
}

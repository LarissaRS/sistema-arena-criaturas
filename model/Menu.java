package model;

import java.util.List;
import java.util.Scanner;

/**
 * Responsável por exibir menus e receber escolhas do usuário.
 *
 * @author Larissa Rocha e João Antônio
 */
public class Menu {

    private Scanner scanner;

    /**
     * Cria um novo menu.
     */
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Exibe o cabeçalho inicial do jogo.
     */
    public void exibirCabecalho() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║            ARENA DE CRIATURAS              ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }

    /**
     * Exibe a lista de criaturas disponíveis.
     *
     * @param criaturas lista de criaturas.
     */
    public void exibirListaCriaturas(List<Criatura> criaturas) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║          CRIATURAS DISPONÍVEIS             ║");
        System.out.println("╚════════════════════════════════════════════╝");

        for (int i = 0; i < criaturas.size(); i++) {
            System.out.println("\n[" + (i + 1) + "] " + criaturas.get(i).getNome());
            System.out.println("────────────────────────────────────────────");
            criaturas.get(i).exibirStatus();
        }
    }

    /**
     * Permite que o jogador escolha uma criatura.
     *
     * @param jogador número do jogador.
     * @param totalCriaturas quantidade total de criaturas.
     * @return índice da criatura escolhida.
     */
    public int escolherCriatura(int jogador, int totalCriaturas) {
        int escolha = -1;

        while (escolha < 1 || escolha > totalCriaturas) {
            System.out.print("\nJogador " + jogador + ", escolha sua criatura (1-" + totalCriaturas + ") ► ");

            try {
                escolha = Integer.parseInt(scanner.nextLine().trim());

                if (escolha < 1 || escolha > totalCriaturas) {
                    System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }

        return escolha - 1;
    }

    /**
     * Exibe as criaturas escolhidas pelos jogadores.
     *
     * @param c1 criatura do jogador 1.
     * @param c2 criatura do jogador 2.
     */
    public void exibirCriaturasEscolhidas(Criatura c1, Criatura c2) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║              BATALHA DEFINIDA              ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.printf("║ %-18s  VS  %-18s ║%n", c1.getNome(), c2.getNome());
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("\nPressione ENTER para iniciar a batalha...");
        scanner.nextLine();
    }

    /**
     * Permite que o jogador escolha um ataque.
     *
     * @param criatura criatura que irá atacar.
     * @return índice do ataque escolhido.
     */
    public int escolherAtaque(Criatura criatura) {
        List<Ataque> ataques = criatura.getAtaques();
        int escolha = -1;

        System.out.println("\n╔═════════════════════════════════════════════════════════════╗");
        System.out.println("║                     ESCOLHA O ATAQUE                        ║");
        System.out.println("╠═════════════════════════════════════════════════════════════╣");
        System.out.printf("║ Criatura: %-49s ║%n", criatura.getNome());
        System.out.println("╠════╦════════════════╦══════╦═══════════╦════════════════════╣");
        System.out.println("║ Nº ║ Ataque         ║ Dano ║ Precisão  ║ Tipo               ║");
        System.out.println("╠════╬════════════════╬══════╬═══════════╬════════════════════╣");

        for (int i = 0; i < ataques.size(); i++) {
            Ataque a = ataques.get(i);
            String precisao = (int) (a.getPrecisao() * 100) + "%";

            System.out.printf(
                    "║ %-2d ║ %-14s ║ %-4d ║ %-9s ║ %-18s ║%n",
                    i + 1,
                    a.getNome(),
                    a.getDanoBase(),
                    precisao,
                    a.getTipo()
            );
        }

        System.out.println("╚════╩════════════════╩══════╩═══════════╩════════════════════╝");

        for (int i = 0; i < ataques.size(); i++) {
            Ataque a = ataques.get(i);
            System.out.println("[" + (i + 1) + "] " + a.getNome() + ": " + a.getDescricao());
        }

        while (escolha < 1 || escolha > ataques.size()) {
            System.out.print("\nDigite o número do ataque ► ");

            try {
                escolha = Integer.parseInt(scanner.nextLine().trim());

                if (escolha < 1 || escolha > ataques.size()) {
                    System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }

        return escolha - 1;
    }

    /**
     * Pergunta se o usuário deseja iniciar uma nova batalha.
     *
     * @return true se quiser jogar novamente.
     */
    public boolean perguntarNovaBatalha() {
        System.out.print("\nDeseja jogar novamente? (s/n) ► ");
        String resposta = scanner.nextLine().trim().toLowerCase();

        return resposta.equals("s");
    }

    /**
     * Exibe a mensagem final do jogo.
     */
    public void exibirEncerramento() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║              OBRIGADO POR JOGAR!           ║");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}

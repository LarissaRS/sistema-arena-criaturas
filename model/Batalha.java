package model;

import habilidades.HabilidadeEspecial;
import exceptions.AcaoInvalidaException;

/**
 * Controla o funcionamento da batalha.
 *
 * @author Larissa Rocha e João Antônio
 */
public class Batalha {

    private Criatura criatura1;
    private Criatura criatura2;
    private int turnoAtual;
    private Menu menu;

    /**
     * Cria uma nova batalha entre duas criaturas.
     *
     * @param criatura1 primeira criatura.
     * @param criatura2 segunda criatura.
     * @param menu menu utilizado na batalha.
     */
    public Batalha(Criatura criatura1, Criatura criatura2, Menu menu) {
        this.criatura1 = criatura1;
        this.criatura2 = criatura2;
        this.turnoAtual = 1;
        this.menu = menu;
    }

    private Ataque selecionarAtaque(Criatura criatura) {
        int indice = menu.escolherAtaque(criatura);
        return criatura.getAtaques().get(indice);
    }

    private void tentaUsarHabilidadeEspecial(Criatura criatura) {
        if (!(criatura instanceof HabilidadeEspecial habilidade)) {
            return;
        }

        boolean vidaBaixa = criatura.getPontosDeVida() < criatura.getVidaMaxima() * 0.4;
        boolean turnoEspecial = turnoAtual % 3 == 0;

        if (vidaBaixa || turnoEspecial) {
            System.out.println("\n✨ HABILIDADE ESPECIAL ATIVADA!");
            habilidade.usarHabilidadeEspecial();
        }
    }

    public Criatura getCriatura1() {
        return criatura1;
    }

    public void setCriatura1(Criatura criatura1) {
        this.criatura1 = criatura1;
    }

    public Criatura getCriatura2() {
        return criatura2;
    }

    public void setCriatura2(Criatura criatura2) {
        this.criatura2 = criatura2;
    }

    public int getTurnoAtual() {
        return turnoAtual;
    }

    public void setTurnoAtual(int turnoAtual) {
        this.turnoAtual = turnoAtual;
    }

    private boolean criaturasPossuemAtaques() {
        if (criatura1.getAtaques().isEmpty()) {
            System.out.println("⚠ " + criatura1.getNome() + " não possui ataques.");
            return false;
        }

        if (criatura2.getAtaques().isEmpty()) {
            System.out.println("⚠ " + criatura2.getNome() + " não possui ataques.");
            return false;
        }

        return true;
    }

    /**
     * Inicia a batalha.
     */
    public void iniciarBatalha() {
        if (!criaturasPossuemAtaques()) {
            return;
        }

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║              INÍCIO DA BATALHA             ║");
        System.out.println("╚════════════════════════════════════════════╝");

        criatura1.exibirStatus();
        criatura2.exibirStatus();

        while (criatura1.estaViva() && criatura2.estaViva()) {
            executarTurno();
            setTurnoAtual(getTurnoAtual() + 1);
        }

        exibirResultado();
    }

    /**
     * Executa um turno da batalha.
     */
    public void executarTurno() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.printf("║                  TURNO %-3d                 ║%n", getTurnoAtual());
        System.out.println("╚════════════════════════════════════════════╝");

        tentaUsarHabilidadeEspecial(criatura1);

        if (criatura2.estaViva()) {
            tentaUsarHabilidadeEspecial(criatura2);
        }

        Ataque ataque1 = selecionarAtaque(criatura1);

        try {
            criatura1.atacar(criatura2, ataque1);
        } catch (AcaoInvalidaException e) {
            System.out.println("⚠ Erro: " + e.getMessage());
        }

        if (criatura2.estaViva()) {
            Ataque ataque2 = selecionarAtaque(criatura2);

            try {
                criatura2.atacar(criatura1, ataque2);
            } catch (AcaoInvalidaException e) {
                System.out.println("⚠ Erro: " + e.getMessage());
            }
        }

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║              STATUS DA BATALHA             ║");
        System.out.println("╚════════════════════════════════════════════╝");

        criatura1.exibirStatus();
        criatura2.exibirStatus();
    }

    /**
     * Verifica qual criatura venceu a batalha.
     *
     * @return criatura vencedora ou null se a batalha não terminou.
     */
    public Criatura verificarVencedor() {
        if (!criatura1.estaViva()) {
            return criatura2;
        }

        if (!criatura2.estaViva()) {
            return criatura1;
        }

        return null;
    }

    /**
     * Exibe o resultado final da batalha.
     */
    public void exibirResultado() {
        Criatura vencedor = verificarVencedor();

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║               FIM DA BATALHA               ║");
        System.out.println("╠════════════════════════════════════════════╣");

        if (vencedor != null) {
            System.out.printf("║ Vencedor : %-31s ║%n", vencedor.getNome());
            System.out.printf("║ Turnos   : %-31d ║%n", getTurnoAtual() - 1);
        } else {
            System.out.println("║ A batalha ainda não terminou.             ║");
        }

        System.out.println("╚════════════════════════════════════════════╝");
    }
}

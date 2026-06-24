package model;

import java.util.List;
import java.util.Random;
import habilidades.HabilidadeEspecial;

public class Batalha{

    private Criatura criatura1;
    private Criatura criatura2;
    private int turnoAtual;

    public Batalha(Criatura criatura1, Criatura criatura2) {
        this.criatura1 = criatura1;
        this.criatura2 = criatura2;
        this.turnoAtual = 1;
    }

    private Ataque selecionarAtaque(Criatura criatura) {
        Random rand = new Random();
        List<Ataque> ataques = criatura.getAtaques();
        return ataques.get(rand.nextInt(ataques.size()));
    }

    private void tentaUsarHbailidadeEspecial(Criatura criatura) {
        if(!(criatura instanceof HabilidadeEspecial habilidade)) {
            return;
        }
        boolean vidaBaixa = criatura.getPontosDeVida() < criatura.getVidaMaxima() * 0.4;
        boolean turnoEspecial = turnoAtual % 3 == 0;
        if (vidaBaixa || turnoEspecial) {
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
            System.out.println(criatura1.getNome() + " não possui ataques.");
            return false;
        }

        if (criatura2.getAtaques().isEmpty()) {
            System.out.println(criatura2.getNome() + " não possui ataques.");
            return false;
        }

        return true;
    }

    public void iniciarBatalha(){

        if (!criaturasPossuemAtaques()) {
            return;
        }

        System.out.println("===== INÍCIO DA BATALHA =====");

        criatura1.exibirStatus();
        criatura2.exibirStatus();

        while (criatura1.estaViva() && criatura2.estaViva()){

            executarTurno();

            setTurnoAtual(getTurnoAtual() + 1);

        }

        exibirResultado();
    }

    public void executarTurno() {

        System.out.println("\n===== TURNO " + getTurnoAtual() + " =====");

        tentaUsarHbailidadeEspecial(criatura1);
        if(criatura2.estaViva()){
            tentaUsarHbailidadeEspecial(criatura2);
        }

        Ataque ataque1 = selecionarAtaque(criatura1);
        criatura1.atacar(criatura2, ataque1);

        if (criatura2.estaViva()) {
            Ataque ataque2 = selecionarAtaque(criatura2);
            criatura2.atacar(criatura1, ataque2);
        }

        criatura1.exibirStatus();
        criatura2.exibirStatus();
    }

    public Criatura verificarVencedor() {

        if (!criatura1.estaViva()) {
            return criatura2;
        }

        if (!criatura2.estaViva()) {
            return criatura1;
        }

        return null;
    }

    public void exibirResultado() {

        Criatura vencedor = verificarVencedor();

        System.out.println("\n===== FIM DA BATALHA =====");

        if (vencedor != null) {
            System.out.println("Vencedor: " + vencedor.getNome());
            System.out.println("Turnos realizados: " + (getTurnoAtual() - 1));
        } else {
            System.out.println("A batalha ainda não terminou.");
        }
    }

}
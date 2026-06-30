package principal;

import model.*;
import criaturas.*;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        boolean jogarNovamente = true;

        while(jogarNovamente) {

            List<Criatura> criaturas = criarCriaturas();

            menu.exibirCabecalho();
            menu.exibirListaCriaturas(criaturas);

            int indice1 = menu.escolherCriatura(1, criaturas.size());
            Criatura criatura1 = criaturas.get(indice1);

            int indice2;
            do {
                indice2 = menu.escolherCriatura(2, criaturas.size());
                if(indice2 == indice1) {
                    System.out.println("Criatura já escolhida, tente outra!");
                }
            } while(indice2 == indice1);
            Criatura criatura2 = criaturas.get(indice2);

            menu.exibirCriaturasEscolhidas(criatura1, criatura2);

            Batalha batalha = new Batalha(criatura1, criatura2, menu);
            batalha.iniciarBatalha();

            jogarNovamente = menu.perguntarNovaBatalha();
        }

        menu.exibirEncerramento();
    }

    private static List<Criatura> criarCriaturas() {

        List<Criatura> lista = new ArrayList<>();

        Dragao dragao = new Dragao("Fogaréu");
        dragao.adicionarAtaque(new Ataque("Faíscada", 30, "FOGO", "Papoca o oponente com estalos de fogo", 0.9));
        dragao.adicionarAtaque(new Ataque("Braseiro", 20, "FOGO", "Ataca com brasas flamejantes", 1.0));
        lista.add(dragao);

        Golem golem = new Golem("Pedregulho");
        golem.adicionarAtaque(new Ataque("Pedrada", 25, "TERRA", "Arremessa uma pedra no adversário", 0.95));
        golem.adicionarAtaque(new Ataque("Terremoto", 35, "TERRA", "Abala o solo ao redor", 0.75));
        lista.add(golem);

        LoboSombrio lobo = new LoboSombrio("Meia-noite");
        lobo.adicionarAtaque(new Ataque("Garra Sombria", 28, "SOMBRA", "Rasga com garras das trevas", 0.9));
        lobo.adicionarAtaque(new Ataque("Malassombro", 22, "SOMBRA", "Uivo que assusta os inimigos", 1.0));
        lista.add(lobo);

        Fenix fenix = new Fenix("Meio-dia");
        fenix.adicionarAtaque(new Ataque("Sol da Peste", 27, "LUZ", "Luz que encandeia o adversário", 0.9));
        fenix.adicionarAtaque(new Ataque("Asa de Luz", 22, "LUZ", "Golpeia com asas radiantes", 1.0));
        lista.add(fenix);

        Grifo grifo = new Grifo("Avoante");
        grifo.adicionarAtaque(new Ataque("Rasante", 25, "AR", "Atinge o inimigo após um mergulho aéreo", 0.95));
        grifo.adicionarAtaque(new Ataque("Esporão", 30, "AR", "Causa dano com suas garras traseiras", 0.85));
        lista.add(grifo);

        SerpenteMarinha serpente = new SerpenteMarinha("Lampréia");
        serpente.adicionarAtaque(new Ataque("Cacimbão", 26, "AGUA", "Usa uma rajada de água para afundar o adversário no solo", 0.9));
        serpente.adicionarAtaque(new Ataque("Olho D'Água", 22, "AGUA", "Cria uma corretenza que atinge o inimigo", 1.0));
        lista.add(serpente);

        return lista;
    }
}

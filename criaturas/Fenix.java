package criaturas;

import habilidades.HabilidadeEspecial;
import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;
import model.Tipo;

public class Fenix extends Criatura implements HabilidadeEspecial, HabilidadePassiva {

    public Fenix(String nome){
        super(nome, Tipo.LUZ, 25, 20, 110);
    }

    @Override
    public void usarHabilidadeEspecial() {

        setPontosDeVida(getPontosDeVida() + 30);

        System.out.println(getNome() + " renasceu das cinzas e recuperou 30 pontos de vida!");
    }

    @Override
    public double aplicarAfinidade(Tipo tipoInimigo) {
        return switch (tipoInimigo) {
            case SOMBRA -> 1.5;
            default -> 1.0;
        };
    }
}
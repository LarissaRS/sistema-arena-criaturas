package criaturas;

import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;
import model.Tipo;

public class Golem extends Criatura implements HabilidadePassiva {

    public Golem(String nome){
        super(nome, Tipo.TERRA, 20, 30, 150);
    }

    @Override
    public void receberDano(int dano) {
        System.out.println(getNome() + " endureceu sua armadura!");
        super.receberDano((int) (dano * 0.8));
    }

    @Override
    public double aplicarAfinidade(Tipo tipoInimigo) {
        return switch (tipoInimigo) {
            case FOGO -> 1.5;
            case AR -> 0.5;
            default -> 1.0;
        };
    }
}
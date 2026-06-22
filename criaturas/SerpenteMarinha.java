package criaturas;

import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;
import model.Tipo;

public class SerpenteMarinha extends Criatura implements HabilidadePassiva {

    public SerpenteMarinha(String nome) {
        super(nome, Tipo.AGUA, 28, 20, 130);
    }

    @Override
    public void atacar(Criatura alvo, Ataque ataque) {

        System.out.println(getNome() + " lançou uma onda poderosa!");

        alvo.setForca(alvo.getForca() - 2);

        super.atacar(alvo, ataque);
    }

    @Override
    public double aplicarAfinidade(Tipo tipoInimigo) {
        return switch (tipoInimigo) {
            case FOGO -> 1.5;
            case AR -> 0.5;
            default -> 1;
        };
    }
}
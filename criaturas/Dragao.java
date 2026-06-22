package criaturas;

import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;
import model.Tipo;

public class Dragao extends Criatura implements HabilidadePassiva {

    public Dragao(String nome) {
        super(nome, Tipo.FOGO, 30, 15, 120);
    }

    @Override
    public void atacar(Criatura alvo, Ataque ataque) {

        System.out.println(getNome() + " lançou chamas!");

        super.atacar(alvo, ataque);
    }

    @Override
    public double aplicarAfinidade(Tipo tipoInimigo) {
        return switch (tipoInimigo) {
            case AR -> 1.5;
            case AGUA -> 0.5;
            default -> 1.0;
        };
    }
}
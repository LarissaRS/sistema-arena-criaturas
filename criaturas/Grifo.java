package criaturas;

import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;
import model.Tipo;

public class Grifo extends Criatura implements HabilidadePassiva {

    public Grifo(String nome) {
        super(nome, Tipo.AR, 32, 15, 110);
    }
    @Override
    public void atacar(Criatura alvo, Ataque ataque) {

        System.out.println(getNome() + " atacou com ventos cortantes!");
        setForca(getForca()+5);
        super.atacar(alvo, ataque);
        setForca(getForca()-5);
    }

    @Override
    public double aplicarAfinidade(Tipo tipoInimigo) {
        return switch (tipoInimigo) {
            case TERRA -> 1.5;
            case FOGO -> 0.5;
            default -> 1.0;
        };
    }
}
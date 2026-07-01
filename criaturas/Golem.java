package criaturas;

import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Tipo;

/**
 * Representa a criatura Golem.
 *
 * @author Larissa Rocha e João Antônio
 */
public class Golem extends Criatura implements HabilidadePassiva {

    /**
     * Cria um novo Golem.
     *
     * @param nome nome da criatura.
     */
    public Golem(String nome){
        super(nome, Tipo.TERRA, 20, 30, 150);
    }

    /**
     * Recebe dano reduzindo seu valor devido à armadura.
     *
     * @param dano quantidade de dano recebida.
     */
    @Override
    public void receberDano(int dano) {
        System.out.println(getNome() + " endureceu sua armadura!");
        super.receberDano((int) (dano * 0.8));
    }

    /**
     * Calcula o multiplicador de dano conforme o tipo do inimigo.
     *
     * @param tipoInimigo tipo da criatura adversária.
     * @return multiplicador de afinidade.
     */
    @Override
    public double aplicarAfinidade(Tipo tipoInimigo) {
        return switch (tipoInimigo) {
            case FOGO -> 1.5;
            case AR -> 0.5;
            default -> 1.0;
        };
    }
}

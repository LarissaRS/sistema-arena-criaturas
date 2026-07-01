package criaturas;

import exceptions.AcaoInvalidaException;
import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;
import model.Tipo;

/**
 * Representa a criatura Dragão.
 *
 * @author Larissa Rocha e João Antônio
 */
public class Dragao extends Criatura implements HabilidadePassiva {

    /**
     * Cria um novo Dragão.
     *
     * @param nome nome da criatura.
     */
    public Dragao(String nome) {
        super(nome, Tipo.FOGO, 30, 15, 120);
    }

    /**
     * Ataca uma criatura utilizando um ataque.
     *
     * @param alvo criatura atacada.
     * @param ataque ataque utilizado.
     * @throws AcaoInvalidaException se o ataque for inválido.
     */
    @Override
    public void atacar(Criatura alvo, Ataque ataque) throws AcaoInvalidaException {

        super.atacar(alvo, ataque);
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
            case AR -> 1.5;
            case AGUA -> 0.5;
            default -> 1.0;
        };
    }
}

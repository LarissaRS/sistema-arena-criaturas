package criaturas;

import exceptions.AcaoInvalidaException;
import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;
import model.Tipo;

/**
 * Representa a criatura Serpente Marinha.
 *
 * @author Larissa Rocha e João Antônio
 */
public class SerpenteMarinha extends Criatura implements HabilidadePassiva {

    /**
     * Cria uma nova Serpente Marinha.
     *
     * @param nome nome da criatura.
     */
    public SerpenteMarinha(String nome) {
        super(nome, Tipo.AGUA, 28, 20, 130);
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

        System.out.println(getNome() + " lançou uma onda poderosa!");

        alvo.setForca(alvo.getForca() - 2);

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
            case FOGO -> 1.5;
            case AR -> 0.5;
            default -> 1.0;
        };
    }
}

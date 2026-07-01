package criaturas;

import exceptions.AcaoInvalidaException;
import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;
import model.Tipo;

/**
 * Representa a criatura Grifo.
 *
 * @author Larissa Rocha e João Antônio 
 */
public class Grifo extends Criatura implements HabilidadePassiva {

    /**
     * Cria um novo Grifo.
     *
     * @param nome nome da criatura.
     */
    public Grifo(String nome) {
        super(nome, Tipo.AR, 32, 15, 110);
    }

    /**
     * Realiza um ataque contra o alvo.
     *
     * @param alvo criatura atacada.
     * @param ataque ataque utilizado.
     * @throws AcaoInvalidaException se o ataque for inválido.
     */
    @Override
    public void atacar(Criatura alvo, Ataque ataque)  throws AcaoInvalidaException {

        System.out.println(getNome() + " atacou com ventos cortantes!");
        setForca(getForca() + 5);
        super.atacar(alvo, ataque);
        setForca(getForca() - 5);
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
            case TERRA -> 1.5;
            case FOGO -> 0.5;
            default -> 1.0;
        };
    }
}

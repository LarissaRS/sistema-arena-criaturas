package criaturas;

import exceptions.AcaoInvalidaException;
import habilidades.HabilidadeEspecial;
import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;
import model.Tipo;

/**
 * Representa a criatura Lobo Sombrio.
 *
 * @author Larissa Rocha e João Antônio
 */
public class LoboSombrio extends Criatura implements HabilidadeEspecial, HabilidadePassiva {

    /**
     * Cria um novo Lobo Sombrio.
     *
     * @param nome nome da criatura.
     */
    public LoboSombrio(String nome) {
        super(nome, Tipo.SOMBRA, 35, 10, 100);
    }

    /**
     * Ativa a habilidade especial do Lobo Sombrio,
     * aumentando sua força.
     */
    @Override
    public void usarHabilidadeEspecial() {

        setForca(getForca() + 10);

        System.out.println(getNome() + " envolveu-se nas sombras e ganhou 10 de força!");
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

        System.out.println(getNome() + " atacou nas sombras!");

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
            case LUZ -> 1.5;
            default -> 1.0;
        };
    }
}

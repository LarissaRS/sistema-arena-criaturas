package criaturas;

import habilidades.HabilidadeEspecial;
import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;
import model.Tipo;

/**
 * Representa a criatura Fênix.
 *
 * @author Larissa Rocha e João Antônio
 */
public class Fenix extends Criatura implements HabilidadeEspecial, HabilidadePassiva {

    /**
     * Cria uma nova Fênix.
     *
     * @param nome nome da criatura.
     */
    public Fenix(String nome){
        super(nome, Tipo.LUZ, 25, 20, 110);
    }

    /**
     * Ativa a habilidade especial da Fênix,
     * recuperando parte de sua vida.
     */
    @Override
    public void usarHabilidadeEspecial() {

        setPontosDeVida(getPontosDeVida() + 30);

        System.out.println(getNome() + " renasceu das cinzas e recuperou 30 pontos de vida!");
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
            case SOMBRA -> 1.5;
            default -> 1.0;
        };
    }
}

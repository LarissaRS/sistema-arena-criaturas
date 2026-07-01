package habilidades;

import model.Tipo;

/**
 * Interface para criaturas que possuem uma habilidade passiva.
 *
 * @author Larissa Rocha e João Antônio
 */
public interface HabilidadePassiva {

    /**
     * Calcula o multiplicador de dano conforme o tipo do inimigo.
     *
     * @param tipoInimigo tipo da criatura adversária.
     * @return multiplicador de afinidade.
     */
    double aplicarAfinidade(Tipo tipoInimigo);
    
}

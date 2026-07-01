package model;

import java.util.List;
import java.util.Scanner;

/**
 * Representa um ataque que pode ser utilizado por uma criatura.
 *
 * @author Larissa Rocha e João Antônio
 */
public class Ataque {

    private String nome;
    private int danoBase;
    private String tipo;
    private String descricao;
    private double precisao;

    /**
     * Cria um novo ataque.
     *
     * @param nome nome do ataque.
     * @param danoBase dano base do ataque.
     * @param tipo tipo do ataque.
     * @param descricao descrição do ataque.
     * @param precisao precisão do ataque.
     */
    public Ataque(String nome, int danoBase, String tipo, String descricao, double precisao) {
        if (danoBase <= 0) {
            throw new IllegalArgumentException("Dano base deve ser maior que zero.");
        }

        this.nome = nome;
        this.danoBase = danoBase;
        this.tipo = tipo;
        this.descricao = descricao;
        this.precisao = precisao;
    }

    private Scanner sc = new Scanner(System.in);

    /**
     * Retorna o nome do ataque.
     *
     * @return nome do ataque.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do ataque.
     *
     * @param nome novo nome.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o dano base do ataque.
     *
     * @return dano base.
     */
    public int getDanoBase() {
        return danoBase;
    }

    /**
     * Altera o dano base do ataque.
     *
     * @param danoBase novo dano base.
     */
    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    /**
     * Retorna o tipo do ataque.
     *
     * @return tipo do ataque.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Altera o tipo do ataque.
     *
     * @param tipo novo tipo.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna a descrição do ataque.
     *
     * @return descrição do ataque.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Altera a descrição do ataque.
     *
     * @param descricao nova descrição.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a precisão do ataque.
     *
     * @return precisão do ataque.
     */
    public double getPrecisao() {
        return precisao;
    }

    /**
     * Altera a precisão do ataque.
     *
     * @param precisao nova precisão.
     */
    public void setPrecisao(double precisao) {
        this.precisao = precisao;
    }

    /**
     * Calcula o dano final do ataque.
     *
     * @param forca força da criatura atacante.
     * @param defesa defesa da criatura alvo.
     * @param multiplicador multiplicador de afinidade.
     * @return dano final calculado.
     */
    public int calcularDano(int forca, int defesa, double multiplicador) {

        int danoFinal = (int) ((danoBase + forca - defesa) * multiplicador);

        if (danoFinal < 0) {
            danoFinal = 0;
        }

        return danoFinal;
    }
}

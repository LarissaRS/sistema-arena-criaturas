package model;

import java.util.ArrayList;
import java.util.List;
import exceptions.AcaoInvalidaException;

/**
 * Representa uma criatura da arena.
 *
 * @author Larissa Rocha e João Antônio
 */
public abstract class Criatura {

    private String nome;
    private Tipo tipo;
    private int forca;
    private int defesa;
    private int pontosDeVida;
    private int vidaMaxima;

    private List<Ataque> ataques;

    /**
     * Cria uma nova criatura.
     *
     * @param nome nome da criatura.
     * @param tipo tipo da criatura.
     * @param forca força da criatura.
     * @param defesa defesa da criatura.
     * @param vidaMaxima vida máxima da criatura.
     */
    public Criatura(String nome, Tipo tipo, int forca, int defesa, int vidaMaxima) {
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.defesa = defesa;
        this.pontosDeVida = vidaMaxima;
        this.vidaMaxima = vidaMaxima;

        this.ataques = new ArrayList<>();
    }

    /**
     * Retorna o nome da criatura.
     *
     * @return nome da criatura.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome da criatura.
     *
     * @param nome novo nome.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o tipo da criatura.
     *
     * @return tipo da criatura.
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Altera o tipo da criatura.
     *
     * @param tipo novo tipo.
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna a força da criatura.
     *
     * @return força da criatura.
     */
    public int getForca() {
        return forca;
    }

    /**
     * Altera a força da criatura.
     *
     * @param forca nova força.
     */
    public void setForca(int forca) {
        this.forca = forca;
    }

    /**
     * Retorna a defesa da criatura.
     *
     * @return defesa da criatura.
     */
    public int getDefesa() {
        return defesa;
    }

    /**
     * Altera a defesa da criatura.
     *
     * @param defesa nova defesa.
     */
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    /**
     * Retorna os pontos de vida atuais.
     *
     * @return pontos de vida atuais.
     */
    public int getPontosDeVida() {
        return pontosDeVida;
    }

    /**
     * Altera os pontos de vida da criatura.
     *
     * @param pontosDeVida novos pontos de vida.
     */
    public void setPontosDeVida(int pontosDeVida) {
        if (pontosDeVida < 0) {
            this.pontosDeVida = 0;
        } else if (pontosDeVida > vidaMaxima) {
            this.pontosDeVida = vidaMaxima;
        } else {
            this.pontosDeVida = pontosDeVida;
        }
    }

    /**
     * Retorna a vida máxima da criatura.
     *
     * @return vida máxima.
     */
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    /**
     * Altera a vida máxima da criatura.
     *
     * @param vidaMaxima nova vida máxima.
     */
    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    /**
     * Retorna a lista de ataques da criatura.
     *
     * @return lista de ataques.
     */
    public List<Ataque> getAtaques() {
        return ataques;
    }

    /**
     * Altera a lista de ataques da criatura.
     *
     * @param ataques nova lista de ataques.
     */
    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }

    /**
     * Ataca uma criatura utilizando um ataque.
     *
     * @param alvo criatura atacada.
     * @param ataque ataque utilizado.
     * @throws AcaoInvalidaException se o ataque for inválido.
     */
    public void atacar(Criatura alvo, Ataque ataque) throws AcaoInvalidaException {

        if (alvo == null) {
            throw new AcaoInvalidaException("O alvo não pode ser nulo.");
        }

        if (ataque == null) {
            throw new AcaoInvalidaException("O ataque não pode ser nulo.");
        }

        if (!ataques.contains(ataque)) {
            throw new AcaoInvalidaException("Ataque não pertence à criatura.");
        }

        if (!estaViva()) {
            throw new AcaoInvalidaException(nome + " está derrotado e não pode atacar.");
        }

        double multiplicador = 1.0;

        int dano = ataque.calcularDano(this.forca, alvo.getDefesa(), multiplicador);

        System.out.println(nome + " usou " + ataque.getNome() + " em " + alvo.getNome()
                + " causando " + dano + " de dano.");

        alvo.receberDano(dano);
    }

    /**
     * Adiciona um ataque à criatura.
     *
     * @param ataque ataque a ser adicionado.
     */
    public void adicionarAtaque(Ataque ataque) {
        ataques.add(ataque);
    }

    /**
     * Reduz a vida da criatura conforme o dano recebido.
     *
     * @param dano quantidade de dano recebido.
     */
    public void receberDano(int dano) {
        setPontosDeVida(pontosDeVida - dano);
    }

    /**
     * Verifica se a criatura está viva.
     *
     * @return true se estiver viva.
     */
    public boolean estaViva() {
        return pontosDeVida > 0;
    }

    /**
     * Retorna as informações da criatura em texto.
     *
     * @return dados da criatura.
     */
    @Override
    public String toString() {
        return String.format(
                "║ Nome   : %-18s  ║%n" +
                "║ Tipo   : %-18s  ║%n" +
                "║ Força  : %-18d  ║%n" +
                "║ Defesa : %-18d  ║%n" +
                "║ Vida   : %3d / %-10d    ║",
                nome,
                tipo,
                forca,
                defesa,
                pontosDeVida,
                vidaMaxima
        );
    }

    /**
     * Exibe o status atual da criatura.
     */
    public void exibirStatus() {

        System.out.println("╔══════════════════════════════╗");
        System.out.printf("║ %-28s ║%n", nome.toUpperCase());
        System.out.println("╠══════════════════════════════╣");
        System.out.println(toString());
        System.out.println("╚══════════════════════════════╝");
    }
}

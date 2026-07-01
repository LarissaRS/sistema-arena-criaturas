package model;

import java.util.ArrayList;
import java.util.List;
import exceptions.AcaoInvalidaException;

public abstract class Criatura {

    private String nome;
    private Tipo tipo;
    private int forca;
    private int defesa;
    private int pontosDeVida;
    private int vidaMaxima;

    private List<Ataque> ataques;

    public Criatura(String nome, Tipo tipo, int forca, int defesa, int vidaMaxima) {
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.defesa = defesa;
        this.pontosDeVida = vidaMaxima;
        this.vidaMaxima = vidaMaxima;

        this.ataques = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(int pontosDeVida) {
        if (pontosDeVida < 0) {
            this.pontosDeVida = 0;
        } else if (pontosDeVida > vidaMaxima) {
            this.pontosDeVida = vidaMaxima;
        } else {
            this.pontosDeVida = pontosDeVida;
        }
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }

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

    public void adicionarAtaque(Ataque ataque) {
        ataques.add(ataque);
    }

    public void receberDano(int dano) {

        setPontosDeVida(pontosDeVida - dano);

    } 

    public boolean estaViva() {
        return pontosDeVida > 0;
    }

    public String toString(){
        return "Nome: " + nome +
                "\nTipo: " + tipo +
                "\nForça: " + forca +
                "\nDefesa: " + defesa +
                "\nVida: " + pontosDeVida + "/" + vidaMaxima;
    }

    public void exibirStatus() {
        System.out.println("===== STATUS =====");
        System.out.println(this.toString());
        }
}

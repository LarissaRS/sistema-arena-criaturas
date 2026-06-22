package model;

public class Ataque{
    private String nome;
    private int danoBase;
    private String tipo;
    private String descricao;
    private double precisao;

    public Ataque(String nome, int danoBase, String tipo, String descricao, double precisao) {
        if(danoBase <=0) {
            throw new IllegalArgumentException("Dano base deve ser maior que zero.");
        }
        this.nome = nome;
        this.danoBase = danoBase;
        this.tipo = tipo;
        this.descricao = descricao;
        this.precisao = precisao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecisao() {
        return precisao;
    }

    public void setPrecisao(double precisao) {
        this.precisao = precisao;
    }

    public int calcularDano(int forca, int defesa, double multiplicador) {

        int danoFinal = (int) ((danoBase + forca - defesa) * multiplicador);

        if (danoFinal < 0) {
            danoFinal = 0;
        }

        return danoFinal;
    }
}
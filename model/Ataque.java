package model;

import java.util.List;
import java.util.Scanner;

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

    private Scanner sc = new Scanner(System.in);

    private Ataque selecionarAtaque(Ataque criatura){

        List<Ataque> ataques = criatura.getAtaques();

        System.out.println("\nEscolha o ataque de " + criatura.getNome() + ":");
        for(int i = 0; i < ataques.size(); i++) {
            Ataque a = ataques.get(i);
            System.out.println("[" + (i + 1) + "] " + a.getNome() +
                    " - Dano: " + a.getDanoBase() +
                    " - Tipo: " + a.getTipo() +
                    " - Precisão: " + a.getPrecisao());
        }

        int escolha = -1;
        while(escolha < 1 || escolha > ataques.size()) {
            System.out.println("Digite o número do ataque: ");
            try {
                escolha = Integer.parseInt(sc.nextLine().trim());
                if(escolha < 1 || escolha > ataques.size()) {
                    System.out.println("Número de ataque inválido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, digite um número.");
            }
        }

        return ataques.get(escolha - 1);
    }

    private List<Ataque> getAtaques() {
        return null;
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
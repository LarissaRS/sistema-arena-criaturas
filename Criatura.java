import java.util.ArrayList;
import java.util.List;

public class Criatura{
    private String nome;
    private String tipo;
    private int forca;
    private int defesa;
    private int pontosDeVida;
    private int vidaMaxima;

    private List<Ataque> ataques;

    private HabilidadePassiva habilidadePassiva;

    public Criatura(String nome, String tipo, int forca, int defesa, int vidaMaxima, HabilidadePassiva habilidadePassiva) {
        this.nome = nome;
        this.tipo = tipo;
        this.forca = forca;
        this.defesa = defesa;
        this.pontosDeVida = vidaMaxima;
        this.vidaMaxima = vidaMaxima;
        this.habilidadePassiva = habilidadePassiva;
        
        this.ataques = new ArrayList<>();
    }

    public HabilidadePassiva getHabilidadePassiva() {
        return habilidadePassiva;
    }

    public void setHabilidadePassiva(HabilidadePassiva habilidadePassiva) {
        this.habilidadePassiva = habilidadePassiva;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public void atacar(Criatura alvo, Ataque ataque){

        if (!ataques.contains(ataque)) {
            System.out.println("Ataque não pertence à criatura.");
            return;
        }

        if (!estaViva()) {
            System.out.println(nome + " está derrotado e não pode atacar.");
            return;
        }

        int dano = ataque.calcularDano(this.forca, alvo.getDefesa());

        dano = habilidadePassiva.modificarDano(this, alvo, dano);

        System.out.println(nome + " usou " + ataque.getNome() + " em " + alvo.getNome() + " causando " + dano + " de dano.");

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

    public void exibirStatus() {
        System.out.println("===== STATUS =====");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Força: " + forca);
        System.out.println("Defesa: " + defesa);
        System.out.println("Vida: " + pontosDeVida + "/" + vidaMaxima);
    }
}
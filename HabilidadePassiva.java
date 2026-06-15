public abstract class HabilidadePassiva {

    private String nome;

    public HabilidadePassiva(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract int modificarDano(Criatura atacante, Criatura alvo, int dano);
    
}
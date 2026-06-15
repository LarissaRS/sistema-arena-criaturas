public class Dragao extends Criatura {

    public Dragao(String nome) {
        super(nome, "Fogo", 30, 15, 120, new AfinidadeFogo());
    }

    @Override
    public void atacar(Criatura alvo, Ataque ataque) {

        System.out.println(getNome() + " lançou chamas!");

        super.atacar(alvo, ataque);
    }
}
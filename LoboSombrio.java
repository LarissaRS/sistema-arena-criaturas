public class LoboSombrio extends Criatura implements HabilidadeEspecial {

    public LoboSombrio(String nome) {
        super(nome, "Sombras", 35, 10, 100);
    }


    @Override
    public void usarHabilidadeEspecial() {

        setForca(getForca() + 10);

        System.out.println(getNome() + " envolveu-se nas sombras e ganhou 10 de força!");
    }

    @Override
    public void atacar(Criatura alvo, Ataque ataque) {

        System.out.println(getNome() + " atacou nas sombras!");

        super.atacar(alvo, ataque);
    }

}
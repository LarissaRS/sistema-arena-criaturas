package criaturas;

import habilidades.HabilidadeEspecial;
import habilidades.HabilidadePassiva;
import model.Criatura;
import model.Ataque;

public class LoboSombrio extends Criatura implements HabilidadeEspecial, HabilidadePassiva {

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

    @Override
    public double aplicarAfinidade(Criatura.Tipo tipoInimigo) {
        return switch (tipoInimigo) {
            case LUZ -> 1.5;
            default  -> 1.0;
        };
    }
}
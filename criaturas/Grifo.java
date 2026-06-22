package criaturas;

import model.Criatura;
import model.Ataque;

public class Grifo extends Criatura {

    public Grifo(String nome) {
        super(nome, "Ar", 32, 15, 110);
    }
    @Override
    public void atacar(Criatura alvo, Ataque ataque) {

        System.out.println(getNome() + " atacou com ventos cortantes!");

        int dano = ataque.calcularDano(getForca(), alvo.getDefesa()) + 5;

        alvo.receberDano(dano);
        
    }
    
}
package criaturas;

import model.Criatura;
import model.Ataque;

public class Golem extends Criatura {

    public Golem(String nome){
        super(nome, "Terra", 20, 30, 150, new AfinidadeTerra());
    }

    @Override
    public void receberDano(int dano) {
        System.out.println(getNome() + " endureceu sua armadura!");
        super.receberDano(dano / 2);
    }
}
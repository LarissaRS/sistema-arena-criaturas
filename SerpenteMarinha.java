package criaturas;

import model.Criatura;
import model.Ataque;

public class SerpenteMarinha extends Criatura {

    public SerpenteMarinha(String nome) {
        super(nome, "Água", 28, 20, 130, new AfinidadeAgua());
    }

    @Override
    public void atacar(Criatura alvo, Ataque ataque) {

        System.out.println(getNome() + " lançou uma onda poderosa!");

        alvo.setForca(alvo.getForca() - 2);

        super.atacar(alvo, ataque);
    }
    
}
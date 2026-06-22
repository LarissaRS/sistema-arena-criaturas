package criaturas;

import habilidades.HabilidadeEspecial;
import model.Criatura;
import model.Ataque;

public class Fenix extends Criatura implements HabilidadeEspecial {

    public FeniX(String nome){
        super(nome, "Luz" , 25, 20, 110);
    }

    @Override
    public void usarHabilidadeEspecial() {

        setPontosDeVida(getPontosDeVida() + 30);

        System.out.println(getNome() + " renasceu das cinzas e recuperou 30 pontos de vida!");
    }
}
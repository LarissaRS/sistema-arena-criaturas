public class AfinidadeTerra extends HabilidadePassiva {

    public AfinidadeTerra() {
        super("Afinidade de Terra");
    }

    @Override
    public int modificarDano(Criatura atacante, Criatura alvo, int dano) {

        if (alvo.getTipo().equals("Água")) {
            return dano + 10;
        }

        if (alvo.getTipo().equals("Ar")) {
            return dano - 10;
        }

        return dano;
    }
}
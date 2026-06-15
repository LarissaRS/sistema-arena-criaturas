public class AfinidadeAr extends HabilidadePassiva {

    public AfinidadeAr() {
        super("Afinidade de Ar");
    }

    @Override
    public int modificarDano(Criatura atacante, Criatura alvo, int dano) {

        if (alvo.getTipo().equals("Terra")) {
            return dano + 10;
        }

        if (alvo.getTipo().equals("Fogo")) {
            return dano - 10;
        }

        return dano;
    }
}
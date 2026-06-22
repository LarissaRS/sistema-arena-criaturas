package habilidades;

import model.Criatura;

public interface HabilidadePassiva {
    double aplicarAfinidade(Criatura.Tipo tipoInimigo);
}
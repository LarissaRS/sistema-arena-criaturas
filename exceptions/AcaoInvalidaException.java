package exceptions;

/**
 * Exceção para ações inválidas na batalha.
 *
 * @author Larissa Rocha e João Antônio
 */
public class AcaoInvalidaException extends Exception {

    public AcaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}

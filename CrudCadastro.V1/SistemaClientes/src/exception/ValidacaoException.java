package exception;

import java.util.Map;

// Exceção personalizada para erros de validação de campos
public class ValidacaoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private final Map<String, String> erros;

    // Construtor: recebe mapa de erros de validação
    public ValidacaoException(Map<String, String> erros) {
        super("Erro de validação nos campos.");
        this.erros = erros;
    }

    // Retorna os erros de validação
    public Map<String, String> getErros() {
        return erros;
    }
}

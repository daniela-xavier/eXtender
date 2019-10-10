/**
 * ResponseMessage.java
 * Created on 10 de out de 2019
 * 
 *
 */

package view.response;

import view.model.EntityApplication;

/**
 * 
 * Description the class  ResponseMessage.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public class ResponseMessage  extends EntityApplication {

    private final Boolean hasError;
    private final String message;

    /**
     * Construtor com parametros.
     * @param hasError - Se há erro ou não na resposta.
     * @param message - Se há mensagem de erro ou não.
     */
    public ResponseMessage(Boolean hasError, String message) {
        this.hasError = hasError;
        this.message = message;
    }

    /**
     * Método que retorna o estado de erro.
     * @return Boolean - (true - com erro, false - sem erro).
     */
    public Boolean getHasError() {
        return hasError;
    }

    /**
     * Método de recuperação da mensagem.
     * @return String
     */
    public String getMessage() {
        return message;
    }
}


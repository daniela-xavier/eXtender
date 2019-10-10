/**
 * ExceptionResponse.java
 * Created on 10 de out de 2019
 * 
 *
 */

package view.response;

import org.springframework.http.HttpStatus;

/**
 * 
 * Description the class  ExceptionResponse.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public class ExceptionResponse extends RuntimeException {

    private final String message;
    private final HttpStatus httpStatus;

    /**
     * Construtor da classe com parametro.
     *
     * @param message - retorna message
     * @param httpStatus - retorna http status
     */
    public ExceptionResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    /**
     * Metodo de recuperacao de mensagem.
     *
     * @return String
     */
    @Override
    public String getMessage() {
        return message;
    }

    /**
     * Metodo de recuperacao de Http Status.
     *
     * @return HttpStatus
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}

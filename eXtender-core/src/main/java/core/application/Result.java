/**
 * Result.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core.application;

import com.google.gson.annotations.Expose;

import model.DomainEntity;


/**
 * 
 * Description the class Result.java
 *
 * @Autor daniela.conceicao
 * @since
 * @version %I%, %G%
 */
public class Result {
	@Expose
	private String message;

	@Expose
	private Iterable<DomainEntity> entity;

	@Expose
	private boolean error;

		
	
	public Result(String message) {
		super();
		this.message = message;
		this.setError();
	}
	
	public Result(String message, Iterable<DomainEntity> entity) {
		super();
		this.message = message;
		this.setEntity(entity);
	}

	/**
	 * Método de recuperação do campo entity
	 *
	 * @return valor do campo entity
	 */
	public Iterable<DomainEntity> getEntity() {
		return entity;
	}

	/**
	 * Valor de entity atribuído a entity
	 *
	 * @param entity
	 *            Atributo da Classe
	 */
	private void setEntity(Iterable<DomainEntity> entity) {
		this.entity = entity;
	}

	/**
	 * Método de recuperação do campo error.
	 *
	 * @return error (true - contém erro ou false - não contém erro.)
	 */
	public boolean hasError() {
		return this.error;
	}

	/**
	 * Método que atribui true (contém erro) a variável error.
	 */
	private void setError() {
		this.error = true;
	}
	
	 /**
     * Método de recuperação do campo message
     *
     * @return valor do campo message
     */
    public String getMessage() {
        return message;
    }
}

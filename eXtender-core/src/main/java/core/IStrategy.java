/**
 * IStrategy.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core;

import model.DomainEntity;

/**
 * 
 * Description the class  IStrategy.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public interface IStrategy {
	 /**
     * Método que realiza o process do método strategy.
     * @param entidade
     * @return String
     */
    public String process(DomainEntity entidade);
}

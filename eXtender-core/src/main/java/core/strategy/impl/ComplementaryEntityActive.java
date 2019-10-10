/**
 * ComplementaryEntityActive.java
 * Created on 10 de out de 2019
 * 
 *
 */

package core.strategy.impl;

import core.IStrategy;
import model.DomainEntity;

/**
 * 
 * Description the class ComplementaryEntityActive.java
 *
 * @Autor daniela.conceicao
 * @since
 * @version %I%, %G%
 */
public class ComplementaryEntityActive implements IStrategy {

	/**
	 * Método que realiza o process do método strategy, Adiciona ativo na entidade
	 * passada por parametro.
	 * 
	 * @param entity
	 * @return String
	 */
	@Override
	public String process(DomainEntity entity) {
		entity.ativarDomainEntity();
		return null;
	}

}

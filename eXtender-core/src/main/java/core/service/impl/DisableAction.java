/**
 * DisableAction.java
 * Created on 10 de out de 2019
 * 
 *
 */

package core.service.impl;

import org.springframework.stereotype.Service;

import core.IStrategy;
import model.DomainEntity;

/**
 * 
 * Description the class DisableAction.java
 *
 * @Autor daniela.conceicao
 * @since
 * @version %I%, %G%
 */
@Service("disableAction")
public class DisableAction implements IStrategy {

	/**
	 * Método que não permite a execução desta ação.
	 *
	 * @param entity
	 * @return String
	 */
	@Override
	public String process(DomainEntity entity) {
		return "Processo inválido. Não é possível executar esta ação.";
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}

}

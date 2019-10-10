/**
 * ComplementaryEntityIncludedInBy.java
 * Created on 10 de out de 2019
 * 
 *
 */

package core.strategy.impl;

import java.util.Calendar;
import java.util.Date;

import core.IStrategy;
import model.DomainEntity;

/**
 * 
 * Description the class  ComplementaryEntityIncludedInBy.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public class ComplementaryEntityIncludedInBy implements IStrategy {

    /**
     * Método que realiza o process do método strategy, Adiciona usuario
     * 'SISTEMA' e a data atual na entity passada por parametro, atributos
     * de inclusao.
     *
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
    	
    	String nome = "SISTEMA";
		Date data = Calendar.getInstance().getTime();

		try {
			entity.includedDomainEntity(data, nome);
		} catch (Exception e) {
			return(e.getMessage());
		}

		return null;
    }
}

/**
 * LogExclude.java
 * Created on 10 de out de 2019
 * 
 *
 */

package core.strategy.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.IStrategy;
import model.DomainEntity;

/**
 * 
 * Description the class  LogExclude.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public class LogSearch implements IStrategy {

    /**
     * Método que não permite a execução desta ação.
     *
     * @param entity
     * @return String
     */
    @Override
    public String process(DomainEntity entity) {
    	
    	//codigo para verificar se processo de busca pode ou não ser realizado.
    	
    	 Logger logger = LoggerFactory.getLogger(entity.getClass().getSimpleName());    	 
		 logger.info("Processo inválido. Não é possível executar esta ação de busca."); 
		     		    	    	
        return "Processo inválido. Não é possível executar esta ação.";
    }
}

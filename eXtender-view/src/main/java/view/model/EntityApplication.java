/**
 * EntityApplication.java
 * Created on 9 de out de 2019
 * 
 *
 */

package view.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Description the class  EntityApplication.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public class EntityApplication {
	/**
     * Método de log das Entidades por classe.
     * @param clazz
     * @return Logger
     */
    public Logger getLogger(Class<?> clazz) {  	
        return LoggerFactory.getLogger(clazz.getName());
    }
}

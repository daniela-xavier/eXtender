/**
 * ADomainEntity.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * Description the class ADomainEntity.java
 *
 * @Autor daniela.conceicao
 * @since
 * @version %I%, %G%
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ADomainEntity {
	/**
	 * Atributo de nome da entidade.
	 * 
	 * @return nome
	 */
	String nome();

	/**
	 * Retorna a classe da entidade.
	 * 
	 * @return Class Entity
	 */
	Class<?> classe();
}

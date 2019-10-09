/**
 * IRepository.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core;

import java.util.List;

import model.DomainEntity;

/**
 * 
 * Description the class IRepository.java
 *
 * @Autor daniela.conceicao
 * @since
 * @version %I%, %G%
 */
public interface IRepository {

	// Toda classe Repository deve conter a anotação.
	// @Component("<nameEntity>Repository")

	/**
	 * Método que salva a entidade fornecida no método.
	 *
	 * @param entity
	 * @return List<'DomainEntity'>
	 */
	public List<DomainEntity> save(final DomainEntity entity);

	/**
	 * Método que altera a entidade fornecida no método.
	 *
	 * @param entity
	 * @return List<'DomainEntity'>
	 */
	public List<DomainEntity> update(final DomainEntity entity);

	/**
	 * Método que deleta a entidade, por meio do id fornecido no método.
	 *
	 * @param id
	 * @return List<'DomainEntity'>
	 */
	public List<DomainEntity> delete(final Long id);

	/**
	 * Método que desativa a entidade fornecida no método.
	 *
	 * @param entity
	 * @return List<'DomainEntity'>
	 */
	public List<DomainEntity> disable(final DomainEntity entity);

	/**
	 * Método que busca a entidade fornecida, com filtro em seus atributos.
	 *
	 * @param entity
	 * @return List<'DomainEntity'>
	 */
	public List<DomainEntity> findByFilter(final DomainEntity entity);

	/**
	 * Método que busca a entidade fornecida, com filtro em seus atributos.
	 *
	 * @return List<'DomainEntity'>
	 */
	public List<DomainEntity> findAll();

	/**
	 * Método que busca a entidade, por meio do id fornecido.
	 *
	 * @param id
	 * @return List<'DomainEntity'>
	 */
	public List<DomainEntity> findById(final Long id);

}

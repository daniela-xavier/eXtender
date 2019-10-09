/**
 * IDAO.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core;

import java.util.List;

/**
 * 
 * Description the class  IDAO.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public interface IDAO<DomainEntity> {

    /**
     * Toda classe DAO deve conter as anotações. 
     * @Component("<nameEntity>DAO")
     * @Repository
     */
    
    /**
     * Método que realiza a pesquisa de entidade por id.
     *
     * @param id
     * @return domainEntity
     */
    public DomainEntity findOne(final long id);

    /**
     * Método de pesquisa de todas as entidades.
     *
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> findAll();

    /**
     * Método de pesquisa de todas as entidades, com o valor de inicio e fim da
     * lista.
     *
     * @param begin
     * @param end
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> findByMaxList(final int begin,final int end);

    /**
     * Método de pesquisa de entidade por critérios.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    public List<DomainEntity> findByCriteria(final DomainEntity entity);

    /**
     * Método que salva a entidade.
     *
     * @param entity
     */
    public void save(final DomainEntity entity);

    /**
     * Método que atualiza entidade.
     *
     * @param entity
     * @return domainEntity
     */
    public DomainEntity update(final DomainEntity entity);

    /**
     * Método que deleta a entidade.
     *
     * @param entity
     */
    public void delete(final DomainEntity entity);

    /**
     * Método que deleta a entidade por id.
     *
     * @param id
     */
    public void deleteById(final long id);
}

/**
 * DAOImp.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core.dao.impl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

import core.IDAO;
/**
 * 
 * Description the class  DAOImp.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public abstract class DAOImp<DomainEntity> implements IDAO<DomainEntity> {

    /**
     * EntityManager para conexao e relação com o banco
     */
    @PersistenceContext
    protected EntityManager em;

    /**
     * 
     */
    private final Class<DomainEntity> type;

    /**
     * Construtor da classe que atribui o tipo da classe implementada pelo
     * contrato.
     */
    public DAOImp() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }

    /**
     * Método que realiza a pesquisa de entity por id.
     *
     * @param id
     * @return domainEntity
     */
    @Override
    public DomainEntity findOne(final long id) {
        return (DomainEntity) this.em.find(type, id);
    }

    /**
     * Método de pesquisa de todas as entitys.
     *
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findAll() {
        return this.em.createQuery("from " + type.getSimpleName()).getResultList();
    }

    /**
     * Método de pesquisa de todas as entitys, com o valor de inicio e fim da
     * lista.
     *
     * @param begin
     * @param end
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findByMaxList(final int begin, final int end) {
        Session session = (Session) this.em.getDelegate();
        Criteria crit = session.createCriteria(type.getClass());

        List<DomainEntity> result = new ArrayList<DomainEntity>();
        crit.setFirstResult(begin);
        crit.setMaxResults(end);
        result = crit.list();

        return result;
    }

    /**
     * Método de pesquisa de entity por critérios.
     *
     * @param entity
     * @return List<'DomainEntity'>
     */
    @Override
    public List<DomainEntity> findByCriteria(final DomainEntity entity) {
        return null;
    }

    /**
     * Método que salva a entity.
     *
     * @param entity
     */
    @Override
    public void save(final DomainEntity entity) {
        this.em.persist(entity);
    }

    /**
     * Método que atualiza entity.
     *
     * @param entity
     * @return domainEntity
     */
    @Override
    public DomainEntity update(final DomainEntity entity) {
        return (DomainEntity) this.em.merge(entity);
    }

    /**
     * Método que deleta a entity.
     *
     * @param entity
     */
    @Override
    public void delete(final DomainEntity entity) {
        //this.em.remove(entity);
        this.em.merge(entity);
    }

    /**
     * Método que deleta a entity por id.
     *
     * @param id
     */
    @Override
    public void deleteById(final long id) {
        final DomainEntity entity = findOne(id);
        this.em.remove(entity);
    }

}


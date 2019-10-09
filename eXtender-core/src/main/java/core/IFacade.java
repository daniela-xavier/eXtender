/**
 * IFacade.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core;

import core.application.Result;
import model.DomainEntity;

/**
 * 
 * Description the class  IFacade.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
@Component
public interface IFacade {

    /**
     * Método que salva entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result save(DomainEntity entity, IService service);

    /**
     * Método que altera entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result update(DomainEntity entity, IService service);

    /**
     * Método que delete entity.
     *
     * @param id
     * @param service
     * @return Result
     */
    public Result delete(Long id, IService service);
    
    /**
     * Método que desativa entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result disable(DomainEntity entity, IService service);

    /**
     * Método que consulta entity.
     *
     * @param classe 
     * @param service
     * @return Result
     */
    public Result findAll(Class classe, IService service);
    /**
     * Método que consulta entity.
     *
     * @param id 
     * @param service
     * @return Result
     */
    public Result findById(Long id, IService service);
    /**
     * Método que consulta entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result FindByFilter(DomainEntity entity, IService service);
    
   
    /**
     * Método que visualiza entity.
     *
     * @param entity
     * @param service
     * @return Result
     */
    public Result view(DomainEntity entity, IService service);

}


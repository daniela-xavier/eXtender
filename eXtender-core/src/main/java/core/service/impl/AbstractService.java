/**
 * AbstractService.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core.service.impl;

import model.anotations.ADomainEntity;

/**
 * 
 * Description the class  AbstractService.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
public  abstract class AbstractService {

    /**
     * Método que recupera a classe de DomainEntity -> Service.class instanciada.
     *
     * @return Classe DomainEntity 
     */
    public Class<?> getClasse() {

        ADomainEntity annotation = this.getClass().getAnnotation(ADomainEntity.class);
        if (annotation != null) {
            return annotation.classe();
        }

        return null;
    }

    /**
     * Método que recupera o nome da entidade de  DomainEntity Service.class
     * instanciada.
     *
     * @return  DomainEntity 
     */
    public String getEntidadeNome() {

        ADomainEntity annotation = this.getClass().getAnnotation(ADomainEntity.class);
        if (annotation != null) {
            return annotation.nome();
        }

        return null;
    }

}



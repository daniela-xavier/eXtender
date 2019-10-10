/**
 * IController.java
 * Created on 10 de out de 2019
 * 
 *
 */

package view.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import core.IService;
import model.DomainEntity;

/**
 * 
 * Description the class  IController.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 * @param <T>
 */
public interface IController<T> {
		
	public ResponseEntity getEntityById(String id);
	public ResponseEntity getEntityByFiltro(DomainEntity entity, BindingResult result);
	public ResponseEntity createEntity(DomainEntity entity, BindingResult result);
	public ResponseEntity updateEntity(DomainEntity entity, BindingResult result);
	public ResponseEntity deleteEntity(String id);
	public ResponseEntity disableEntity(DomainEntity entity, BindingResult result);
	
	IService getService(String nomeClasse);
	
	String getErrors(BindingResult bindingResult);
	
	
}

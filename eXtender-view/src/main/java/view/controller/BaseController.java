/**
 * BaseController.java
 * Created on 10 de out de 2019
 * 
 *
 */

package view.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import view.model.EntityApplication;

/**
 * 
 * Description the class  BaseController.java 
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class BaseController extends EntityApplication {
}


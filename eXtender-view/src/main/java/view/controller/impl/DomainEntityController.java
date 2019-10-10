/**
 * Controller.java
 * Created on 10 de out de 2019
 * 
 *
 */

package view.controller.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.google.gson.Gson;

import core.IFacade;
import core.IService;
import core.application.Result;
import model.DomainEntity;
import view.controller.BaseController;
import view.controller.IController;
import view.response.ExceptionResponse;
import view.response.ResponseMessage;

/**
 * 
 * Description the class Controller.java
 *
 * @Autor daniela.conceicao
 * @since
 * @version %I%, %G%
 */
public class DomainEntityController<T extends DomainEntity> extends BaseController implements IController {

	/**
	 * Variavel para o padrao facade.
	 */
	@Autowired
	@Qualifier("facade")
	protected IFacade fachada;

	/**
	 * Variavel para os mapas de servicos das classes.
	 */
	@Autowired
	protected Map<String, IService> servico;

	/**
	 * Classe de cada entidade instanciada.
	 */
	protected Class<? extends T> clazz;

	/**
	 * Construtor da classe com parametros de classe Entity.
	 *
	 * @param clazz
	 *            - Classe da entidade
	 */
	public DomainEntityController(Class<? extends T> clazz) {
		this.clazz = clazz;
	}

	/**
	 * Construtor da classe sem parametros.
	 */
	public DomainEntityController() {
	}

	@Override
	public ResponseEntity getEntityById(String id) {
		try {
			IService entidadeServico = getService(clazz.getSimpleName());
			Result resultado;

			if (!id.isEmpty()) {
				Long longId = Long.parseLong(id);
				resultado = fachada.findById(longId, entidadeServico);
			} else {
				resultado = fachada.findAll(clazz, entidadeServico);
			}

			Iterable<DomainEntity> t = resultado.getEntity();

			if (resultado.hasError()) {
				return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, resultado.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<>(t, HttpStatus.OK);

		} catch (ExceptionResponse e) {
			return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NumberFormatException e) {
			System.out.println("Error.: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			System.out.println("Error.: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity getEntityByFiltro(DomainEntity entity, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, getErrors(result)),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			IService entidadeServico = getService(clazz.getSimpleName());
			Result resultado = fachada.FindByFilter(entity, entidadeServico);

			if (resultado.hasError()) {
				return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, resultado.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(resultado, HttpStatus.OK);

		} catch (ExceptionResponse e) {
			return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			System.out.println("Error.: " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseMessage(Boolean.TRUE, "Erro ao cadastrar ".concat(clazz.getSimpleName().toLowerCase())),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity createEntity(DomainEntity entity, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, getErrors(result)),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		Result resultado = null;
		HttpStatus httpStatus;

		try {
			IService entidadeServico = getService(clazz.getSimpleName());
			resultado = fachada.save(entity, entidadeServico);

			if (resultado.hasError()) {
				httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			} else {
				httpStatus = HttpStatus.OK;
				Gson objGson = new Gson();
				String json = objGson.toJson(resultado);
				return new ResponseEntity<>(json, httpStatus);

			}
		} catch (ExceptionResponse e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			resultado = new Result("Erro.".concat(e.getMessage()));

		} catch (Exception e) {
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
			resultado = new Result("Erro ao cadastrar ".concat(clazz.getSimpleName().toLowerCase()));
		}

		return new ResponseEntity<>(new ResponseMessage(resultado.hasError(), resultado.getMessage()), httpStatus);

	}

	@Override
	public ResponseEntity updateEntity(DomainEntity entity, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, getErrors(result)),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			IService entidadeServico = getService(clazz.getSimpleName());
			Result resultado = fachada.update(entity, entidadeServico);

			if (resultado.hasError()) {
				return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, resultado.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(entity, HttpStatus.OK);

		} catch (ExceptionResponse e) {
			return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			System.out.println("Error.: " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseMessage(Boolean.TRUE, "Erro ao atualizar ".concat(clazz.getSimpleName().toLowerCase())),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity deleteEntity(String id) {

		try {
			IService entidadeServico = getService(clazz.getSimpleName());
			Result resultado;

			if (!id.isEmpty()) {
				Long longId = Long.parseLong(id);
				resultado = fachada.delete(longId, entidadeServico);
			} else {
				return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, "Item id obrigat�rio"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}

			Iterable<DomainEntity> t = resultado.getEntity();
			return new ResponseEntity<>(resultado, HttpStatus.OK);

		} catch (ExceptionResponse e) {
			return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (NumberFormatException e) {
			System.out.println("Error.: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			System.out.println("Error.: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity disableEntity(DomainEntity entity, BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, getErrors(result)),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		try {
			IService entidadeServico = getService(clazz.getSimpleName());
			Result resultado = fachada.disable(entity, entidadeServico);

			if (resultado.hasError()) {
				return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, resultado.getMessage()),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(entity, HttpStatus.OK);

		} catch (ExceptionResponse e) {
			return new ResponseEntity<>(new ResponseMessage(Boolean.TRUE, "Erro.".concat(e.getMessage())),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			System.out.println("Error.: " + e.getMessage());
			return new ResponseEntity<>(
					new ResponseMessage(Boolean.TRUE, "Erro ao atualizar ".concat(clazz.getSimpleName().toLowerCase())),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public IService getService(String nomeClasse) {
		String service = nomeClasse.toLowerCase().concat("Service");

		if (servico.containsKey(service)) {
			return servico.get(service);
		} else {
			throw new ExceptionResponse("Execucao nao permitida.", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public String getErrors(BindingResult bindingResult) {
		StringBuilder mgs = new StringBuilder();

		List<FieldError> errors = bindingResult.getFieldErrors();
		errors.forEach((error) -> {
			mgs.append(error.getDefaultMessage()).append(";");
		});
		return mgs.toString();
	}

}

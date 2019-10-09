/**
 * Facade.java
 * Created on 9 de out de 2019
 * 
 *
 */

package core.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import core.IFacade;
import core.IService;
import core.IStrategy;
import core.application.Result;
import model.DomainEntity;

/**
 * 
 * Description the class Facade.java
 *
 * @Autor daniela.conceicao
 * @since
 * @version %I%, %G%
 */
@Component("facade")
public class Facade implements IFacade {

	private Result resultado;

	/**
	 * Contrutor da classe.
	 */
	public Facade() {
	}

	/**
	 * Método que realiza as regras para a operação salvar para a entity passada por
	 * parametro e metodo salvar do repositorio do serviço.
	 *
	 * @param entity
	 * @param servico
	 * @return Result
	 */
	@Override
	public Result save(DomainEntity entity, IService servico) {

		String msg = executarRegras(entity, "SALVAR", servico.getStrategys());

		if (msg != null) {
			resultado = new Result(msg);

		} else {
			try {
				servico.getRepository().save(entity);
				List<DomainEntity> entitys = new ArrayList<DomainEntity>();
				entitys.add(entity);

				resultado = new Result("Cadastro realizado com sucesso.", entitys);

			} catch (Exception e) {
				System.out.println("Exception: " + e.toString() + " Message: " + e.getMessage());
				resultado = new Result("Cadastro não realizado.");
			}
		}

		return resultado;
	}

	/**
	 * Método que realiza as regras para a operação alterar para a entity passada
	 * por parametro e metodo alterar do repositorio do serviço.
	 *
	 * @param entity
	 * @param servico
	 * @return Result
	 */
	@Override
	public Result update(DomainEntity entity, IService servico) {

		String msg = executarRegras(entity, "ALTERAR", servico.getStrategys());

		if (msg != null) {
			resultado = new Result(msg);

		} else {
			try {
				servico.getRepository().update(entity);
				List<DomainEntity> entitys = new ArrayList<DomainEntity>();
				entitys.add(entity);

				resultado = new Result("Atualização realizada com sucesso.", entitys);

			} catch (Exception e) {
				resultado = new Result("Exception: " + e.toString() + " Message: " + e.getMessage());
			}
		}
		return resultado;
	}

	/**
	 * Método que realiza as regras para a operação deletar para a entity passada
	 * por parametro e metodo deletar do repositorio do serviço.
	 *
	 * @param id
	 * @param servico
	 * @return Result
	 */
	@Override
	public Result delete(Long id, IService servico) {

		DomainEntity entity = null;
		try {
			entity = (DomainEntity) servico.getClasse().newInstance();
		} catch (IllegalAccessException | InstantiationException ex) {
			resultado = new Result(
					"Entity não pode ser instanciada. Exception: " + ex.toString() + " Message: " + ex.getMessage());
			return resultado;
		}
		String msg = executarRegras(entity, "EXCLUIR", servico.getStrategys());

		if (msg != null) {
			resultado = new Result(msg);

		} else {
			try {
				List<DomainEntity> entitys = servico.getRepository().delete(id);
				if (entitys == null) {
					resultado = new Result("Exclusão não executada, por gentileza verifique seus dados!");
				} else {
					resultado = new Result("Exclusão realizada com sucesso!", entitys);
				}
			} catch (Exception e) {

				resultado = new Result("Exception: " + e.toString() + " Message: " + e.getMessage());
			}
		}

		return resultado;
	}

	/**
	 * Método que realiza as regras para a operação alterar para a entity passada
	 * por parametro e metodo alterar do repositorio do serviço.
	 *
	 * @param entity
	 * @param servico
	 * @return Result
	 */
	@Override
	public Result disable(DomainEntity entity, IService servico) {

		String msg = executarRegras(entity, "ALTERAR", servico.getStrategys());

		if (msg != null) {
			resultado = new Result(msg);

		} else {
			try {
				servico.getRepository().disable(entity);
				List<DomainEntity> entitys = new ArrayList<DomainEntity>();

				if (entitys == null) {
					resultado = new Result("Desativação não executada, por gentileza verifique seus dados!");
				} else {
					entitys.add(entity);
					resultado = new Result("Desativação realizada com sucesso!", entitys);
				}
			} catch (Exception e) {
				resultado = new Result("Exception: " + e.toString() + " Message: " + e.getMessage());
			}
		}
		return resultado;
	}

	/**
	 * Método que realiza as regras para a operação consultar para a entity passada
	 * por parametro e metodo consultar todos do repositorio do serviço.
	 *
	 * @param classe
	 * @param servico
	 * @return Result
	 */
	@Override
	public Result findAll(Class classe, IService servico) {

		DomainEntity entity = null;

		try {
			entity = (DomainEntity) servico.getClasse().newInstance();
		} catch (IllegalAccessException | InstantiationException ex) {
			resultado = new Result(
					"Entity não pode ser instanciada. Exception: " + ex.toString() + " Message: " + ex.getMessage());
			return resultado;
		}

		String msg = executarRegras(entity, "CONSULTAR", servico.getStrategys());

		if (msg != null) {
			resultado = new Result(msg);

		} else {
			try {
				List<DomainEntity> findAll = servico.getRepository().findAll();
				if (findAll == null) {
					resultado = new Result("Busca não encontrada, por favor verifique as dados digitados!");
					return resultado;
				}
				resultado = new Result("Busca realizada!", findAll);

			} catch (Exception e) {
				resultado = new Result("Exception: " + e.toString() + " Message: " + e.getMessage());
			}
		}

		return resultado;

	}

	/**
	 * Método que realiza as regras para a operação consultar para a entity passada
	 * por parametro e metodo consultar por id do repositorio do serviço.
	 *
	 * @param id
	 * @param servico
	 * @return Result
	 */
	@Override
	public Result findById(Long id, IService servico) {

		DomainEntity entity = null;
		try {
			entity = (DomainEntity) servico.getClasse().newInstance();
		} catch (IllegalAccessException | InstantiationException ex) {
			resultado = new Result(
					"Entity não pode ser instanciada. Exception: " + ex.toString() + " Message: " + ex.getMessage());
			return resultado;
		}
		String msg = executarRegras(entity, "CONSULTAR", servico.getStrategys());

		if (msg != null) {
			resultado = new Result(msg);
		} else {
			try {
				List<DomainEntity> entitys = servico.getRepository().findById(id);

				if (entitys == null) {
					resultado = new Result("Busca não encontrada, por favor verifique as dados digitados!", entitys);
				} else {
					resultado = new Result("Busca realizada!", entitys);
				}

			} catch (Exception e) {
				resultado = new Result("Exception: " + e.toString() + " Message: " + e.getMessage());
			}
		}

		return resultado;

	}

	/**
	 * Método que realiza as regras para a operação consultar para a entity passada
	 * por parametro e metodo consultar por filtro do repositorio do serviço.
	 *
	 * @param entity
	 * @param servico
	 * @return Result
	 */
	@Override
	public Result FindByFilter(DomainEntity entity, IService servico) {

		String msg = executarRegras(entity, "CONSULTAR", servico.getStrategys());

		if (msg != null) {
			resultado = new Result(msg);
		} else {
			try {
				Iterable<DomainEntity> findAll = servico.getRepository().findByFilter(entity);
				if (findAll == null) {
					resultado = new Result("Busca não encontrada, por favor verifique as dados digitados!");
				} else {
					resultado = new Result("Busca realizada!", findAll);
				}
			} catch (Exception e) {
				resultado = new Result("Exception: " + e.toString() + " Message: " + e.getMessage());
			}
		}

		return resultado;
	}

	/**
	 * Método que realiza as regras para a operação visualizar para a entity passada
	 * por parametro.
	 *
	 * @param servico
	 * @return Result
	 */
	@Override
	public Result view(DomainEntity entity, IService servico) {

		String msg = executarRegras(entity, "VISUALIZAR", servico.getStrategys());

		if (msg != null) {
			resultado = new Result(msg);
		} else {
			List<DomainEntity> list = new ArrayList<DomainEntity>();
			list.add(entity);
			resultado = new Result("Visualização executada!", list);
		}
		return resultado;

	}

	/**
	 * Método que executa as regras de acordo com a ação e entidade.
	 *
	 * @param entity
	 * @param action
	 * @param roles
	 * @return String
	 */
	private String executarRegras(DomainEntity entity, String action, Map<String, List<IStrategy>> roles) {

		StringBuilder msg = new StringBuilder();

		if (roles != null) {
			List<IStrategy> regras = roles.get(action);

			if (regras != null) {
				for (IStrategy s : regras) {

					String m = s.process(entity);
					if (m != null) {
						// throw new RuntimeException("Não foi possivel realizar operação. Mensagem: " +
						// m);
						msg.append(m);
						break;
					}
				}
			}
		}

		if (msg.length() > 0) {
			return msg.toString();
		} else {
			return null;
		}
	}

}

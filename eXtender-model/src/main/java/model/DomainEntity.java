/**
 * DomainEntity.java
 * Created on 9 de out de 2019
 * 
 *
 */

package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.google.gson.annotations.Expose;

import model.anotations.ActivePattern;
import model.interfaces.OnSave;
import model.interfaces.OnUpdate;

/**
 * 
 * Classe de objeto real DomainEntity.
 *
 * @Autor daniela.conceicao 
 * @since
 * @version  %I%, %G% 
 */
@MappedSuperclass
public class DomainEntity implements IEntity, Serializable {

    private static final long serialVersionUID = -5377726703339445533L;

    @Expose
    @Column(name = "INCLUIDO_EM")
    @NotNull(message = "Item incluido em inválido", groups = {OnSave.class})
    @Temporal(TemporalType.TIMESTAMP)
    private Date includedIn;

    @Expose
    @Column(name = "ALTERADO_EM")
    @NotNull(message = "Item alterado em inválido", groups = {OnUpdate.class})
    @Temporal(TemporalType.TIMESTAMP)
    private Date changedIn;

    @Expose
    @NotEmpty(message = "Item incluido por inválido", groups = {OnSave.class})
    @Column(name = "INCLUIDO_POR")
    private String includedBy;

    @Expose
    @Column(name = "ALTERADO_POR")
    @NotEmpty(message = "Item alterado por inválido", groups = {OnUpdate.class})
    private String changedBy;

    @Expose
    @NotNull(message = "Item ativo inválido", groups = {OnSave.class})
    @NotEmpty(message = "Item ativo não pode estar em branco", groups = {OnSave.class})
    @ActivePattern(message = "Item ativo deve ser Sim(s) ou Não(n)", groups = {OnSave.class, OnUpdate.class})
    @Column(name = "ATIVO")
    private String active;

    @Transient
    @Expose
    private String tk;
       
    
    
    public DomainEntity() {		
	}

	/**
     * Método para alteração de includedIn e changedBy entidade.
     * @param includedIn
     * @param changedBy
     */    
    
    public void includedDomainEntity(@NotNull(message = "Data de alteração inválida", groups = OnUpdate.class) Date includedIn,
			@NotEmpty(message = "Usuário de alteração inválido", groups = OnUpdate.class) String includedBy) {		
		
    	if (this.includedBy.isEmpty()) {
    		this.includedBy = includedBy;
		} 

		if (this.includedIn == null) {
			this.includedIn = includedIn;
		}    	
		
	}
    
    /**
     * Método para adicionar de changedIn e changedBy entidade.
     * @param changedIn
     * @param changedBy
     */    
    
    public void chancedDomainEntity(@NotNull(message = "Data de alteração inválida", groups = OnUpdate.class) Date changedIn,
			@NotEmpty(message = "Usuário de alteração inválido", groups = OnUpdate.class) String changedBy) {		
		
    	if (this.changedBy.isEmpty()) {
    		this.changedBy = changedBy;
		} 

		if (this.changedIn == null) {
			this.changedIn = changedIn;
		}    	
		
	}

	/**
	 * 
     * Inclui o ativo = N, para desativar a entidade.
     */
    public void desativarDomainEntity() {
    	this.active ="N";
    }

    /**
     * Inclui o ativo = S, para sativar a entidade.
     */
    public void ativarDomainEntity() {
    	this.active ="S";
    }
    
    

}

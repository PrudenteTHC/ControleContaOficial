package com.controleconta.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * 
 * @author Thiago Henrique Carvalho Prudente
 *
 */

@Entity
@Table(name="conta")
public class Conta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
	
	private String descricao;
	
	private boolean tipo;
	
	private Long valor;
	
	@Temporal(TemporalType.DATE)
	private Calendar vencimento;
	
	@Transient
	private String vencFormatted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Calendar getVencimento() {
		return vencimento;
	}

	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}

	public String getVencFormatted() {
		vencFormatted = new SimpleDateFormat("dd/MM/yyyy").format(vencimento.getTime());
		return vencFormatted;
	}

	public void setVencFormatted(String vencFormatted) {
		this.vencFormatted = vencFormatted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

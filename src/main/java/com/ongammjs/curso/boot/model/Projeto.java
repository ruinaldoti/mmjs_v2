package com.ongammjs.curso.boot.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome_projeto")
	private String nome;
	
	
	private LocalDateTime dataInicio;
	
	
	private LocalDateTime dataTermino;
	
	private Integer metaBeneficiario;
	
	@ManyToOne
	private TipoProjeto tipoProjeto;
	
	@Enumerated(EnumType.STRING)
	private StatusProjeto status = StatusProjeto.ATIVO;
	
	public Projeto() {
		
	}
	
	
	
	public Projeto(String nome, LocalDateTime dataInicio, LocalDateTime dataTermino, Integer metaBeneficiario,
			TipoProjeto tipoProjeto) {
		super();
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.metaBeneficiario = metaBeneficiario;
		this.tipoProjeto = tipoProjeto;
		
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public TipoProjeto getTipoProjeto() {
		return tipoProjeto;
	}
	public void setTipoProjeto(TipoProjeto tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDateTime getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDateTime getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(LocalDateTime dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Integer getMetaBeneficiario() {
		return metaBeneficiario;
	}
	public void setMetaBeneficiario(Integer metaBeneficiario) {
		this.metaBeneficiario = metaBeneficiario;
	}
	public StatusProjeto getStatus() {
		return status;
	}
	public void setStatus(StatusProjeto status) {
		this.status = status;
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
		Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}

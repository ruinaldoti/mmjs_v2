package com.ongammjs.curso.boot.controller.form;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ongammjs.curso.boot.model.Projeto;
import com.ongammjs.curso.boot.model.TipoProjeto;
import com.ongammjs.curso.boot.repository.TipoProjetoRepository;


public class ProjetoForm {
	
	private String nome;
	
	@JsonIgnore
	private LocalDateTime dataInicio;
	
	@JsonIgnore
	private LocalDateTime dataTermino;
	
	private Integer metaBeneficiario;
	
	private String descricaoTipoProjeto;
	
	
	
	public String getDescricaoTipoProjeto() {
		return descricaoTipoProjeto;
	}
	
	public void setDescricaoTipoProjeto(String descricaoTipoProjeto) {
		this.descricaoTipoProjeto = descricaoTipoProjeto;
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
	
	
	public Projeto converter(TipoProjetoRepository tipoProjetoRepository) {
		TipoProjeto tipoProjeto = tipoProjetoRepository.findByDescricao(descricaoTipoProjeto);
		return new Projeto(nome, dataInicio, dataTermino, metaBeneficiario, tipoProjeto);
		
	}
	
	
	
	
	

	
}

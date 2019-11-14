package com.ongammjs.curso.boot.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.ongammjs.curso.boot.model.Projeto;


public class ProjetoDto {
	
	private Long id;
	private String nome;
	private LocalDateTime dataInicio;
	private LocalDateTime dataTermino;
	private Integer metaBeneficiario;
	private String tipoProjeto;
	private String status;

	
	public ProjetoDto(Projeto projeto) {
		
		this.id = projeto.getId();
		this.nome = projeto.getNome();
		this.dataInicio = projeto.getDataInicio();
		this.dataTermino = projeto.getDataTermino();
		this.metaBeneficiario = projeto.getMetaBeneficiario();
		this.status = projeto.getStatus().name();
		this.tipoProjeto = projeto.getTipoProjeto().getDescricao();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
		
	public String getTipoProjeto() {
		return tipoProjeto;
	}

	public void setTipoProjeto(String tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static List<ProjetoDto> converter(List<Projeto> projeto) {
		return projeto.stream().map(ProjetoDto::new).collect(Collectors.toList());
	}
	
	
	

}

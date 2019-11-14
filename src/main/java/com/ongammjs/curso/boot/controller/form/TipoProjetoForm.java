package com.ongammjs.curso.boot.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ongammjs.curso.boot.model.TipoProjeto;


public class TipoProjetoForm {
	
	@NotNull @NotEmpty
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoProjeto converter() {
		return new TipoProjeto(descricao);
	}
	
	
	
	

}

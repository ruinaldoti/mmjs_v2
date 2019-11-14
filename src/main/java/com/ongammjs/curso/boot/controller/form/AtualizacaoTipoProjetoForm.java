package com.ongammjs.curso.boot.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ongammjs.curso.boot.model.TipoProjeto;
import com.ongammjs.curso.boot.repository.TipoProjetoRepository;

public class AtualizacaoTipoProjetoForm {
	
	@NotNull @NotEmpty
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoProjeto atualizar(Long id, TipoProjetoRepository tipoprojetoRepository) {
		TipoProjeto tipoProjeto = tipoprojetoRepository.getOne(id);
		tipoProjeto.setDescricao(this.descricao);
		return tipoProjeto;
	}
	
	
	

}

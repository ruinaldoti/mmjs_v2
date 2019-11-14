package com.ongammjs.curso.boot.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.ongammjs.curso.boot.model.TipoProjeto;

public class TipoProjetoDto {
	
	private Long id;
	private String descricao;
	
	public TipoProjetoDto(TipoProjeto tipoprojeto) {
		this.id = tipoprojeto.getId();
		this.descricao = tipoprojeto.getDescricao();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static List<TipoProjetoDto> converter(List<TipoProjeto> tipoprojetos) {
		return tipoprojetos.stream().map(TipoProjetoDto::new).collect(Collectors.toList());
	}
	
	
	
	

}

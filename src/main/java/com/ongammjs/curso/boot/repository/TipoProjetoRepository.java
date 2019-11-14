package com.ongammjs.curso.boot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ongammjs.curso.boot.model.TipoProjeto;


public interface TipoProjetoRepository extends JpaRepository<TipoProjeto, Long>{

	TipoProjeto findByDescricao(String descricao);

	
	//Page<TipoProjeto> findBy(String nomeCurso, Pageable paginacao);
	
}


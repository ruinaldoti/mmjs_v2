package com.ongammjs.curso.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ongammjs.curso.boot.model.Projeto;
import com.ongammjs.curso.boot.model.TipoProjeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

	List<Projeto> findByNome(String nome);

	List<Projeto> findByTipoProjetoDescricao(String descricao);
	
	
	

}

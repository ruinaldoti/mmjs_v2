package com.ongammjs.curso.boot.controller;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ongammjs.curso.boot.controller.dto.TipoProjetoDto;
import com.ongammjs.curso.boot.controller.form.AtualizacaoTipoProjetoForm;
import com.ongammjs.curso.boot.controller.form.TipoProjetoForm;
import com.ongammjs.curso.boot.model.TipoProjeto;
import com.ongammjs.curso.boot.repository.TipoProjetoRepository;

@RestController
@RequestMapping("/tipoprojeto")
public class TipoProjetoController {
	
	@Autowired
	private TipoProjetoRepository tipoprojetoRepository;
	
	@GetMapping
	public List<TipoProjetoDto> lista(String descricao){
			System.out.println(descricao);
			List<TipoProjeto> tipoprojetos = tipoprojetoRepository.findAll();	
			return TipoProjetoDto.converter(tipoprojetos);
		
	}
	

	
	@PostMapping
	@Transactional
	public ResponseEntity<TipoProjetoDto> cadastrar(@RequestBody @Valid TipoProjetoForm form, UriComponentsBuilder uriBuilder) {
		TipoProjeto tipoProjeto = form.converter();
		tipoprojetoRepository.save(tipoProjeto);
		
		URI uri = uriBuilder.path("/tipoprojeto/{id}").buildAndExpand(tipoProjeto.getId()).toUri();
		return ResponseEntity.created(uri).body(new TipoProjetoDto(tipoProjeto));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoProjetoDto> detalhar(@PathVariable Long id) {
		
		Optional<TipoProjeto> tipoProjeto = tipoprojetoRepository.findById(id);
		if(tipoProjeto.isPresent()) {
			return ResponseEntity.ok(new TipoProjetoDto(tipoProjeto.get()));
		}
		return ResponseEntity.notFound().build();
		
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TipoProjetoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTipoProjetoForm form ){
		
		Optional<TipoProjeto> optional = tipoprojetoRepository.findById(id);
		if(optional.isPresent()) {
			TipoProjeto tipoProjeto = form.atualizar(id, tipoprojetoRepository);
			return ResponseEntity.ok(new TipoProjetoDto(tipoProjeto));
		}
		return ResponseEntity.notFound().build();
	
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		Optional<TipoProjeto> optional = tipoprojetoRepository.findById(id);
		if(optional.isPresent()) {
			tipoprojetoRepository.deleteById(id);
			return 	ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
		
		
	}
	
	

}

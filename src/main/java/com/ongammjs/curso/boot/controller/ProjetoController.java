package com.ongammjs.curso.boot.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ongammjs.curso.boot.controller.dto.ProjetoDto;
import com.ongammjs.curso.boot.controller.form.ProjetoForm;
import com.ongammjs.curso.boot.model.Projeto;
import com.ongammjs.curso.boot.repository.ProjetoRepository;
import com.ongammjs.curso.boot.repository.TipoProjetoRepository;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
	
	@Autowired
	private  TipoProjetoRepository tipoProjetoRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	
	
	@GetMapping
	public List<ProjetoDto> lista(String nome,String descricao){
		if(nome == null && descricao == null) {
			List<Projeto> projeto = projetoRepository.findAll();	
			return ProjetoDto.converter(projeto);
		}else {
			List<Projeto> projeto = projetoRepository.findByTipoProjetoDescricao(descricao);	
			return ProjetoDto.converter(projeto);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProjetoDto> cadastrar(@RequestBody @Valid ProjetoForm form, UriComponentsBuilder uriBuilder) {
		
		Projeto projeto = form.converter(tipoProjetoRepository);
		projetoRepository.save(projeto);
		
		URI uri = uriBuilder.path("/projeto/{id}").buildAndExpand(projeto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProjetoDto(projeto));
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover (@PathVariable Long id){
		projetoRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	

}

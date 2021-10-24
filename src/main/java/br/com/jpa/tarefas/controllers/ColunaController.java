package br.com.jpa.tarefas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jpa.tarefas.models.Coluna;
import br.com.jpa.tarefas.services.ColunaService;

@RestController
@RequestMapping("colunas")
public class ColunaController {

	@Autowired
	ColunaService colunaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Coluna> findById(@PathVariable(name = "id") Integer id){
		return new ResponseEntity<>(colunaService.findById(id), HttpStatus.OK);
	}
	
	@GetMapping
	public List<Coluna> findAll(){
		return colunaService.findAll();
	}
	
	@GetMapping("find-by-quadro/{id}")
	public List<Coluna> findByQuadro(@PathVariable(name = "id") Integer id){
		return colunaService.findByQuadro(id);
	}
	
	@PostMapping
	public ResponseEntity<Coluna> save(@RequestBody Coluna coluna){
		return new ResponseEntity<>(colunaService.save(coluna), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Coluna> update(@RequestBody Coluna coluna){
		return new ResponseEntity<>(colunaService.update(coluna), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Coluna> remove(@RequestBody Coluna coluna){
		colunaService.remove(coluna);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

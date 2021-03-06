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

import br.com.jpa.tarefas.models.Quadro;
import br.com.jpa.tarefas.services.QuadroService;

@RestController
@RequestMapping("quadros")
public class QuadroController {

	@Autowired
	QuadroService quadroService;
	
	@GetMapping
	public List<Quadro> findAll(){
		return quadroService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quadro> findById(@PathVariable(value="id") Integer quadroId) {
		return new ResponseEntity<>(quadroService.findById(quadroId), HttpStatus.OK);
	}
		
	@PostMapping
	public ResponseEntity<Quadro> save(@RequestBody Quadro quadro) {
		return new ResponseEntity<>(quadroService.save(quadro), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Quadro> update(@RequestBody Quadro quadro) {
		return new ResponseEntity<>(quadroService.update(quadro), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> remove(@RequestBody Quadro quadro){
		quadroService.remove(quadro);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

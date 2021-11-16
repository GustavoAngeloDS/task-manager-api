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

import br.com.jpa.tarefas.models.Tarefa;
import br.com.jpa.tarefas.services.TarefaService;

@RestController
@RequestMapping("tarefas")
public class TarefaController {

	@Autowired
	TarefaService tarefaService;
	
	@GetMapping
	public List<Tarefa> findAll(){
		return tarefaService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable(value="id") Integer tarefaId) {
		return new ResponseEntity<>(tarefaService.findById(tarefaId), HttpStatus.OK);
	}
	
	@GetMapping("find-by-quadro/{id}")
	public List<Tarefa> findByQuadro(@PathVariable(value="id") Integer id){
		return tarefaService.findByQuadro(id);
	}
	
	@GetMapping("find-by-coluna/{id}")
	public List<Tarefa> findByColuna(@PathVariable(value="id") Integer id){
		return tarefaService.findByColuna(id);
	}
	
	@PostMapping
	public ResponseEntity<Tarefa> save(@RequestBody Tarefa tarefa) {
		return new ResponseEntity<>(tarefaService.save(tarefa), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Tarefa> update(@RequestBody Tarefa tarefa) {
		return new ResponseEntity<>(tarefaService.update(tarefa), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<?> remove(@RequestBody Tarefa tarefa){
		tarefaService.remove(tarefa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

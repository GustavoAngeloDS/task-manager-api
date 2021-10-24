package br.com.jpa.tarefas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jpa.tarefas.models.Usuario;
import br.com.jpa.tarefas.services.UsuarioService;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> findAll(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable(name = "id") Integer id){
		return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);		
	}
	
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
		return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.OK); 
	}
	
	@DeleteMapping
	public ResponseEntity<?> remove(@RequestBody Usuario usuario) {
		usuarioService.remove(usuario);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}

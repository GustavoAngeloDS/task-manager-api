package br.com.jpa.tarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpa.tarefas.models.Usuario;
import br.com.jpa.tarefas.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Usuario findById(Integer id) {
		return ((Optional<Usuario>) usuarioRepository.findById(id)).get();
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void remove(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}
}

package br.com.jpa.tarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jpa.tarefas.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}

package br.com.jpa.tarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jpa.tarefas.models.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer>{

	@Query("SELECT t FROM Tarefa t WHERE t.quadro.id = ?1")
	List<Tarefa>findByQuadro(Integer id);
	
	@Query("SELECT t FROM Tarefa t WHERE t.coluna.id = ?1")
	List<Tarefa> findByColuna(Integer id);
}

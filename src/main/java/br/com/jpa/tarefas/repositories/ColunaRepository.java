package br.com.jpa.tarefas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.jpa.tarefas.models.Coluna;

public interface ColunaRepository extends JpaRepository<Coluna, Integer>{

	@Query("SELECT c FROM Coluna c WHERE c.quadro.id = ?1")
	List<Coluna> findByQuadro(Integer id);
}

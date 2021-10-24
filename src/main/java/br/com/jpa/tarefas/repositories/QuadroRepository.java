package br.com.jpa.tarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jpa.tarefas.models.Quadro;

public interface QuadroRepository extends JpaRepository<Quadro, Integer>{

}

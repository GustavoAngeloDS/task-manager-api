package br.com.jpa.tarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpa.tarefas.models.Tarefa;
import br.com.jpa.tarefas.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	TarefaRepository tarefaRepository;
	
	public List<Tarefa> findAll(){
		return tarefaRepository.findAll();
	}
	
	public Tarefa findById(Integer id) {
		return ((Optional<Tarefa>)tarefaRepository.findById(id)).get();
	}
	
	public List<Tarefa> findByQuadro(Integer id){
		return tarefaRepository.findByQuadro(id);
	}
	
	public List<Tarefa> findByColuna(Integer id){
		return tarefaRepository.findByColuna(id);
	}
	
	public Tarefa save(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
	public void remove(Tarefa tarefa) {
		tarefaRepository.delete(tarefa);
	}
	
	public Tarefa update(Tarefa tarefa) {
		Optional<Tarefa> tarefaOpt = tarefaRepository.findById(tarefa.getId());
		Tarefa tarefaFinal = new Tarefa();
		
		if(tarefaOpt.isPresent())
			tarefaFinal = tarefaRepository.save(tarefa);
		
		return tarefaFinal;		
	}
}

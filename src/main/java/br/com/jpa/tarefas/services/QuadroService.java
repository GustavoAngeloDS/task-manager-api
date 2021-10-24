package br.com.jpa.tarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpa.tarefas.models.Quadro;
import br.com.jpa.tarefas.repositories.QuadroRepository;

@Service
public class QuadroService {
	
	@Autowired
	QuadroRepository quadroRepository;
	
	public List<Quadro> findAll(){
		return quadroRepository.findAll();
	}
	
	public Quadro findById(Integer id) {
		return ((Optional<Quadro>) quadroRepository.findById(id)).get();
	}
	
	public Quadro save(Quadro quadro) {
		return quadroRepository.save(quadro);
	}
	
	public void remove(Quadro quadro) {
		quadroRepository.delete(quadro);
	}
	
	public Quadro update(Quadro quadro) {
		Optional<Quadro> quadroOpt = quadroRepository.findById(quadro.getId());
		Quadro quadroFinal = new Quadro();
		
		if(quadroOpt.isPresent())
			quadroFinal = quadroRepository.save(quadro);
		
		return quadroFinal;
	}

}

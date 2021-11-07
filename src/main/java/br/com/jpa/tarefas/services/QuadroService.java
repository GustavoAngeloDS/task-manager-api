package br.com.jpa.tarefas.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpa.tarefas.models.Quadro;
import br.com.jpa.tarefas.repositories.QuadroRepository;

@Service
public class QuadroService {
	
	Logger logger = LoggerFactory.getLogger(QuadroService.class);
	
	@Autowired
	QuadroRepository quadroRepository;
	
	public List<Quadro> findAll(){
		logger.info("Retornando informações de todos os quadros");
		return quadroRepository.findAll();
	}
	
	public Quadro findById(Integer id) {
		logger.info("Retornando informações de quadro por ID");
		return ((Optional<Quadro>) quadroRepository.findById(id)).get();
	}
	
	public Quadro save(Quadro quadro) {
		logger.info("Salvando novo quadro");
		return quadroRepository.save(quadro);
	}
	
	public void remove(Quadro quadro) {
		logger.info("Removendo quadro");
		quadroRepository.delete(quadro);
	}
	
	public Quadro update(Quadro quadro) {
		logger.info("Atualizando quadro");
		Optional<Quadro> quadroOpt = quadroRepository.findById(quadro.getId());
		Quadro quadroFinal = new Quadro();
		
		if(quadroOpt.isPresent())
			quadroFinal = quadroRepository.save(quadro);
		
		return quadroFinal;
	}

}

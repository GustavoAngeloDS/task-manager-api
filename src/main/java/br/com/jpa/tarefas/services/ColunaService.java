package br.com.jpa.tarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jpa.tarefas.models.Coluna;
import br.com.jpa.tarefas.repositories.ColunaRepository;

@Service
public class ColunaService {

	@Autowired
	ColunaRepository colunaRepository;
	
	public List<Coluna> findAll(){
		return colunaRepository.findAll();
	}
	
	public Coluna findById(Integer id) {
		return ((Optional<Coluna>) colunaRepository.findById(id)).get();
	}
	
	public Coluna save(Coluna coluna) {
		return colunaRepository.save(coluna);
	}
	
	public void remove(Coluna coluna) {
		colunaRepository.delete(coluna);
	}
	
	public Coluna update(Coluna coluna) {
		Optional<Coluna> colunaOpt = colunaRepository.findById(coluna.getId());
		Coluna colunaFinal = new Coluna();
		
		if(colunaOpt.isPresent())
			colunaFinal = colunaRepository.save(coluna);
		
		return colunaFinal;
	}
	
	public List<Coluna> findByQuadro(Integer id){
		return colunaRepository.findByQuadro(id);
	}
}

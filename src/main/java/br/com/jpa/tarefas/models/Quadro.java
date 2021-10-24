package br.com.jpa.tarefas.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "quadros")
public class Quadro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	Integer id;
	String nome;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	Usuario usuario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "quadro")
	List<Coluna> colunas = new ArrayList<Coluna>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "quadro")
	List<Tarefa> tarefas = new ArrayList<Tarefa>();
	
}

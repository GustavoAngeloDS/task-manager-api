package br.com.jpa.tarefas.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String nome;
	String email;
	
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	List<Quadro> quadros = new ArrayList<Quadro>();
}

package br.com.jpa.tarefas.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="Tarefas")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String descricao;
	Boolean finalizado;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	Calendar dataFinalizacao;

	@ManyToOne
	@JoinColumn(name="id_coluna")
	Coluna coluna;
	
	@ManyToOne
	@JoinColumn(name="id_quadro")
	Quadro quadro;
}

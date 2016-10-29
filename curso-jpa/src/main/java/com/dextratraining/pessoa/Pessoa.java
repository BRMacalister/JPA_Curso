package com.dextratraining.pessoa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pessoa {
	
	
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(name = "Data_de_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int id;
	
	
	public String getNome() {
		return nome;
	}
	
	public int getId() {
		return id;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}

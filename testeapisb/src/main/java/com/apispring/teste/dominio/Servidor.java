package com.apispring.teste.dominio;


import java.time.LocalDate;
import java.util.Objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Servidor {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nome;
	private String matricula;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate datacad;	
	//private Lotacao lotac;
	
	@Deprecated
	protected Servidor() {}
	
	public Servidor (String nome) {
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public LocalDate getDatacad() {
		return datacad;
	}
	public void setDatacad(LocalDate datacad) {
		this.datacad = datacad;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servidor other = (Servidor) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Servidor [nome=" + nome + "]";
	}
	
	
	
	
}


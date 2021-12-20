package com.apispring.teste;

import org.springframework.stereotype.Component;

import com.apispring.teste.dominio.Servidor;
import com.apispring.teste.dominio.ServidorRepositorio;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
@Component
public class GrupoIncBanco implements CommandLineRunner {
	
	@Autowired
	private ServidorRepositorio servidorRepo;
	
	@Override
	public void run(String... args) throws Exception{
	
		Servidor s1 = new Servidor("joao");
		s1.setMatricula("98bv45r");
		s1.setDatacad(LocalDate.of(2021, 4, 1));
		
		
		Servidor s2 = new Servidor("jose");
		s2.setMatricula("9ou678iu9");
		s2.setDatacad(LocalDate.of(2021, 5, 6));
		
		servidorRepo.save(s1);
		servidorRepo.save(s2);
		
	}
	
	
}

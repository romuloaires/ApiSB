package com.apispring.teste.controller;


import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apispring.teste.dominio.Servidor;
import com.apispring.teste.dominio.ServidorRepositorio;



@Controller
public class ServidorControle {

	private ServidorRepositorio servidorRepo;
	
	public ServidorControle(ServidorRepositorio servidorRepo) {
		this.servidorRepo  = servidorRepo;
	}
	
	
	@GetMapping("/rh/servidores")
	public String servidores(Model model) {
		model.addAttribute("listaServidores", servidorRepo.findAll());
		return "rh/servidores/index.html";
	}
	
	@GetMapping("/rh/servidores/nova")
	public String novoServidor(@ModelAttribute("servidor") Servidor servidor) {
		
		return "rh/servidores/form.html";
	}
	
	@Transactional
	@PostMapping("/rh/servidores/salvar")
	public String salvarServidor(@ModelAttribute("servidor") Servidor servidor) {
		servidorRepo.save(servidor);
		return "redirect:/rh/servidores/";
	}
	
	@GetMapping("/rh/servidores/{id}")
	public String alterarServidor(@PathVariable("id") long id, Model model) {		
		Optional<Servidor> servidorOpt= servidorRepo.findById(id);
		if(servidorOpt.isEmpty()) {
			throw new IllegalArgumentException("Servidor Invalido");
		}
		
		model.addAttribute("servidor", servidorOpt.get());
		return "rh/servidores/form";
		
	}
	
	@GetMapping("/rh/servidores/excluir/{id}")
	public String excluirServidor(@PathVariable("id") long id, Model model) {
		
		Optional<Servidor> servidorOpt= servidorRepo.findById(id);
		if(servidorOpt.isEmpty()) {
			throw new IllegalArgumentException("Servidor Invalido");
		}
		
		servidorRepo.delete(servidorOpt.get());
		return "redirect:/rh/servidores";
		
	}
	
	
	
}

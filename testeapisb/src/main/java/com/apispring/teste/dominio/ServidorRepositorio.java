package com.apispring.teste.dominio;

import  org.springframework.data.jpa.repository.JpaRepository;
import  org.springframework.stereotype.Repository;

@Repository
public interface ServidorRepositorio extends JpaRepository<Servidor, Long> {

}

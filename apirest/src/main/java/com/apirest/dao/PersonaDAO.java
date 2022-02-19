package com.apirest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.model.Persona;

public interface PersonaDAO extends JpaRepository<Persona, Integer>{
	
	
}

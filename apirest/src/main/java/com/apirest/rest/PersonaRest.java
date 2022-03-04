package com.apirest.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.dao.PersonaDAO;
import com.apirest.model.Persona;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("personas")
public class PersonaRest {
	
	@Autowired
	private PersonaDAO personaDAO;
	
	@ApiOperation("Guardar usuario de un json")
	@PostMapping("/guardar")
	public void guardar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
	
	@ApiOperation("Listar Usuario dado un ID")
	@GetMapping("/listarId/{id}")
	public Persona listarId(@PathVariable("id") Integer id){
		return personaDAO.findById(id).orElse(null);
	}
	
	@ApiOperation("Visualizar listado de usuarios")
	@GetMapping("/listar")
	public List<Persona> listar(){
		return personaDAO.findAll();
	}

	@ApiOperation("Eliminar usuario dado un ID")
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}
	
	@ApiOperation("Actualizar usuario mediante un json")
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
}

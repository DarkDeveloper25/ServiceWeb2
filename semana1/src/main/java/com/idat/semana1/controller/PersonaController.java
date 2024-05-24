package com.idat.semana1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.semana1.model.Persona;


@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@GetMapping
	public String saludo() {
		return "Bienvenido Spring Rest Service";
	}

	@GetMapping(value = "/listar")
	public List<Persona> listar(){
		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona(1, "Juan", "Perez"));
		lista.add(new Persona(2, "Maria", "Gomez"));
		lista.add(new Persona(3, "Pedro", "Lopez"));
		lista.add(new Persona(4, "Kenshin", "Himura"));
		return lista;
	}
	@GetMapping (value = "/buscarPathVariable/{id}")
	public Persona buscarl (@PathVariable("id") int id){
		List<Persona> lista=listar();
		Persona pEncontrada = new Persona();
		for (Persona p: lista) {
			if (p.getIdpersona()==id) {
				pEncontrada=p;
				break;
			}	
		}
		return pEncontrada;
	}

	@PostMapping // 
	public Persona registrar(@RequestBody Persona pNueva){
		pNueva.setIdpersona(4);
		pNueva.setNombre(pNueva.getNombre() + " - creado");
		pNueva.setApellido(pNueva.getApellido() + " - creado");
		return pNueva;

	}
	
}

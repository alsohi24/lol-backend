package com.cibertec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.CiudadPrincipal;
import com.cibertec.service.ICiudadService;

@RestController
@RequestMapping("/ciudades")
public class RestCiudadController {

	@Autowired
	private ICiudadService ciuService;
	
	@GetMapping
	public List<CiudadPrincipal> listar(){
		return ciuService.getAll();
	}
	
	@PostMapping
	public void insertar(@RequestBody CiudadPrincipal ciu){
		ciuService.save(ciu);
	}
	
	@PutMapping
	public void modificar(@RequestBody CiudadPrincipal ciu){
		ciuService.save(ciu);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		ciuService.delete(id);
	}
}

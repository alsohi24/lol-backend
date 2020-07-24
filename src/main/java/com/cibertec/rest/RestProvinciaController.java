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

import com.cibertec.model.Provincia;
import com.cibertec.service.IProvinciaService;

@RestController
@RequestMapping("/provincias")
public class RestProvinciaController {
	
	//instanciamos el service
	@Autowired
	private IProvinciaService provinciaService;
	
	@GetMapping
	public List<Provincia> listar(){
		return provinciaService.getAll(); 
	}
	
	@PostMapping
	public void insertar(@RequestBody Provincia dis) {
		provinciaService.save(dis);
	}
	
	@PutMapping
	public void modificar (@RequestBody Provincia dis) {
		provinciaService.save(dis);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id")  Integer id) {
		provinciaService.delete(id);
	}

}

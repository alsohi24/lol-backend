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

import com.cibertec.model.Pais;
import com.cibertec.service.IPaisService;

@RestController
@RequestMapping("/paises")
public class RestPaisController {

	@Autowired
	private IPaisService paisService;
	
	@GetMapping
	public List<Pais> listar(){
		return paisService.getAll();
	}
	
	@PostMapping
	public void insertar(@RequestBody Pais per){
		paisService.save(per);
	}
	
	@PutMapping
	public void modificar(@RequestBody Pais per){
		paisService.save(per);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		paisService.delete(id);
	}
}

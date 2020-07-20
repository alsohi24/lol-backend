package com.cibertec.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cibertec.model.Persona;
import com.cibertec.model.CiudadPrincipal;

import com.cibertec.service.ICiudadService;
import com.cibertec.service.IPaisService;
import com.cibertec.service.IPersonaService;

@Controller
public class PersonaController {

	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private ICiudadService ciuService;
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@RequestMapping("/inicio")
	public String index(Model model) {
		model.addAttribute("list",personaService.getAll());
		return "inicio";
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("listPaises",paisService.getAll());
		model.addAttribute("listCius",ciuService.getAll());

		if(id != null && id != 0) {
			model.addAttribute("persona", personaService.get(id));
		} else {
			model.addAttribute("persona", new Persona());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute Persona persona, BindingResult result, Model model, RedirectAttributes attribute) {
		if (result.hasErrors()) {
			model.addAttribute("listPaises",paisService.getAll());
			System.out.println("Existieron errores en el formulario");			
			return "save";
		}
		
		personaService.save(persona);
		System.out.println("Cliente guardado con exito!");
		attribute.addFlashAttribute("success", "Cliente guardado con éxito!");
		return "redirect:/inicio";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model, RedirectAttributes attribute) {
		personaService.delete(id);
		System.out.println("Registro Eliminado con Exito!");
		attribute.addFlashAttribute("warning", "Registro Eliminado con Éxito!");
		return "redirect:/inicio";
	}
}

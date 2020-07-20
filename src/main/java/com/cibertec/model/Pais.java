package com.cibertec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Pais implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "pais_id")
	private int id;

	@Column(name = "pais_nombre")
	//@NotEmpty
	private String nombre;
	
	
//	@OneToMany
//	@JoinColumn(name="ciudad_id", nullable = false)
//	private CiudadPrincipal ciu;
//
//	public CiudadPrincipal getCiu() {
//		return ciu;
//	}
//
//	public void setCiu(CiudadPrincipal ciu) {
//		this.ciu = ciu;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
}

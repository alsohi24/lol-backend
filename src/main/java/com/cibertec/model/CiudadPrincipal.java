package com.cibertec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class CiudadPrincipal {

	@Id
	@GeneratedValue
	@Column(name = "ciudad_id")
	private int id;

	@Column(name = "ciudad_nombre")
	//@NotEmpty
	private String nombre;

	@ManyToOne
	@JoinColumn(name="pais_id", nullable = false)
	private Pais pais;
	

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
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

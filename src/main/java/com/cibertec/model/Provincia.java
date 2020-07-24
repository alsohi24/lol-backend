package com.cibertec.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Provincia {
	
	@Id
	@GeneratedValue
	@Column(name = "provincia_id")
	public int id;
	
	@Column(name = "provincia_nombre")
	public String nombre;
	
	//Instancia de ciudad
	@ManyToOne
	@JoinColumn(name = "ciudad_id", nullable = false)
	private CiudadPrincipal ciudad;
	

	//Getter / Setter
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

	public CiudadPrincipal getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadPrincipal ciudad) {
		this.ciudad = ciudad;
	}	

}

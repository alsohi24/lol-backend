package com.cibertec.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Persona implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "persona_id")
	private int id;
	
	@Column(name = "persona_nombre")
	@NotEmpty
	private String nombre;
	
	@Column(name = "persona_apellido")
	@NotEmpty
	private String apellido;
	
	@Column(name = "persona_direccion")
	@NotEmpty
	private String direccion;
	
	@Column(name = "persona_telefono")
	@NotEmpty
	@Pattern(regexp="[0-9]{9}")
	private String telefono;
	
	@Column(name = "persona_email")
	@NotEmpty
	@Email
	private String email;
	
	@ManyToOne
	@JoinColumn(name="pais_id", nullable = false)
	@NotNull
    @Valid
	private Pais pais;
	
	@ManyToOne
	@JoinColumn(name="ciudad_id", nullable = false)
	@NotNull
    @Valid
	private CiudadPrincipal ciu;
	
	@ManyToOne
	@JoinColumn(name = "provincia_id", nullable = false)
	@NotNull
    @Valid
	private Provincia prov;

	public Provincia getProv() {
		return prov;
	}

	public void setProv(Provincia prov) {
		this.prov = prov;
	}

	public int getId() {
		return id;
	}

	public CiudadPrincipal getCiu() {
		return ciu;
	}

	public void setCiu(CiudadPrincipal ciu) {
		this.ciu = ciu;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

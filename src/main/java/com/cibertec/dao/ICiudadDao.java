package com.cibertec.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.model.CiudadPrincipal;

public interface ICiudadDao extends JpaRepository<CiudadPrincipal, Integer> {

}


package com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.commons.GenericServiceImpl;
import com.cibertec.dao.ICiudadDao;
import com.cibertec.model.CiudadPrincipal;
import com.cibertec.service.ICiudadService;

@Service
public class CiudadServiceImpl extends GenericServiceImpl<CiudadPrincipal, Integer> implements ICiudadService{

	@Autowired
	private ICiudadDao ciuDao;
	
	@Override
	public JpaRepository<CiudadPrincipal, Integer> getDao() {
		// TODO Auto-generated method stub
		return ciuDao;
	}

}

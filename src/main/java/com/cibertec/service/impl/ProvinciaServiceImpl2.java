package com.cibertec.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.commons.GenericServiceImpl;
import com.cibertec.dao.IProvinciaDao;
import com.cibertec.model.Provincia;
import com.cibertec.service.IProvinciaService;

@Service
public class ProvinciaServiceImpl2 extends GenericServiceImpl<Provincia, Integer> implements IProvinciaService {
	
	@Autowired
	private IProvinciaDao provinciaDAO;

	@Override
	public JpaRepository<Provincia, Integer> getDao() {
		// TODO Auto-generated method stub
		return provinciaDAO;
	}

}

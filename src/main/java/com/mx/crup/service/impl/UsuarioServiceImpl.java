package com.mx.crup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.mx.crup.commons.GenericServiceImp;
import com.mx.crup.dao.api.UsuarioDaoAPI;
import com.mx.crup.model.Usuario;
import com.mx.crup.service.UsuarioServiceAPI;

@Service
public class UsuarioServiceImpl extends GenericServiceImp<Usuario, Long> implements UsuarioServiceAPI{

	@Autowired
	private UsuarioDaoAPI usuarioDaoAPI;
	
	@Override
	public CrudRepository<Usuario, Long> getDao() {
		return usuarioDaoAPI;
	}

	

}

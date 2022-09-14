package com.mx.crup.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.mx.crup.model.Usuario;

public interface UsuarioDaoAPI extends CrudRepository<Usuario, Long> {

}

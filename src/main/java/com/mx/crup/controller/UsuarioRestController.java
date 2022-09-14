package com.mx.crup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mx.crup.model.Usuario;
import com.mx.crup.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping(value = "/controller/usuario/v1/")
@CrossOrigin("*")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceAPI;
	
	@GetMapping(value = "/all")
	public List<Usuario> getAll(){
		return usuarioServiceAPI.getAll();
		
	}
	
	@PostMapping(value = "/guardarActualizar")
	public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario){
	Usuario usu =  usuarioServiceAPI.guardar(usuario);
	return new ResponseEntity<Usuario>(usu, HttpStatus.OK);
	}
	
	@GetMapping(value =  "/borrar/{idUsuario}")
	public ResponseEntity<Usuario> borrar(@PathVariable Long idUsuario){
		Usuario usu = usuarioServiceAPI.obtener(idUsuario);
		//valida si existe y borra
		if(usu!=null) {
			usuarioServiceAPI.borrar(idUsuario);
		}else {
			return new ResponseEntity<Usuario>(usu, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Usuario>(usu, HttpStatus.OK);
	}
	
	@GetMapping(value =  "/buscar/{idUsuario}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long idUsuario){
		Usuario usu = usuarioServiceAPI.obtener(idUsuario);
		return new ResponseEntity<Usuario>(usu, HttpStatus.OK);
	}

}

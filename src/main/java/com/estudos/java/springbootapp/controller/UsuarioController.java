package com.estudos.java.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.java.springbootapp.model.Usuario;
import com.estudos.java.springbootapp.service.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method=RequestMethod.GET, value="/get/{id}")
	public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<Usuario>(usuarioService.obterPorId(id), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET, value="/getAll")
	public ResponseEntity<Iterable<Usuario>> getAll() {
		return new ResponseEntity<Iterable<Usuario>>(usuarioService.getAll(), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET, value="/remove/{id}")
	public ResponseEntity<Long> removerPorId(@PathVariable Long id) {
		return new ResponseEntity<Long>(usuarioService.remover(id), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/alterar")
	public ResponseEntity<Usuario> alterar(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(usuarioService.alterar(usuario), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/criar")
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario) {
		return new ResponseEntity<Usuario>(usuarioService.criar(usuario), HttpStatus.OK);
	}
}

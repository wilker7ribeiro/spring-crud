package com.estudos.java.springbootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.java.springbootapp.model.Perfil;
import com.estudos.java.springbootapp.service.PerfilService;

@RestController
@RequestMapping(value="/perfis")
public class PerfilController {
	@Autowired
	private PerfilService perfilService;

	@RequestMapping(method=RequestMethod.GET, value="/get/{id}")
	public ResponseEntity<Perfil> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<Perfil>(perfilService.obterPorId(id), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getByUsuario/{id}")
	public ResponseEntity<Iterable<Perfil>> buscarPorIdUsuario(@PathVariable Long id) {
		return new ResponseEntity<Iterable<Perfil>>(perfilService.obterPorIdUsuario(id), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAll")
	public ResponseEntity<Iterable<Perfil>> getAll() {
		return new ResponseEntity<Iterable<Perfil>>(perfilService.getAll(), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET, value="/remove/{id}")
	public ResponseEntity<Long> removerPorId(@PathVariable Long id) {
		return new ResponseEntity<Long>(perfilService.remover(id), HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/alterar")
	public ResponseEntity<Perfil> alterar(@RequestBody Perfil usuario) {
		return new ResponseEntity<Perfil>(perfilService.alterar(usuario), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/criar")
	public ResponseEntity<Perfil> criar( @RequestBody Perfil usuario) {
		return new ResponseEntity<Perfil>(perfilService.criar(usuario), HttpStatus.OK);
	}
}

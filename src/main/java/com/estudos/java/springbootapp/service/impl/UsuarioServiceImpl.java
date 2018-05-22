package com.estudos.java.springbootapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.java.springbootapp.error.ResourceNotFoundException;
import com.estudos.java.springbootapp.model.Usuario;
import com.estudos.java.springbootapp.repository.PerfilRepository;
import com.estudos.java.springbootapp.repository.UsuarioRepository;
import com.estudos.java.springbootapp.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@Autowired
	public PerfilRepository perfilRepository;
	
	
	public Usuario obterPorId(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
		return usuario;
	}
	
	public Usuario criar(Usuario usuario) {
		perfilRepository.saveAll(usuario.getPerfis());
		return usuarioRepository.save(usuario);
	}
	
	public Usuario alterar(Usuario usuario){
//		Usuario naBase = obterPorId(usuario.getId());
		perfilRepository.saveAll(usuario.getPerfis());
		return usuarioRepository.save(usuario); 
	}
	public Iterable<Usuario> getAll() {
		return usuarioRepository.findAll();
	}
	public Long remover(Long id) {
		usuarioRepository.deleteById(id);
		return id;
	}
}

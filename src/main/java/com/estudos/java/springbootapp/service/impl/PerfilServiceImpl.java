package com.estudos.java.springbootapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.java.springbootapp.error.ResourceNotFoundException;
import com.estudos.java.springbootapp.model.Perfil;
import com.estudos.java.springbootapp.repository.PerfilRepository;
import com.estudos.java.springbootapp.repository.UsuarioRepository;
import com.estudos.java.springbootapp.service.PerfilService;

@Service
public class PerfilServiceImpl implements PerfilService{

	@Autowired
	public PerfilRepository perfilRepository;
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	public Perfil obterPorId(Long id) {
		Perfil perfil = perfilRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));
		return perfil;
	}
	
	public Iterable<Perfil> obterPorIdUsuario(Long id) {
		return usuarioRepository.findPerfisById(id);
	}
	
	public Perfil criar(Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	
	public Perfil alterar(Perfil perfil){
		Perfil naBase = obterPorId(perfil.getId());
		return perfilRepository.save(perfil); 
	}
	public Iterable<Perfil> getAll() {
		return perfilRepository.findAll();
	}
	public Long remover(Long id) {
		perfilRepository.deleteById(id);
		return id;
	}
}

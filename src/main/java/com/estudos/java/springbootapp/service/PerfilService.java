package com.estudos.java.springbootapp.service;

import com.estudos.java.springbootapp.model.Perfil;

public interface PerfilService {
	Perfil obterPorId(Long id);
	
	Iterable<Perfil> obterPorIdUsuario(Long id);

	Perfil criar(Perfil perfil);

	Perfil alterar(Perfil perfil);

	Iterable<Perfil> getAll();

	Long remover(Long id);
}

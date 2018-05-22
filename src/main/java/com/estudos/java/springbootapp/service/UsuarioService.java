package com.estudos.java.springbootapp.service;

import com.estudos.java.springbootapp.model.Usuario;

public interface UsuarioService {
	Usuario obterPorId(Long id);

	Usuario criar(Usuario usuario);

	Usuario alterar(Usuario usuario);

	Iterable<Usuario> getAll();

	Long remover(Long id);
}

package com.estudos.java.springbootapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estudos.java.springbootapp.model.Perfil;
import com.estudos.java.springbootapp.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	Iterable<Perfil> findPerfisById(Long id);
}

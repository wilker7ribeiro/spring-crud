package com.estudos.java.springbootapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estudos.java.springbootapp.model.Perfil;
import com.estudos.java.springbootapp.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query("SELECT user.perfis from Usuario as user where user.id = :id")
	Iterable<Perfil> findPerfisById(@Param("id") Long id);
}

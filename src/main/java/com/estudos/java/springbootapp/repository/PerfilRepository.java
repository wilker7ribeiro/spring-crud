package com.estudos.java.springbootapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estudos.java.springbootapp.model.Perfil;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Long> {

}

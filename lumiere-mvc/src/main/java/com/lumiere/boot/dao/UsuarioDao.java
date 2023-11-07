package com.lumiere.boot.dao;

import java.util.List;

import com.lumiere.boot.domain.Usuario;


public interface UsuarioDao {

	void save(Usuario usuario);
	
	void update(Usuario usuario);
	
	void delete(Integer id);
		
	Usuario findById(Integer id);
	
	Usuario buscarUsuarioPorEmail(String email);
	
	List<Usuario> findAll();
}

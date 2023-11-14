package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario, Integer> implements UsuarioDao {	
	@PersistenceContext
	private EntityManager entityManager;
	
    public Usuario buscarUsuarioPorEmail(String email) {
    	String query = "SELECT u "
        		+ "FROM Usuario u "
        		+ String.format("WHERE u.emailUsuario = '%s'", email);
	   TypedQuery<Usuario> typedQuery = entityManager.createQuery(query, Usuario.class);
	   List<Usuario> resultList = typedQuery.getResultList();
	   
	   if (resultList.isEmpty()) {
           return null;
       }
	   
       return resultList.get(0);
    }
}

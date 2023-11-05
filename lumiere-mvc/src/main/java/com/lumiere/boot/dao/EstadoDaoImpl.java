package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.Estado;
import com.lumiere.boot.domain.IconeResidencia;
import com.lumiere.boot.domain.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class EstadoDaoImpl extends AbstractDao<Estado, Integer> implements EstadoDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Estado> buscarUFeIdEstado() {
		String query = "SELECT new Estado(e.cdEstado, e.UFEstado) "
        		+ "FROM Estado e";
		return createQuery(query);
	}

	@Override
	public Estado buscarEstadoPorUF(String UFEstado) {
		String query = "SELECT new Estado(e.cdEstado, e.UFEstado) "
        		+ "FROM Estado e "
        		+ String.format("WHERE e.UFEstado = '%s'", UFEstado);

		TypedQuery<Estado> typedQuery = entityManager.createQuery(query, Estado.class);
		List<Estado> resultList = typedQuery.getResultList();
			   
		if (resultList.isEmpty()) {
			return null;
		}
			   
		return resultList.get(0);
	}
}

package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.lumiere.boot.domain.Residencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class ResidenciaDaoImpl extends AbstractDao<Residencia, Integer> implements ResidenciaDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Residencia> buscarResidenciasPorUsuario(int cdUsuario) {
		String sql = String.format("SELECT r FROM Residencia r WHERE r.usuario.cdUsuario = %d", cdUsuario);
		Query query = entityManager.createQuery(sql);
		return query.setMaxResults(4).getResultList();
	}

	public List<Residencia> buscarTodasResidenciasPorUsuario(int cdUsuario) {
		return createQuery("SELECT r FROM Residencia r WHERE r.usuario.cdUsuario = ?1", cdUsuario);
	}
}

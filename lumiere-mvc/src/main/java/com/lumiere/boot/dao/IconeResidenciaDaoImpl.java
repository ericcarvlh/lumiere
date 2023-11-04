package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.IconeResidencia;
import com.lumiere.boot.domain.Residencia;
import com.lumiere.boot.domain.Usuario;

import jakarta.persistence.TypedQuery;

@Repository
public class IconeResidenciaDaoImpl extends AbstractDao<IconeResidencia, Integer> implements IconeResidenciaDao {
	@Override
	public List<IconeResidencia> findAll() {
		String query = "SELECT new IconeResidencia(i.cdIcone, i.urlIcone) "
        		+ "FROM IconeResidencia i";
		return createQuery(query);
	}
}

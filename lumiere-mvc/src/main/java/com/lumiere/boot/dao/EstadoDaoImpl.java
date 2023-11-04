package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.Estado;
import com.lumiere.boot.domain.IconeResidencia;

@Repository
public class EstadoDaoImpl extends AbstractDao<Estado, Long> implements EstadoDao {
	@Override
	public List<Estado> buscarUFeIdEstado() {
		String query = "SELECT new Estado(e.cdEstado, e.UFEstado) "
        		+ "FROM Estado e";
		return createQuery(query);
	}
}

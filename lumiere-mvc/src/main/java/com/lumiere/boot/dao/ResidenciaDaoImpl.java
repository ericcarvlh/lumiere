package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.Residencia;

@Repository
public class ResidenciaDaoImpl extends AbstractDao<Residencia, Integer> implements ResidenciaDao {
	/*@Override
	public List<Residencia> buscarResidenciaPorUsuario(int cdUsuario) {
		String query = "SELECT r "
				+ "FROM Residencia r ";
		return createQuery(query);
	}*/

}

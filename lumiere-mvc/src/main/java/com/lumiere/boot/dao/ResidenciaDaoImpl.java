package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.lumiere.boot.domain.Residencia;

@Repository
public class ResidenciaDaoImpl extends AbstractDao<Residencia, Integer> implements ResidenciaDao {
	
	public List<Residencia> buscarResidenciasPorUsuario(int cdUsuario) {
		System.out.println(cdUsuario);
		return createQuery("SELECT r FROM Residencia r WHERE r.usuario.cdUsuario = ?1", cdUsuario);
	}

}

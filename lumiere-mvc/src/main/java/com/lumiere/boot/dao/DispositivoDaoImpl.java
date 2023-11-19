package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.Dispositivo;

@Repository
public class DispositivoDaoImpl extends AbstractDao<Dispositivo, Integer> implements DispositivoDao {

	public List<Dispositivo> consultarDispositivosPorCdResidencia(int cdResidencia) {
		return createQuery("SELECT d FROM Dispositivo d WHERE d.residencia.cdResidencia = ?1", cdResidencia);
	}
	
}

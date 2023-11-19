package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.Consumo;

@Repository
public class ConsumoDaoImpl extends AbstractDao<Consumo, Integer> implements ConsumoDao {
	@Override
	public List<Consumo> buscarConsumosPorCdResidencia(int cdResidencia) {
		return createQuery("SELECT c FROM Consumo c WHERE c.dispositivo.residencia.cdResidencia = ?1", cdResidencia);
	}
	
	public List<Consumo>  buscarConsumosPorCdDispositivo(int cdDispositivo) {
		return createQuery("SELECT c FROM Consumo c WHERE c.dispositivo.cdDispositivo = ?1", cdDispositivo);
	}
	
}

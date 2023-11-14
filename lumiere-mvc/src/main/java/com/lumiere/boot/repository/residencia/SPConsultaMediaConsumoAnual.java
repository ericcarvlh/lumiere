package com.lumiere.boot.repository.residencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Repository
@Transactional
@SqlResultSetMapping(name = "MediaConsumoAnual", 
classes = @ConstructorResult(targetClass = ConsultaMediaConsumoAnual.class, 
columns = { 
	@ColumnResult(name = "ano", type = Integer.class),
	@ColumnResult(name = "consumoTotal", type = Double.class) 
}))
public class SPConsultaMediaConsumoAnual {
	@PersistenceContext
    private EntityManager entityManager;
	
	/*public void callConsultaMediaConsumoAnual(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaMediaConsumoAnual");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<ConsultaMediaConsumoAnual> lista = storedProcedure.getResultList();

        lista.forEach(p -> System.out.println("Consumo => Ano: " + p.getAno() + ", Preço: " + p.getConsumoTotal()));

    }*/
 
    @SuppressWarnings("unchecked")
    public List<Object[]> getUerInfo(int cdResidencia) {
        List<Object[]> list = new ArrayList<>();
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_consultaMediaConsumoAnual", "MediaConsumoAnual");
        
        query.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        query.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        try {
            // Execute query
            query.execute();
            list = query.getResultList();
        } finally {
            try {
                query.unwrap(ProcedureOutputs.class).release();
            } catch (Exception e) {
            	e.printStackTrace();
            }
        }
        return list;
    }
}
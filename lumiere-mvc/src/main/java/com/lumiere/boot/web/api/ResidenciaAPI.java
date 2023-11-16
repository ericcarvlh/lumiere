package com.lumiere.boot.web.api;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lumiere.boot.dao.RelatorioConsumoDao;
import com.lumiere.boot.domain.RelatorioConsumo;
import com.lumiere.boot.service.ConsumoService;

@Controller
@RequestMapping("/API")
public class ResidenciaAPI {
	@Autowired
	RelatorioConsumoDao relatorioConsumoDao;
	
	@PostMapping("/obterConsumoMedioAnual/{cdResidencia}")
    @ResponseBody
	public String obterConsumoMedioAnual(@PathVariable("cdResidencia") int cdResidencia) {				                				
		List<RelatorioConsumo> listMediaConsumo = relatorioConsumoDao.callConsultaMediaConsumoAnual(cdResidencia);
				
		JSONArray jsonArray = new JSONArray();
		for (RelatorioConsumo c : listMediaConsumo) {
		    int ano = c.getAno();
		    double consumoTotal = c.getConsumoTotal();

		    JSONObject jsonObjTest = new JSONObject(); // Crie um novo objeto em cada iteração

		    jsonObjTest.put("ano", ano);
		    jsonObjTest.put("consumoTotal", consumoTotal);

		    jsonArray.put(jsonObjTest);
		}
		
        return jsonArray.toString();
    }
	
	@PostMapping("/obterConsumoTotalPorDispositivos/{cdResidencia}")
    @ResponseBody
	public String obterConsumoTotalPorDispositivos(@PathVariable("cdResidencia") int cdResidencia) {				                				
		List<RelatorioConsumo> listMediaConsumo = relatorioConsumoDao.callConsultaConsumoTotalPorDispositivo(cdResidencia);
				
		JSONArray jsonArray = new JSONArray();
		for (RelatorioConsumo c : listMediaConsumo) {
		    String nomeDispositivo = c.getNomeDispositivo();
		    double consumoTotal = c.getConsumoTotal();

		    JSONObject jsonObjTest = new JSONObject(); // Crie um novo objeto em cada iteração

		    jsonObjTest.put("nomeDispositivo", nomeDispositivo);
		    jsonObjTest.put("consumoTotal", consumoTotal);

		    jsonArray.put(jsonObjTest);
		}
		
        return jsonArray.toString();
    }
}

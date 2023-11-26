package com.lumiere.boot.web.api;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lumiere.boot.dao.RankingConsumidorDao;
import com.lumiere.boot.dao.RelatorioConsumoDao;
import com.lumiere.boot.domain.RankingConsumidor;
import com.lumiere.boot.domain.RelatorioConsumo;
import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.UsuarioService;

@Controller
@RequestMapping("/API")
public class APIController {
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RankingConsumidorDao rankingConsumidorDao;
	
	@Autowired
	private RelatorioConsumoDao relatorioConsumoDao;
	
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
	
	public Map<Usuario, Double> obtemRankingConsumidor() {
		List<RankingConsumidor> listaRankingConsumidor = rankingConsumidorDao.callConsultaRankingConsumidor();
		
		List<Integer> listCdUsuario = new ArrayList<Integer>();
		for (RankingConsumidor r: listaRankingConsumidor) {
			if (!listCdUsuario.contains(r.getCdUsuario()))
				listCdUsuario.add(r.getCdUsuario());
		}
		
		Map<Integer, Double> consumoPorUsuario = new HashMap<>();
		for (int cdUsuario: listCdUsuario) {
			List<RankingConsumidor> listDadosUsuario = listaRankingConsumidor.stream().filter(t -> t.getCdUsuario() == cdUsuario).collect(Collectors.toList());
			
			if (listDadosUsuario.size() > 1) {
				double mesAnteanterior = listDadosUsuario.get(0).getTotalKWhMes();
				double mesAnterior = listDadosUsuario.get(1).getTotalKWhMes();
				
				double consumoDesseMes = ((mesAnterior - mesAnteanterior) / mesAnterior) * mesAnterior;
								
				consumoPorUsuario.put(cdUsuario, consumoDesseMes);
			}
		}
				
		Map<Usuario, Double> rankingUsuario = new HashMap<>();
		for (Map.Entry<Integer, Double> entry : consumoPorUsuario.entrySet()) {
		    int cdUsuario = entry.getKey();
		    double consumo = entry.getValue();
		    
		    Usuario usuario = usuarioService.buscarUsuarioPorCd(cdUsuario);
		    
		    rankingUsuario.put(usuario, consumo);
		}

		rankingUsuario = rankingUsuario.entrySet().stream().sorted(Entry.comparingByValue()).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		return rankingUsuario;
	}
}

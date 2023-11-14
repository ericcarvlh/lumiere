package com.lumiere.boot.web.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lumiere.boot.api.viaCEP.ViaCEP;
import com.lumiere.boot.api.viaCEP.domain.Endereco;
import com.lumiere.boot.dao.UsuarioDaoImpl;
import com.lumiere.boot.domain.Consumo;
import com.lumiere.boot.domain.Estado;
import com.lumiere.boot.domain.IconeResidencia;
import com.lumiere.boot.domain.Residencia;
import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.repository.residencia.ConsultaMediaConsumoAnual;
import com.lumiere.boot.repository.residencia.SPConsultaMediaConsumoAnual;
import com.lumiere.boot.service.ConsumoService;
import com.lumiere.boot.service.EstadoService;
import com.lumiere.boot.service.IconeResidenciaService;
import com.lumiere.boot.service.ResidenciaService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
@RequestMapping("/Residencia")
public class ResidenciaController {	
	@Autowired
	UsuarioDaoImpl usuarioDaoImpl;
	
	@Autowired
	private IconeResidenciaService iconeResidenciaService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired 
	private ResidenciaService residenciaService;
	
	@Autowired 
	private ConsumoService consumoService ;
	
	@Autowired
	SPConsultaMediaConsumoAnual spConsultaMediaConsumoAnual;
	
	@GetMapping("/Residencias") 
	public String residencias(@AuthenticationPrincipal UserDetails currentUser) {
		// coleta os dados do usuario logado
		Usuario usuario = (Usuario) usuarioDaoImpl.buscarUsuarioPorEmail(currentUser.getUsername());
		
		return "/Residencia/Residencias";
	}
	
	@GetMapping("/Cadastrar")
	public String registrar(IconeResidencia iconeResidencia, Residencia residencia, Model model) {
		model.addAttribute("iconesResidencia", iconeResidenciaService.buscarTodos());
		
		return "/Residencia/Cadastrar";
	}
	
	@PostMapping("/Cadastrar")
	public String registrar(int cdIconeResidencia, Residencia residencia, Model model, @AuthenticationPrincipal UserDetails currentUser) {
		// pego o cep e consulto no banco primeiro para ver se ele já foi cadastrado
		// para evitar o consumo de API's
		// pego os outros atributos e seto eles nas tabelas
		Usuario usuario = (Usuario) usuarioDaoImpl.buscarUsuarioPorEmail(currentUser.getUsername());
		try {
			// uso a API ViaCEP (apos validar o CEP) para pesquisar os dados do endereco
			Endereco endereco = ViaCEP.buscaEnderecoPeloCEP(residencia.getCepResidencia());
			// pego o estado, pesquiso no meu banco
			// pego o id desse estado que eu obtive
			// jogo os dados em um objeto do tipo Estado
			Estado estado = estadoService.buscarEstadoPorUF(endereco.getUFEstado());
			// seto os dados na residencia para associar
			residencia.setEstado(estado);
			// seto os dados na residencia para associar
			residencia.setUsuario(usuario);
			// agora posso salvar no banco pois possuo todos os dados necessarios
			IconeResidencia iconeResidencia = new IconeResidencia();
			iconeResidencia.setId(cdIconeResidencia);
			residencia.setIconeResidencia(iconeResidencia);
			residenciaService.salvar(residencia);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/Residencia/Listar";
	}
	
	@GetMapping("/Listar")
	public String listar(Model model, @AuthenticationPrincipal UserDetails currentUser) {
		Usuario usuario = (Usuario) usuarioDaoImpl.buscarUsuarioPorEmail(currentUser.getUsername());
		
		List<Residencia> residenciasUsuario = residenciaService.buscarResidenciasPorUsuario(usuario.getId());
		boolean botaoAdicionarResidencia = true;
		if (residenciasUsuario.size() > 3) {
			botaoAdicionarResidencia = false;
			residenciasUsuario.remove(3);
		}
		
		model.addAttribute("residenciasUsuario", residenciasUsuario);
		model.addAttribute("botaoAdicionarResidencia", botaoAdicionarResidencia);
		
		return "/Residencia/Listar";
	}
	
	@GetMapping("/Todas")
	public String listarTodasResidencias(Model model, @AuthenticationPrincipal UserDetails currentUser) {
		Usuario usuario = (Usuario) usuarioDaoImpl.buscarUsuarioPorEmail(currentUser.getUsername());
				
		model.addAttribute("residenciasUsuario", residenciaService.buscarTodasResidenciasPorUsuario(usuario.getId()));
		
		return "/Residencia/Todas";
	}
	
	@GetMapping("/Detalhes/{cdResidencia}") 
	public String detalhes(@PathVariable("cdResidencia") int cdResidencia) {
		
		return "/Residencia/Detalhes";
	}

	
	@PostMapping("/obterGastoAnualPorResidencia/{cdResidencia}")
    @ResponseBody
	public String obterResidencias(@PathVariable("cdResidencia") int cdResidencia) {				                
		List<Consumo> listConsumo = consumoService.buscarConsumosPorCdResidencia(cdResidencia);
				
		spConsultaMediaConsumoAnual.getUerInfo(cdResidencia);
		
		Map<Integer, Double> mapValores = new HashMap<Integer, Double>();
		for (Consumo consumo: listConsumo) {
			try {
				String input = consumo.getDataConsumo().toString().replace( " " , "T" );
				double valorConsumo = consumo.getPrecoConsumo();
				LocalDateTime ltd = LocalDateTime.parse(input);
				
				int ano = ltd.getYear();
				int mes = ltd.getMonthValue();
				if (!mapValores.containsKey(ano))
					mapValores.put(ano, valorConsumo);
				else
					mapValores.put(ano, mapValores.get(ano) + valorConsumo);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
				
		JSONArray array = new JSONArray();
		for (Map.Entry<Integer, Double> entry : mapValores.entrySet()) {
		    int ano = entry.getKey();
		    double consumoTotal = entry.getValue() / 12;

		    JSONObject jsonObjTest = new JSONObject(); // Crie um novo objeto em cada iteração

		    jsonObjTest.put("ano", ano);
		    jsonObjTest.put("consumoTotal", consumoTotal);

		    array.put(jsonObjTest);
		}	
		
        return array.toString();
    }
}

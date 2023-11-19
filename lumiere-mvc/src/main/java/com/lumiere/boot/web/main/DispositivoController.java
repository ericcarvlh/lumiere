package com.lumiere.boot.web.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lumiere.boot.domain.Consumo;
import com.lumiere.boot.domain.Dispositivo;
import com.lumiere.boot.domain.Residencia;
import com.lumiere.boot.domain.TipoDispositivo;
import com.lumiere.boot.service.ConsumoServiceImpl;
import com.lumiere.boot.service.DispositivoServiceImpl;
import com.lumiere.boot.service.TipoDispositivoServiceImpl;

@Controller
@RequestMapping("/Dispositivo")
public class DispositivoController {
	@Autowired
	TipoDispositivoServiceImpl tipoDispositivoServiceImpl;	
	
	@Autowired
	ConsumoServiceImpl consumoServiceImpl;
	
	@Autowired
	DispositivoServiceImpl dispositivoServiceImpl;
	
	@GetMapping("/Cadastrar/{cdResidencia}")
	public String cadastrar(@PathVariable("cdResidencia") int cdResidencia, Dispositivo dispositivo, Model model) {
		// coletar as categorias	
		model.addAttribute("tipoDispositivos", tipoDispositivoServiceImpl.buscarTodos());
		
		return "/Dispositivo/Cadastrar";
	}
	
	@PostMapping("/Cadastrar")
	public String cadastrar(Dispositivo dispositivo, @RequestParam(name = "categoriaSelect") int cdCategoria, int cdResidencia) {
		// coletando a categoria selecionada pelo usuário
		TipoDispositivo tipoDispositivo = new TipoDispositivo();
		tipoDispositivo.setId(cdCategoria);
		dispositivo.setTipoDispositivo(tipoDispositivo);
		
		Residencia residencia = new Residencia();
		residencia.setId(cdResidencia);
		dispositivo.setResidencia(residencia);
		
		dispositivoServiceImpl.salvar(dispositivo);
				
		return "/Dispositivo/Cadastrar";
	}
	
	@GetMapping("/Listar/{cdResidencia}")
	public String listar(Model model, @PathVariable("cdResidencia") int cdResidencia) {
		
		model.addAttribute("dispositivosUsuario", dispositivoServiceImpl.consultarDispositivosPorCdResidencia(cdResidencia));
		
		return "/Dispositivo/Listar";
	}
	
	@GetMapping("/Detalhes/{cdDispositivo}")
	public String detalhes(Model model, @PathVariable("cdDispositivo") int cdDispositivo) {
		Dispositivo dispositivo = dispositivoServiceImpl.consultarDispositivoPorCdDispositivo(cdDispositivo);
		List<TipoDispositivo> tiposDispositivos = tipoDispositivoServiceImpl.buscarTodos();
		List<Consumo> list = consumoServiceImpl.buscarConsumosPorCdDispositivo(cdDispositivo);
		
		double consumoTotal = 0;
		for (Consumo c: list) {
			consumoTotal += c.getPrecoConsumo();
		}

		model.addAttribute("tipoDispositivos", tiposDispositivos);
		model.addAttribute("infoDispositivo", dispositivo);
		model.addAttribute("consumoTotal", consumoTotal);
		model.addAttribute("consumosDispositivo", list);
		
		return "/Dispositivo/Detalhes";
	}
	
	@PostMapping(value="/Atualizar", params = "save")
	public String atualizar(@RequestParam(name = "categoriaSelect") int cdCategoria, int cdDispositivo, String nomeDispositivo, double watts, int tempoDeConsumo, int cdResidencia) {
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.setId(cdDispositivo);
		dispositivo.setWattsDispositivo(watts);
		dispositivo.setTempoUsoDiario(tempoDeConsumo);
		dispositivo.setNomeDispositivo(nomeDispositivo);
		TipoDispositivo tipoDispositivo = new TipoDispositivo();
		tipoDispositivo.setId(cdCategoria);
		Residencia residencia = new Residencia();
		residencia.setId(cdResidencia);
		
		dispositivo.setResidencia(residencia);
		dispositivo.setTipoDispositivo(tipoDispositivo);
		
		dispositivoServiceImpl.atualizar(dispositivo);
				
		return String.format("redirect:/Dispositivo/Listar/%d", cdDispositivo);		
	}
	
	@PostMapping(value="/Atualizar", params = "delete")
	public String apagar(int cdResidencia, int cdDispositivo) {
		dispositivoServiceImpl.deletar(cdDispositivo);
				
		return String.format("redirect:/Dispositivo/Listar/%d", cdResidencia);
	}
}

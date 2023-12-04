package com.lumiere.boot.web.main;

import java.text.NumberFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lumiere.boot.api.viaCEP.ViaCEP;
import com.lumiere.boot.api.viaCEP.domain.Endereco;
import com.lumiere.boot.dao.FechamentoConsumoDao;
import com.lumiere.boot.dao.RelatorioConsumoDao;
import com.lumiere.boot.dao.UsuarioDaoImpl;
import com.lumiere.boot.domain.Consumo;
import com.lumiere.boot.domain.Dispositivo;
import com.lumiere.boot.domain.Estado;
import com.lumiere.boot.domain.IconeResidencia;
import com.lumiere.boot.domain.Residencia;
import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.ConsumoService;
import com.lumiere.boot.service.DispositivoService;
import com.lumiere.boot.service.EstadoService;
import com.lumiere.boot.service.IconeResidenciaService;
import com.lumiere.boot.service.ResidenciaService;
import com.lumiere.boot.service.UsuarioService;

@Controller
@RequestMapping("/Residencia")
public class ResidenciaController {	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RelatorioConsumoDao relatorioConsumoDao;
	
	@Autowired
	private IconeResidenciaService iconeResidenciaService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired 
	private ResidenciaService residenciaService;
	
	@Autowired
	private FechamentoConsumoDao fechamentoConsumoDao;
	
	@Autowired
	private DispositivoService dispositivoService;
	
	@Autowired
	private ConsumoService consumoService;
	
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
		Usuario usuario = (Usuario) usuarioService.buscarUsuarioPorEmail(currentUser.getUsername());
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
		Usuario usuario = (Usuario) usuarioService.buscarUsuarioPorEmail(currentUser.getUsername());
		
		List<Residencia> residenciasUsuario = residenciaService.buscarResidenciasPorUsuario(usuario.getId());
		boolean botaoAdicionarResidencia = true;
		if (residenciasUsuario.size() > 3) {
			botaoAdicionarResidencia = false;
			residenciasUsuario.remove(3);
		}
		
		model.addAttribute("residencia1", residenciasUsuario.size() > 0 ? residenciasUsuario.get(0) : null);
		model.addAttribute("residencia2", residenciasUsuario.size() > 1 ? residenciasUsuario.get(1) : null);
		model.addAttribute("residencia3", residenciasUsuario.size() > 2 ? residenciasUsuario.get(2) : null);
		
		boolean zeroResidencia = residenciasUsuario.isEmpty();
		boolean umaResidencia = residenciasUsuario.size() == 1;
		boolean duasResidencias = residenciasUsuario.size() == 2;
		boolean tresResidencias = residenciasUsuario.size() >= 3;
		model.addAttribute("zeroResidencia", zeroResidencia);
		model.addAttribute("umaResidencia", umaResidencia);
		model.addAttribute("duasResidencias", duasResidencias);
		model.addAttribute("tresResidencias", tresResidencias);
		
		
		model.addAttribute("residenciasUsuario", residenciasUsuario);
		model.addAttribute("botaoAdicionarResidencia", botaoAdicionarResidencia);
		
		return "/Residencia/Listar";
	}
	
	@GetMapping("/Todas")
	public String listarTodasResidencias(Model model, @AuthenticationPrincipal UserDetails currentUser) {
		Usuario usuario = (Usuario) usuarioService.buscarUsuarioPorEmail(currentUser.getUsername());
				
		model.addAttribute("residenciasUsuario", residenciaService.buscarTodasResidenciasPorUsuario(usuario.getId()));
		
		return "/Residencia/Todas";
	}
	
	@GetMapping("/Detalhes/{cdResidencia}") 
	public String detalhes(Model model, @PathVariable("cdResidencia") int cdResidencia) {		
		Residencia residencia = residenciaService.buscarResidenciaPorCdResidencia(cdResidencia);		
		
		Map<Integer, Date> mapUltimosConsumos = fechamentoConsumoDao.consultaUltimoConsumoPorResidencia(cdResidencia);
		
		boolean temFechamento = false;
		for (Map.Entry<Integer, Date> entry : mapUltimosConsumos.entrySet()) {
		    int cdDispositivo = entry.getKey();
		    Date ultimoConsumo = entry.getValue();
		    
		    if (ultimoConsumo.before(new Date())) {
		    	long diff = new Date().getTime() - ultimoConsumo.getTime();
		        int quantidade = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		        Dispositivo dispositivo = dispositivoService.consultarDispositivoPorCdDispositivo(cdDispositivo);
		        double precoKwh = residencia.getEstado().getPrecoKwh();
		        double kwh = (dispositivo.getWattsDispositivo() * dispositivo.getTempoUsoDiario()) / 1000;
		        
		        for (int i = 1; i <= quantidade; i++) {
			        Calendar c = Calendar.getInstance(); 
			        c.setTime(ultimoConsumo); 
			        c.add(Calendar.DATE, i);	
			        Consumo consumo = new Consumo();
			        consumo.setDataConsumo(c.getTime());
			        consumo.setDispositivo(dispositivo);
			        consumo.setKwhConsumo(kwh);
			        consumo.setPrecoConsumo((precoKwh * kwh));
			        
			        consumoService.salvar(consumo);
		        }
		    }
		    	
		}
		
		if (temFechamento)
			return String.format("redirect:/Residencia/%d", cdResidencia);
		
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		String valorPorKWh = formatter.format(residencia.getEstado().getPrecoKwh());
		String faturaAtual = formatter.format(relatorioConsumoDao.callConsultaFaturaAtual(cdResidencia).getConsumoTotal());
		String consumoMedio = formatter.format(relatorioConsumoDao.callConsultaConsumoMedio60Dias(cdResidencia).getConsumoTotal());
		
		model.addAttribute("cdResdencia", cdResidencia);
		model.addAttribute("UFEstado", residencia.getEstado().getUFEstado());
		model.addAttribute("precoKWh", valorPorKWh);
		model.addAttribute("faturaAtual", faturaAtual);
		model.addAttribute("consumoMedio", consumoMedio);
		
		return "/Residencia/Detalhes";
	}	
}

package com.lumiere.boot.web.main.integracao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumiere.boot.dao.RelatorioConsumoDao;
import com.lumiere.boot.domain.IconeResidencia;
import com.lumiere.boot.domain.Residencia;
import com.lumiere.boot.service.EstadoService;
import com.lumiere.boot.service.IconeResidenciaService;
import com.lumiere.boot.service.ResidenciaService;
import com.lumiere.boot.service.UsuarioService;
import com.lumiere.boot.web.main.ResidenciaController;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.List;

@WebMvcTest(ResidenciaController.class)
public class ResidenciaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private RelatorioConsumoDao relatorioConsumoDao;

    @MockBean
    private IconeResidenciaService iconeResidenciaService;

    @MockBean
    private EstadoService estadoService;

    @MockBean
    private ResidenciaService residenciaService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    void testResidencias() throws Exception {
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Mockito.when(userDetails.getUsername()).thenReturn("user@example.com");

        mockMvc.perform(MockMvcRequestBuilders.get("/Residencia/Residencias")
                .with(SecurityMockMvcRequestPostProcessors.user(userDetails)))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.view().name("/Residencia/Residencias"));
    }

    @Test
    void testRegistrarGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Residencia/Cadastrar"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.view().name("/Residencia/Cadastrar"));
    }

    @Test
    void testRegistrarPost() throws Exception {
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Mockito.when(userDetails.getUsername()).thenReturn("user@example.com");

        IconeResidencia iconeResidencia = new IconeResidencia();
        iconeResidencia.setId(1);

        mockMvc.perform(MockMvcRequestBuilders.post("/Residencia/Cadastrar")
                .param("cdIconeResidencia", "1")
                .param("cepResidencia", "12345-678")
                .param("outrosAtributos", "valor")
                .with(SecurityMockMvcRequestPostProcessors.user(userDetails)))
               .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
               .andExpect(MockMvcResultMatchers.redirectedUrl("/Residencia/Listar"));
    }

    @Test
    void testListar() throws Exception {
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Mockito.when(userDetails.getUsername()).thenReturn("user@example.com");

        Residencia residencia1 = new Residencia();
        Residencia residencia2 = new Residencia();
        Residencia residencia3 = new Residencia();
        List<Residencia> residencias = Arrays.asList(residencia1, residencia2, residencia3);

        Mockito.when(residenciaService.buscarResidenciasPorUsuario(1));

        mockMvc.perform(MockMvcRequestBuilders.get("/Residencia/Listar")
                .with(SecurityMockMvcRequestPostProcessors.user(userDetails)))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.view().name("/Residencia/Listar"))
               .andExpect(MockMvcResultMatchers.model().attribute("residencia1", residencia1))
               .andExpect(MockMvcResultMatchers.model().attribute("residencia2", residencia2))
               .andExpect(MockMvcResultMatchers.model().attribute("residencia3", residencia3))
               .andExpect(MockMvcResultMatchers.model().attribute("residenciasUsuario", residencias))
               .andExpect(MockMvcResultMatchers.model().attribute("botaoAdicionarResidencia", true));
    }

    @Test
    void testListarTodasResidencias() throws Exception {
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Mockito.when(userDetails.getUsername()).thenReturn("user@example.com");

        Residencia residencia1 = new Residencia();
        Residencia residencia2 = new Residencia();
        List<Residencia> todasResidencias = Arrays.asList(residencia1, residencia2);

        Mockito.when(residenciaService.buscarTodasResidenciasPorUsuario(1));

        mockMvc.perform(MockMvcRequestBuilders.get("/Residencia/Todas")
                .with(SecurityMockMvcRequestPostProcessors.user(userDetails)))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.view().name("/Residencia/Todas"))
               .andExpect(MockMvcResultMatchers.model().attribute("residenciasUsuario", todasResidencias));
    }

    @Test
    void testDetalhes() throws Exception {
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Mockito.when(userDetails.getUsername()).thenReturn("user@example.com");

        Residencia residencia = new Residencia();
        Mockito.when(residenciaService.buscarResidenciaPorCdResidencia(Mockito.anyInt())).thenReturn(residencia);

        mockMvc.perform(MockMvcRequestBuilders.get("/Residencia/Detalhes/1")
                .with(SecurityMockMvcRequestPostProcessors.user(userDetails)))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.view().name("/Residencia/Detalhes"))
               .andExpect(MockMvcResultMatchers.model().attribute("UFEstado", Mockito.anyString()))
               .andExpect(MockMvcResultMatchers.model().attribute("precoKWh", Mockito.anyString()))
               .andExpect(MockMvcResultMatchers.model().attribute("faturaAtual", Mockito.anyString()))
               .andExpect(MockMvcResultMatchers.model().attribute("consumoMedio", Mockito.anyString()));
    }
}

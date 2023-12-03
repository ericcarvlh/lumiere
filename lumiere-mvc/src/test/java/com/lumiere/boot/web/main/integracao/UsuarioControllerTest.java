package com.lumiere.boot.web.main.integracao;

import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.UsuarioService;
import com.lumiere.boot.web.api.APIController;
import com.lumiere.boot.web.main.UsuarioController;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

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

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private APIController rankingConsumidorAPI;

    @Test
    @WithMockUser
    void testCadastraUsuario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Usuario/Cadastrar"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("/Cadastro/usuario"));
    }

    @Test
    @WithMockUser
    void testLogarUsuario() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Usuario/Login"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("/Login/login"));
    }

    @Test
    @WithMockUser
    void testTopConsumidores() throws Exception {
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Mockito.when(userDetails.getUsername()).thenReturn("diogogod@gmail.com");

        Usuario usuarioEsperado = new Usuario();
        usuarioEsperado.setEmailUsuario("eric.carvalho@fa.com.br");
        usuarioEsperado.setNomeUsuario("Eric");
        usuarioEsperado.setSenhaUsuario("12345");
        
        Mockito.when(usuarioService.buscarUsuarioPorEmail("diogogod@gmail.com")).thenReturn(usuarioEsperado);
        Map<Usuario, Double> mapRankingEsperado = new HashMap<>();
        mapRankingEsperado.put(usuarioEsperado, 0.2);
        mapRankingEsperado.put(usuarioEsperado, 0.4);
        
        Mockito.when(rankingConsumidorAPI.obtemRankingConsumidor()).thenReturn(mapRankingEsperado);

        mockMvc.perform(MockMvcRequestBuilders.get("/Usuario/Ranking").with(SecurityMockMvcRequestPostProcessors.user(userDetails)))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("/Usuario/Ranking"))
        .andExpect(MockMvcResultMatchers.model().attribute("infoUsuarioLogado", usuarioEsperado))
        .andExpect(MockMvcResultMatchers.model().attributeExists("rankingConsumidor"));
    }
}

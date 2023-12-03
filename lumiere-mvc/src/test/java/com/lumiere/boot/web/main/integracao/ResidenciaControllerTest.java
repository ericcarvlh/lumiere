package com.lumiere.boot.web.main.integracao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.lumiere.boot.dao.RelatorioConsumoDao;
import com.lumiere.boot.domain.RelatorioConsumo;
import com.lumiere.boot.domain.Residencia;
import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.ResidenciaService;
import com.lumiere.boot.service.UsuarioService;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class ResidenciaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;
    
    @MockBean
    private RelatorioConsumoDao relatorioConsumoDao;

    @MockBean
    private ResidenciaService residenciaService;
    
    @Test
    @WithMockUser
    public void testRegistrarGet() throws Exception {
        mockMvc.perform(get("/Residencia/Cadastrar"))
        .andExpect(status().isOk())
        .andExpect(view().name("/Residencia/Cadastrar"))
        .andExpect(model().attributeExists("iconesResidencia"));
    }

    @Test
    @WithMockUser
    public void testRegistrarPost() throws Exception {
        when(usuarioService.buscarUsuarioPorEmail(anyString())).thenReturn(new Usuario()); // Substitua pela lógica real

        mockMvc.perform(post("/Residencia/Cadastrar")
        .param("cdIconeResidencia", "1")
        .param("cepResidencia", "12345678"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/Residencia/Listar"));

        verify(usuarioService, times(1)).buscarUsuarioPorEmail(anyString());
    }
}

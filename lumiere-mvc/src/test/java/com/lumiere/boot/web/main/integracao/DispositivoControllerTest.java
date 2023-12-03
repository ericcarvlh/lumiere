package com.lumiere.boot.web.main.integracao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class DispositivoControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Test
    @WithMockUser
    public void testCadastrarGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Dispositivo/Cadastrar/{cdResidencia}", 1))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.view().name("/Dispositivo/Cadastrar"))
               .andExpect(MockMvcResultMatchers.model().attributeExists("tipoDispositivos"));
    }

    @Test
    @WithMockUser
    void testListar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Dispositivo/Listar/{cdResidencia}", 1))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("/Dispositivo/Listar"))
        .andExpect(MockMvcResultMatchers.model().attributeExists("dispositivosUsuario"));
    }

    @Test
    @WithMockUser
    void testDetalhes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Dispositivo/Detalhes/{cdDispositivo}", 1))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("/Dispositivo/Detalhes"))
        .andExpect(MockMvcResultMatchers.model().attributeExists("tipoDispositivos", "infoDispositivo", "consumoTotal", "consumosDispositivo"));
    }

    @Test
    @WithMockUser
    void testAtualizarSave() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.post("/Dispositivo/Atualizar")
        .param("categoriaSelect", "1")
        .param("cdDispositivo", "1")
        .param("nomeDispositivo", "NomeDispositivo")
        .param("watts", "100.0")
        .param("tempoDeConsumo", "2")
        .param("cdResidencia", "1")
        .param("save", ""))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/Dispositivo/Listar/1"));
    }

    @Test
    @WithMockUser
    void testAtualizarDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/Dispositivo/Atualizar")
        .param("cdResidencia", "1")
        .param("cdDispositivo", "1")
        .param("delete", ""))
        .andExpect(MockMvcResultMatchers.redirectedUrl("/Dispositivo/Listar/1"));
    }
}
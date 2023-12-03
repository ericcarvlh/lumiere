package com.lumiere.boot.web.main.integracao;

import com.lumiere.boot.dao.RelatorioConsumoDao;
import com.lumiere.boot.domain.RelatorioConsumo;
import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.UsuarioService;
import com.lumiere.boot.web.main.RelatorioController;

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

@WebMvcTest(RelatorioController.class)
public class RelatorioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private RelatorioConsumoDao relatorioConsumoDao;

    @Test
    @WithMockUser
    void testListaRelatorio() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Relatorio/Lista"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("/Relatorio/Lista"));
    }

    @Test
    @WithMockUser
    void testComparativoDeRelatorioGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Relatorio/Comparar"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("/Relatorio/Comparar"))
        .andExpect(MockMvcResultMatchers.model().attribute("primeiroRelatorio", null))
        .andExpect(MockMvcResultMatchers.model().attribute("segundoRelatorio", null));
    }

    @Test
    @WithMockUser
    void testComparativoDeRelatorioPost() throws Exception {
        UserDetails userDetails = Mockito.mock(UserDetails.class);
        Mockito.when(userDetails.getUsername()).thenReturn("user@example.com");

        Usuario usuario = new Usuario();
        usuario.setEmailUsuario("user@example.com");
        Mockito.when(usuarioService.buscarUsuarioPorEmail("user@example.com")).thenReturn(usuario);

        RelatorioConsumo primeiroRelatorio = new RelatorioConsumo();
        RelatorioConsumo segundoRelatorio = new RelatorioConsumo();
        Mockito.when(relatorioConsumoDao.callConsultaRelatorioPorPeriodo(1, "2023-10-02", "2023-11-02")).thenReturn(primeiroRelatorio);
        Mockito.when(relatorioConsumoDao.callConsultaRelatorioPorPeriodo(1, "2023-10-02", "2023-11-02")).thenReturn(segundoRelatorio);

        mockMvc.perform(MockMvcRequestBuilders.post("/Relatorio/Comparar")
        .param("primeiroDataInicial", "dataInicial1")
        .param("primeiroDataFinal", "dataFinal1")
        .param("segundoDataInicial", "dataInicial2")
        .param("segundoDataFinal", "dataFinal2")
        .with(SecurityMockMvcRequestPostProcessors.user(userDetails)))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("/Relatorio/Comparar"))
        .andExpect(MockMvcResultMatchers.model().attribute("primeiroRelatorio", primeiroRelatorio))
        .andExpect(MockMvcResultMatchers.model().attribute("segundoRelatorio", segundoRelatorio));
    }
}

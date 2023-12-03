package com.lumiere.boot.unitario.service;

import com.lumiere.boot.dao.UsuarioDao;
import com.lumiere.boot.domain.Usuario;
import com.lumiere.boot.service.UsuarioServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UsuarioServiceImplTest {

    @Mock
    private UsuarioDao usuarioDao;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvar() {
        Usuario usuario = new Usuario();

        usuarioService.salvar(usuario);

        verify(usuarioDao).save(usuario);
    }

    @Test
    void buscarUsuarioPorEmail() {
        String email = "teste@sla.com";

        Usuario usuarioMock = new Usuario();
        when(usuarioDao.buscarUsuarioPorEmail(email)).thenReturn(usuarioMock);

        Usuario usuarioResult = usuarioService.buscarUsuarioPorEmail(email);

        assertEquals(usuarioMock, usuarioResult);
    }

    @Test
    void buscarUsuarioPorCd() {
        int cdUsuario = 1;

        Usuario usuarioMock = new Usuario();
        when(usuarioDao.findById(cdUsuario)).thenReturn(usuarioMock);

        Usuario usuarioResult = usuarioService.buscarUsuarioPorCd(cdUsuario);

        assertEquals(usuarioMock, usuarioResult);
    }
}
package com.lumiere.boot.service;

import com.lumiere.boot.domain.Usuario;

public interface UsuarioService {
	void salvar(Usuario usuario);
	
	Usuario buscarUsuarioPorEmail(String email);
	
	Usuario buscarUsuarioPorCd(int cdUsuario);
}

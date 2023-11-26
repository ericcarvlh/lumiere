package com.lumiere.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumiere.boot.dao.*;
import com.lumiere.boot.domain.Usuario;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public void salvar(Usuario usuario) {
		usuarioDao.save(usuario);
	}
	
	public Usuario buscarUsuarioPorEmail(String email) {
		return usuarioDao.buscarUsuarioPorEmail(email);
	}
	
	public Usuario buscarUsuarioPorCd(int cdUsuario) {
		return usuarioDao.findById(cdUsuario);
	}
}

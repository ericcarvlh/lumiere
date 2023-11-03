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
    /*private PasswordEncoder passwordEncoder;*/

    public UsuarioServiceImpl() {}
    /*
    public UsuarioServiceImpl(UsuarioDaoImpl userRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = userRepository; // repositorio do usuario
        this.passwordEncoder = passwordEncoder;
    }*/
    
	@Override
	public void salvar(Usuario usuario) {
		usuarioDao.save(usuario);
	}	
}

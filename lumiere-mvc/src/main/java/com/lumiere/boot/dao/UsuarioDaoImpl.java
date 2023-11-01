package com.lumiere.boot.dao;

import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.Usuario;

@Repository
public class UsuarioDaoImpl extends AbstractDao<Usuario, Long> implements UsuarioDao {

}

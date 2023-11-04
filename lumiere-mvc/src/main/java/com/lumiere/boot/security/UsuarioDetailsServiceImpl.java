package com.lumiere.boot.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.lumiere.boot.dao.UsuarioDaoImpl;
import com.lumiere.boot.domain.Usuario;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	@Autowired
    private UsuarioDaoImpl usuarioDaoImpl;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDaoImpl.buscarUsuarioPorEmail(username);

        if (usuario != null) {
            return new org.springframework.security.core.userdetails.User(
            		usuario.getEmailUsuario(), 
            		usuario.getSenhaUsuario(), 
            		getAuthorities(usuario)
            );
        } else
            throw new UsernameNotFoundException("Usuário não encontrado");
    }
    
    private List<GrantedAuthority> getAuthorities(Usuario usuario) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER")); // Role-based authorization
        return authorities;
    }
}

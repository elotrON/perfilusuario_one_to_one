package com.example.perfilusuario_one_to_one.service;

import com.example.perfilusuario_one_to_one.dto.UsuarioRequest;
import com.example.perfilusuario_one_to_one.dto.UsuarioResponse;
import com.example.perfilusuario_one_to_one.entity.Usuario;
import com.example.perfilusuario_one_to_one.repository.RepoBBDD;
import org.springframework.stereotype.Service;

@Service
public class usuarioService_tmp {

    private final RepoBBDD repoBBDD;

    public usuarioService_tmp(RepoBBDD repoBBDD) {
        this.repoBBDD =  repoBBDD;
    }

    public UsuarioResponse crearUsuario(UsuarioRequest nuevoUsuario){
        Usuario usuario = new Usuario();
        usuario.setNombre(nuevoUsuario.getNombre());
        usuario.setEmail(nuevoUsuario.getEmail());
        repoBBDD.save(usuario);

        return toResponse(usuario);
    }

    private UsuarioResponse toResponse(Usuario usuario){
        UsuarioResponse ures = new UsuarioResponse();
        ures.setId(usuario.getId());
        ures.setEmail(usuario.getEmail());
        ures.setNombre(usuario.getNombre());

        return ures;
    }

}

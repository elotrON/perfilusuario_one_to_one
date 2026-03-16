package com.example.perfilusuario_one_to_one.controller;

import com.example.perfilusuario_one_to_one.dto.UsuarioRequest;
import com.example.perfilusuario_one_to_one.dto.UsuarioResponse;
import com.example.perfilusuario_one_to_one.service.usuarioService_tmp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class usuarioController {

    private final usuarioService_tmp usuarioService;

    public usuarioController(usuarioService_tmp usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuarios")
    public UsuarioResponse altaUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.crearUsuario(usuarioRequest);
    }

}

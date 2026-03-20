package com.example.perfilusuario_one_to_one.controller;

import com.example.perfilusuario_one_to_one.dto.PerfilResponse;
import com.example.perfilusuario_one_to_one.dto.PerfilRequest;
import com.example.perfilusuario_one_to_one.dto.UsuarioRequest;
import com.example.perfilusuario_one_to_one.dto.UsuarioResponse;
import com.example.perfilusuario_one_to_one.service.UsuarioService;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

@RestController
public class usuarioController {

    private final UsuarioService usuarioService;

    public usuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * CREAR USUARIO
     *
     * @param usuarioRequest
     * @return
     */
    @PostMapping("/usuarios")
    public UsuarioResponse altaUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.crearUsuario(usuarioRequest);
    }

    /**
     * MODIFICAR USUARIO
     *
     * @param id
     * @param usuarioRequest
     * @return
     */
    @PatchMapping("/usuarios/{id}")
    public UsuarioResponse modificarUsuario(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest){
        return(usuarioService.modificarUsuario(id, usuarioRequest));
    }

    /**
     * AGREGAR PERFIL A USUARIO EXISTENTE
     *
     * @param id
     * @param perfilRequest
     * @return
     */
    @PostMapping("usuarios/{id}")
    public PerfilResponse crearPerfil(@PathVariable Integer id, @RequestBody PerfilRequest perfilRequest){
        return usuarioService.crearPerfil(id, perfilRequest);
    }

    @GetMapping("/usuarios/{id}")
    public UsuarioResponse obtenerUsuario(@PathVariable Integer id){
        return usuarioService.obtenerUsuarioPorId(id);
    }




}

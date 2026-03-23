package com.example.perfilusuario_one_to_one.controller;

import com.example.perfilusuario_one_to_one.dto.*;
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

    /**
     * OBTIENE LOS DATOS DE UN USUARIO (NO OBIENE EL PERFIL)
     *
     * @param id
     * @return
     */
    @GetMapping("/usuarios/{id}")
    public UsuarioResponse obtenerUsuario(@PathVariable Integer id){
        return usuarioService.obtenerUsuarioPorId(id);
    }

    /**
     * REEMPLAZA TODOS LOS DATOS DEL USUARIO
     *
     * @param id
     * @param usuarioRequest
     * @return
     */
    @PutMapping("/usuarios/{id}")
    public UsuarioResponse reemplazarUsuario(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest){
        return usuarioService.reemplazarUsuario(id, usuarioRequest);

    }

    /**
     * OBTIENE LOS DATOS DE UN USUARIO Y SU PERFIL
     * @param id
     * @return
     */
    @GetMapping("/usuarios/{id}/perfil")
    public UsuarioConPerfilResponse obtenerUsuarioConPerfil(@PathVariable Integer id){
        return usuarioService.obtenerUsuarioConPerfilPorId(id);
    }





}

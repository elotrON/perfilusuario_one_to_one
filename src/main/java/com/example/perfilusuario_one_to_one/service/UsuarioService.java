package com.example.perfilusuario_one_to_one.service;

import com.example.perfilusuario_one_to_one.dto.PerfilRequest;
import com.example.perfilusuario_one_to_one.dto.PerfilResponse;
import com.example.perfilusuario_one_to_one.dto.UsuarioRequest;
import com.example.perfilusuario_one_to_one.dto.UsuarioResponse;
import com.example.perfilusuario_one_to_one.entity.Perfil;
import com.example.perfilusuario_one_to_one.entity.Usuario;
import com.example.perfilusuario_one_to_one.repository.PerfilRepository;
import com.example.perfilusuario_one_to_one.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
    }

    /**
     * CREAR USUARIO
     * @param nuevoUsuario
     * @return
     */
    public UsuarioResponse crearUsuario(UsuarioRequest nuevoUsuario){
        // TODO IMPLEMENTAR QUE AL CREAR USUARIO SE CREE TAMBIEN EL PERFIL Y ESTABLECER SU RELACION

        Usuario usuario = new Usuario();
        usuario.setNombre(nuevoUsuario.getNombre());
        usuario.setEmail(nuevoUsuario.getEmail());
        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }


    /**
     * MODIFICAR LOS DATOS DEL USUARIO
     *
     * @param id
     * @param usuarioRequest
     * @return
     */
    public UsuarioResponse modificarUsuario(Integer id, UsuarioRequest usuarioRequest){
        Usuario usuario = new Usuario();
        usuario = usuarioRepository.findById(id).orElse(null);

        if(usuarioRequest.getEmail() != null) usuario.setEmail(usuarioRequest.getEmail());
        if(usuarioRequest.getNombre() != null) usuario.setNombre(usuarioRequest.getNombre());

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }

    // TODO IMPLEMENTAR QUE SE PUEDA CREAR EL PERFIL PARA UN USUARIO
    public PerfilResponse crearPerfil(Integer idUsuario, PerfilRequest perfilRequest){

        // Recibir el idUsuario del usuario

        // Buscar el usuario en base de datos
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario == null) return null;

        // Comprobar si ese usuario ya tiene perfil
        if(usuario.getPerfil() != null) return null;

        // Crear el objeto perfil
        Perfil perfil = new Perfil();

        // Asociar el perfil al usuario
        perfil.setUsuario(usuario);
        perfil.setDireccion(perfilRequest.getDireccion());
        perfil.setTelefono(perfilRequest.getTelefono());

        usuario.setPerfil(perfil);

        // Guardar
        perfilRepository.save(perfil);

        // Devolver respuesta
        return toResponse(perfil);
    }


    // TODO CONSULTAR DATOS DE USUARIO Y PERFIL



    private PerfilResponse toResponse(Perfil perfil){
        PerfilResponse perfilResponse = new PerfilResponse();
        perfilResponse.setDireccion(perfil.getDireccion());
        perfilResponse.setTelefono(perfil.getTelefono());

        return perfilResponse;
    }

    private UsuarioResponse toResponse(Usuario usuario){
        UsuarioResponse ures = new UsuarioResponse();
        ures.setId(usuario.getId());
        ures.setEmail(usuario.getEmail());
        ures.setNombre(usuario.getNombre());

        return ures;
    }

}

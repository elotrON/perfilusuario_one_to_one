package com.example.perfilusuario_one_to_one;

import com.example.perfilusuario_one_to_one.dto.UsuarioRequest;
import com.example.perfilusuario_one_to_one.dto.UsuarioResponse;
import com.example.perfilusuario_one_to_one.entity.Usuario;
import com.example.perfilusuario_one_to_one.repository.RepoBBDD;
import com.example.perfilusuario_one_to_one.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.AssertionsKt.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

	@Mock
	private RepoBBDD repoBBDD;

	@InjectMocks
	private UsuarioService usuarioService;

	@Test
	void crearUsuario_deberiaRetornarUsuarioResponse() {
		// Arrange
		UsuarioRequest request = new UsuarioRequest();
		request.setNombre("Juan");
		request.setEmail("juan@correo.com");

		Usuario usuarioGuardado = new Usuario();
		usuarioGuardado.setId(1);
		usuarioGuardado.setNombre("Juan");
		usuarioGuardado.setEmail("juan@correo.com");

		when(repoBBDD.save(any(Usuario.class))).thenReturn(usuarioGuardado);

		// Act
		UsuarioResponse response = usuarioService.crearUsuario(request);

		// Assert
		assertNotNull(response);
		assertEquals(1, response.getId());
		assertEquals("Juan", response.getNombre());
		assertEquals("juan@correo.com", response.getEmail());
	}
}
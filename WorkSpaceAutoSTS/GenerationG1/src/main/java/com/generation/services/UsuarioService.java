package com.generation.services;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Usuario;
import com.generation.repositories.UsuarioRepository;

import java.util.List;

/** Logica de negocio, o validaciones del sistema */

@Service
public class UsuarioService {
	/* llamar al Repository (inyeccion de dependencia) */
	@Autowired
	UsuarioRepository usuarioRepository;

	public boolean saveUsuario(Usuario usuario) {
		boolean error = true;
		// validaciones de insercion(crear o registrar usuario)
		/* 1.- Validar si email existe en la base de datos */
		Usuario existeUsuario = usuarioRepository.findByEmail(usuario.getEmail());

		// si no existe el usuario, lo creamos
		if (existeUsuario == null) {
			/* 2.- Encriptar el password */
			// pass : 123123 -> asdlknfioas
			String passEncriptado = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
			usuario.setPassword(passEncriptado);

			usuarioRepository.save(usuario);
			error = false;
		} else {
			// si existe, retornamos un boolean true
			error = true;
		}
		return error;
	}

	// obteniendo lista de usuarios
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();

	}

	public boolean validarUsuario(String email, String password) {
		boolean error = true;
		Usuario existeUsuario = usuarioRepository.findByEmail(email);
		if (existeUsuario == null) { // no existe el usuario, error de ingreso
			error = true;
		} 
		else {
			//Verificar password contra password base dtos desencriptada
			if(BCrypt.checkpw(password, existeUsuario.getPassword())){
				//Password iguales, email tambien a la base de datos
				error=false;
			}else{
				//password distintos
				error=true;
			}
		}
		return error;
	}

}

package com.generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByEmail(String email); //JpaRepository<Objeto,Tipo_dato_PK>
	/** las interface solo definen los metodos*/
	/** Querys y usar metodo que se conectan a la base de datos*/
}

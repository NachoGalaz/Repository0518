package com.generation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.generation.models.Auto;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{
//Trabajar con JPQL

//Usamos el objeto
    @Query(value="SELECT a FROM Auto a WHERE a.marca = ?1") //Adentro se puede escribir la query
    //Se pueden hacer dos tiops de consulta
    // ?1 hace referencia al primer parametro, de haber mas de uno tendria q ser ?2 y ?3
    List<Auto> findAllAutoMarca(String marca);
    
    //Query comun vamos 
    @Query(value="SELECT * FROM autos a WHERE a.marca = ?1",nativeQuery = true)
    List<Auto> buscarMarca(String marca);

/** 
    Filtro por algunas columnas de la tabla
    @Query(value="SELECT a.marca, a.color FROM autos a WHERE a.marca = ?1 and a.color=?2",nativeQuery = true)
	List<Object[]> buscarMarcaColor(String marca, String color);
    es demasiado generica y no nos permite traer el objeto, solo dato especifico
    
    JOIN
    @Query("SELECT a FROM Auto a JOIN a.comprasVentas cv") Aca traeria todo lo relacionado
    List<Auto> buscarAutosVendidos
    */

}

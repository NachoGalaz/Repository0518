package com.generation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.models.Licencia;

@Repository
public interface LicenciaRepository extends JpaRepository<Licencia, Long>{
    
}

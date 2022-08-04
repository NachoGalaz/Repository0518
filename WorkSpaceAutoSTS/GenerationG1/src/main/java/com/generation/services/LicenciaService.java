package com.generation.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.models.Licencia;
import com.generation.repositories.LicenciaRepository;



@Service
public class LicenciaService {

    @Autowired
	LicenciaRepository licenciaRepository;

    //almacenar en base datos la licencia
    public void save(@Valid Licencia licencia) {
//llamando al guardar del repositorio
        licenciaRepository.save(licencia);
    }

    public List<Licencia> findAll() {
        return licenciaRepository.findAll();
    }

}

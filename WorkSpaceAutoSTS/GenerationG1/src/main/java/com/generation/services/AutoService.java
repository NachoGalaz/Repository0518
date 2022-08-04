package com.generation.services;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.generation.models.Auto;
import com.generation.repositories.AutoRepository;

@Service
@Transactional
public class AutoService {
	@Autowired
	AutoRepository autoRepository;

	//guardar un auto 
	public void guardarAuto(@Valid Auto auto) {
		autoRepository.save(auto);
		
	}
	/**obtener una lista de autos*/
	public List<Auto> findAll() {
		return autoRepository.findAll();
	}
	
	public Auto buscarId(Long id) {
		return autoRepository.findById(id).get();//.get() especifica el tipo de datos que necesitamos
	}
	
	public void eliminarPorId(Long id) {
		
		autoRepository.deleteById(id);
	}
    public List<Auto> buscarMarca(String marca) {
        //llamadoa un metodo propio
		return autoRepository.buscarMarca(marca);
    }

	/** PAGINACION*/ 
	 // Variable estatica, q permite hacer la paginacion
	private static final int LOTE = 5; //lote = podria ser cualquier nombre Cantidad de autos a mostrar por pagina
    //Buena practica que sea en mayuscula para denotar que es estatica
	public Page <Auto> paginarAutos(int numeroPagina){
		PageRequest pageRequest = PageRequest.of(numeroPagina, LOTE,Sort.Direction.ASC,"marca");
		//no es lo mismo cantidad de datos a mostrar por pagina LOTE
		//que el numero de pagina
		//Page<Auto> autos = autoRepository.findAll(pageRequest);
		return autoRepository.findAll(pageRequest);
	}


}

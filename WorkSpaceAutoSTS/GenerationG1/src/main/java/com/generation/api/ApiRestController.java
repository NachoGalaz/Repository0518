package com.generation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.generation.models.Auto;
import com.generation.services.AutoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class ApiRestController {

	@Autowired // inyeccion de dependencia de clase
	AutoService autoService;

	// localhost:8080/api/obtener/autos
	@RequestMapping("/obtener/autos")
	public List<Auto> obtenerListaAutos() {
		List<Auto> listaAutos = autoService.findAll();
		return listaAutos;

	}

	@PostMapping(value = "/guardar/auto")
	public ResponseEntity<Auto> guardarAuto(@RequestBody Auto auto) {
		autoService.guardarAuto(auto);
		return new ResponseEntity<Auto>(auto, HttpStatus.OK);
	}

	@PostMapping(value = "/eliminar/{id}")
	public ResponseEntity<Auto> eliminarAuto(@PathVariable Long id) {
		try {
			autoService.eliminarPorId(id);
			return new ResponseEntity<Auto>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Auto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// API (JSON)
}

package com.nebrija.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nebrija.modelo.Perro;
import com.nebrija.repositorio.PerroRepositorio;

/*
 * Esta clase de servicio interactúa con la base de datos a través del repositorio "PerroRepositorio"
 */
@Service
public class PerroService {
	
	// Inyectamos una dependencia de tipo PerroRepositorio
	@Autowired
	private PerroRepositorio perroRepositorio;
	
	// Método para obtener una lista con todos los perros guardados en la base de datos
	public List<Perro> listAll() {
		return perroRepositorio.findAll();
	}
	
	// Método para guardar un perro a la base de datos
	public void save(Perro perro) {
		perroRepositorio.save(perro);
	}
	
	// Método que nos devuelve un perro buscándolo por su ID
	public Perro get(Long id) {
		return perroRepositorio.findById(id).get();
	}
	
	// Método para eliminar un perro de la BD filtrándolo por su ID
	public void delete(Long id) {
		perroRepositorio.deleteById(id);
	}
	
	// Método para elimina todos los perros de la base de datos
	public void deleteAll() {
		perroRepositorio.deleteAll();
	}

}

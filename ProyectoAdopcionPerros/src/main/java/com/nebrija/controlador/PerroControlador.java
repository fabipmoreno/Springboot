package com.nebrija.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nebrija.modelo.Perro;
import com.nebrija.servicio.PerroService;

/*
 * La anotación @Controller se utiliza para marcar una clase como un controlador en el contexto de Spring MVC.
 * Spring reconoce esta clase como un controlador que maneja las peticiones HTTP entrantes y coordina la lógica
 * de negocios para responder a estas peticiones 
 */
@Controller
public class PerroControlador {
	
	// Indicamos a Spring que debe inyectar una dependencia de tipo PerroService automáticamente
	@Autowired
	private PerroService perroService;
	
	// La dirección de raíz nos llevará a la página de "index.html"
	@RequestMapping("/")
	public String paginaInicio(Model modelo) {
		// Creamos una lista de perros y la cargamos con todos los perros que tenemos guardados en la base de datos
		List<Perro> listaPerros = perroService.listAll();
		
		// Añadimos la lista de perros al modelo con el nombre "listaPerros" para poder acceder a ella desde el front
		modelo.addAttribute("listaPerros", listaPerros);
		
		return "index"; // Mostramos la página "index.html"
	}
	
	// Método para mostrar un formulario de creación de perros
	@RequestMapping("/nuevo")
	public String mostrarFormularioNuevoPerro(Model modelo) {
		Perro perro = new Perro(); // Creamos un objeto de tipo Perro vacío
		modelo.addAttribute("perro", perro); // Se lo pasamos al modelo
		return "nuevo_perro"; // Mostramos la página "nuevo_perro.html"
	}
	
	// Método para guardar finalmente un objeto de tipo Perro a nuestra base de datos
	@PostMapping("/guardar")
	public String guardarPerro(@ModelAttribute("perro") Perro perro) {
		perroService.save(perro); // Guardamos el perro en la base de datos
		return "redirect:/"; // Redirigmos a "index.html"
	}
	
	// Método para mostrar un formulario de edición de perros, con los datos cargados del perro con la id indicada
	@RequestMapping("/editar/{id}")
	public ModelAndView mostrarFormularioEditarPerro(@PathVariable(name = "id") Long id) {
		ModelAndView modelo = new ModelAndView("editar_perro");
		
		Perro perro = perroService.get(id); // Obtenemos el objeto de tipo Perro correspondiente al id indicado
		modelo.addObject("perro", perro); // Añadimos el objeto al modelo
		
		return modelo; // Devolvemos la página "editar_perro.html"
	}
	
	// Método para eliminar un perro con el id indicado
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(name = "id") Long id) {
		perroService.delete(id); // Se elimina el objeto Perro correspondiente
		return "redirect:/"; // Redirigimos a "index.html"
	}
	
	// Método para eliminar todos los objetos de tipo Perro de nuestra base de datos
	@RequestMapping("/eliminar-todos")
	public String eliminarTodos() {
		perroService.deleteAll(); // Borramos todos los perros
		return "redirect:/"; // Redirigimos a "index.html"
	}
	
	

}

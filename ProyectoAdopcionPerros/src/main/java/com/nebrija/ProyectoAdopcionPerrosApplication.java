package com.nebrija;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication es una anotación que simplifica la configuración inicial de una
 * aplicación Spring Boot al combinar tres anotaciones clave:
 * @Configuration (la clase es una fuente de definiciones de beans para el contexto de la aplicación)
 * @EnableAutoConfiguration (habilita la autoconfiguración de Spring Boot)
 * @ComponentScan (Escanea los componentes, configuraciones y servicios dentro del paquete actual. Busca y registra los
 * beans que se puedan inyectar en la aplicación)
 * 
 * Esto permite que la aplicación se inicie fácilmente con una configuración mínima, permitiendo a Spring Boot hacer
 * muchas de las configuraciones automáticamente.
 */
@SpringBootApplication
public class ProyectoAdopcionPerrosApplication {

	// Este es el método que se ejecuta al iniciar la aplicación
	public static void main(String[] args) {
		SpringApplication.run(ProyectoAdopcionPerrosApplication.class, args);
	}

}

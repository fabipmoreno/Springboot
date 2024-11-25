package com.nebrija.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * La anotación @Entity (en el contexto de Java Persistance Api (JPA)) es utilizada para marcar una clase
 * como una entidad persistente, lo que significa que la clase está asociada con una tabla en una 
 * base de datos relacional.
 * Esta anotación indica que la clase representa una tabla en la base de datos y que sus campos representan
 * las columnas de esta tabla.
 */
@Entity
public class Perro {
	
	/*
	 * La anotación @GeneratedValue, al ser usada junto a @Id, se utiliza para especificar cómo se
	 * generará el valor de una clave primaria en una entidad.
	 * En este caso, nuestra estrategia de generación de valores es "GenerationType.IDENTITY", lo que significa
	 * que cuando insertamos una nueva fila en la tabla correspondiente, la BD generará automáticamente un valor
	 * para la columna "id" de manera autoincremental.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Los siguientes atributos no pueden tener un valor nulo.
	// En los atributos de tipo String, la longitud máxima de la cadena es de 100 caracteres
	@Column(nullable = false, length = 100)
	private String nombre;
	
	@Column(nullable = false, length = 100)
	private String raza;
	
	@Column(nullable = false)
	private Integer edad;

	// Constructor completo
	public Perro(Long id, String nombre, String raza, Integer edad) {
		this.id = id;
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
	}

	// Constructor vacío
	public Perro() {
	}

	// Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
}

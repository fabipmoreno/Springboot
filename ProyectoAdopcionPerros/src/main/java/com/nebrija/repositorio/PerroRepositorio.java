package com.nebrija.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nebrija.modelo.Perro;

/*
 * PerroRepositorio es una interfaz en Spring Data JPA. Esta interfaz extiende "JpaRepository" y está parametrizada
 * con dos tipos: Perro y Long.
 * JpaRepository es una interfaz proporcionada por Spring Data JPA que proporciona funcionalidades CRUD básicas
 * para la entidad que se está gestionando (Perro).
 * La interfaz PerroRepositorio no tiene ningún método declarado explícitamente, pero hereda automáticamente métodos
 * CRUD de JpaRepository tales com "save", "findById", "findAll", "delete", etc., los cuales puedes utilizar directamente
 * sin necesidad de implementarlos.
 * Esta interfaz facilita en gran medida la interacción con la base de datos, ya que permite realizar operaciones comunes
 * de manera muy sencilla sin necesidad de escribir código específico para cada cnsulta o manipulación de datos.
 */
public interface PerroRepositorio extends JpaRepository<Perro, Long>{

	
}

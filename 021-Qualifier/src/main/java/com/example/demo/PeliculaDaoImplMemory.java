package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

public class PeliculaDaoImplMemory implements PeliculaDao {

	private List<Pelicula> peliculas = new ArrayList<>();
	
	//solo cargará las actuales, pues el bean es primary
	@Autowired
	@Qualifier("catalogoClasicas")
	private CatalogoPeliculas catalogoPeliculas;
	
	
	public void init() {
			peliculas.addAll(catalogoPeliculas.getPeliculas());
		
	}
	
	public Pelicula findById(int id) {
		return peliculas.get(id);
	}

	public Collection<Pelicula> findAll() {
		return peliculas;
	}

	public void insert(Pelicula pelicula) {
		peliculas.add(pelicula);
	}

	public void edit(Pelicula antigua, Pelicula nueva) {		
		peliculas.remove(antigua);
		peliculas.add(nueva);		
	}

	public void delete(Pelicula pelicula) {
		peliculas.remove(pelicula);
	}

}

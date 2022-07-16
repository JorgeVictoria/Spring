package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class PeliculaDaoImplMemory implements PeliculaDao {

	private List<Pelicula> peliculas = new ArrayList<>();
	
	//solo cargará las actuales, pues el bean es primary
	@Autowired
	private Set<CatalogoPeliculas> catalogoPeliculas;
	
	@PostConstruct
	public void init() {
		peliculas = catalogoPeliculas
				.stream()
				.map(catalogo -> catalogo.getPeliculas())
				.flatMap(lista -> lista.stream())
				.collect(Collectors.toCollection(ArrayList::new));
		
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

	@PreDestroy
	public void destroy() {
		System.out.println("Borrando almacen de peliculas");
		peliculas.clear();
	}
}

package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class PeliculaDaoImplMemory implements PeliculaDao {

	private List<Pelicula> peliculas = new ArrayList<>();
	
	//-------------no es requerido, con lo cual aunque no esten los beans, funciona-----------------------------------------------
//	@Autowired(required=false)
//	private Set<CatalogoPeliculas> catalogosPeliculas;
	//----------------------------------------------------------------------------------------------------------------------------
	
	//-------------con nullable avisamos que ese catalgo puede ser nulo, por no existir el bean-----------------------------------
//	private Set<CatalogoPeliculas> catalogosPeliculas;
//	
//	@Autowired
//	public PeliculaDaoImplMemory(@Nullable Set<CatalogoPeliculas> catalogosPeliculas) {
//		this.catalogosPeliculas = catalogosPeliculas;
//	}
	//----------------------------------------------------------------------------------------------------------------------------

	//-------------con la clase optional avisamos que puede no existir el bean----------------------------------------------------
	private Set<CatalogoPeliculas> catalogosPeliculas;
	
	@Autowired
	public void setCatalogosPeliculas(Optional<Set<CatalogoPeliculas>> catalogosPeliculas) {
		this.catalogosPeliculas = catalogosPeliculas.orElse(null);
	}
	//----------------------------------------------------------------------------------------------------------------------------
	
	public void init() {
		if (catalogosPeliculas != null)
			for (CatalogoPeliculas c : catalogosPeliculas) {
				peliculas.addAll(c.getPeliculas());
			}
	}

	public PeliculaDaoImplMemory() { }
	
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

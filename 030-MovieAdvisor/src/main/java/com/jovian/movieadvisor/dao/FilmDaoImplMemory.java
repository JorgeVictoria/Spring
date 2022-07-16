package com.jovian.movieadvisor.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jovian.movieadvisor.config.AppConfig;
import com.jovian.movieadvisor.model.Film;

@Repository
public class FilmDaoImplMemory implements FilmDao {
	
	public List<Film> peliculas = new ArrayList<>();
	
	@Autowired
	private AppConfig appConfig;

	
	public Film findById(long id) {
		
		// @formatter:off
		Optional<Film> result = 
				peliculas
				.stream()
				.filter(f -> f.getId() == id)
				.findFirst();
		return result.orElse(null);
		// @formatter:on
	}

	
	public Collection<Film> findAll() {
		return peliculas;
	}

	
	public void insert(Film film) {
		peliculas.add(film);

	}

	
	public void edit(Film film) {
		
		int index = getIndex(film.getId());
		if(index != -1) peliculas.set(index, film);

	}

	
	public void delete(long id) {
		
		int index = getIndex(id);
		if(index != -1) peliculas.remove(index);

	}
	
	private int getIndex(long id) {
		
		boolean encontrado = false;
		int index = 0;
		
		while(!encontrado && index < peliculas.size()) {
			if (peliculas.get(index).getId() == id) encontrado = true;
			else index++;
		}
		
		return (encontrado) ? index : -1;
	}
	
	@PostConstruct
	public void init() {
		peliculas = UtilFilFieReader.readFile(appConfig.getFile(), appConfig.getSeparator(), appConfig.getListSeparator());
	}

}

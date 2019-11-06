package com.dev.colalbum_be.service;

import java.util.List;

import com.dev.colalbum_be.entity.Artista;

public interface ArtistaService {

	List<Artista> listAllArtista();

	Artista insert(Artista artista);

	Artista update(Artista artista);

	void delete(Artista artista);
}

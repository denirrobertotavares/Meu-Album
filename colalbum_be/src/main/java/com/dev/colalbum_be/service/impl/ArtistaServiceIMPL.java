package com.dev.colalbum_be.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.colalbum_be.entity.Artista;
import com.dev.colalbum_be.repository.ArtistaRepository;
import com.dev.colalbum_be.service.ArtistaService;

@Service
public class ArtistaServiceIMPL implements ArtistaService {

	@Autowired
	private ArtistaRepository artistaRepository;

	@Override
	public List<Artista> listAllArtista() {
		return artistaRepository.listAllArtista();
	}

	@Transactional
	@Override
	public Artista insert(Artista artista) {
		return artistaRepository.save(artista);
	}

	@Transactional
	@Override
	public Artista update(Artista artista) {
		return artistaRepository.save(artista);
	}

	@Transactional
	@Override
	public void delete(Artista artista) {
		artistaRepository.delete(artista);
	}

}

package com.dev.colalbum_be.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.colalbum_be.entity.Album;
import com.dev.colalbum_be.repository.AlbumRepository;
import com.dev.colalbum_be.service.AlbumService;

@Service
public class AlbumServiceIMPL implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	@Override
	public List<Album> listAllAlbum() {
		return albumRepository.listAllAlbum();
	}

	@Transactional
	@Override
	public Album insert(Album album) {
		return albumRepository.save(album);
	}

	@Transactional
	@Override
	public Album update(Album album) {
		return albumRepository.save(album);
	}

	@Transactional
	@Override
	public void delete(Album album) {
		albumRepository.delete(album);
	}

}

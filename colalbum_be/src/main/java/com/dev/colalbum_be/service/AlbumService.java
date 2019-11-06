package com.dev.colalbum_be.service;

import java.util.List;

import com.dev.colalbum_be.entity.Album;

public interface AlbumService {

	List<Album> listAllAlbum();

	Album insert(Album album);

	Album update(Album album);

	void delete(Album album);
}

package com.dev.colalbum_be.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.colalbum_be.entity.Album;
import com.dev.colalbum_be.service.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@RequestMapping(method = RequestMethod.GET, value = "/listAllAlbum", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Album>> listAllAlbum() {
		List<Album> album = albumService.listAllAlbum();
		return ResponseEntity.ok().body(album);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/insertAlbum", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Album> insertAlbum(@RequestBody Album album) {
		Album albumr = albumService.insert(album);
		return ResponseEntity.ok().body(albumr);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateAlbum", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Album> updateAlbum(@RequestBody Album album) {
		Album albumr = albumService.update(album);
		return ResponseEntity.ok().body(albumr);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAlbum", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteAlbum(@RequestBody Album album) {
		albumService.delete(album);
		return ResponseEntity.ok().body("Album removido com sucesso.");
	}

}

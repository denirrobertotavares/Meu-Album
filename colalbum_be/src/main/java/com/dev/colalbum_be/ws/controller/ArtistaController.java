package com.dev.colalbum_be.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.colalbum_be.entity.Artista;
import com.dev.colalbum_be.service.ArtistaService;

@RestController
@RequestMapping("/artista")
public class ArtistaController {

	@Autowired
	private ArtistaService artistaService;

	@RequestMapping(method = RequestMethod.GET, value = "/listAllArtista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Artista>> listAllArtista() {
		List<Artista> artista = artistaService.listAllArtista();
		return ResponseEntity.ok().body(artista);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/insertArtista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> insertArtista(@RequestBody Artista artista) {
		Artista artistar = artistaService.insert(artista);
		return ResponseEntity.ok().body(artistar);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateArtista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> updateArtista(@RequestBody Artista artista) {
		Artista artistar = artistaService.update(artista);
		return ResponseEntity.ok().body(artistar);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteArtista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteArtista(@RequestBody Artista artista) {
		artistaService.delete(artista);
		return ResponseEntity.ok().body("Artista removido com sucesso.");
	}

}

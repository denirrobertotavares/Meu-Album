package com.dev.colalbum_be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.colalbum_be.entity.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

	@Transactional(readOnly = true)
	@Query(value = "SELECT a FROM Artista a", nativeQuery = false)
	List<Artista> listAllArtista();
}

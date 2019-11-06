package com.dev.colalbum_be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dev.colalbum_be.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

	@Transactional(readOnly = true)
	@Query(value = "SELECT a FROM Album a", nativeQuery = false)
	List<Album> listAllAlbum();
}

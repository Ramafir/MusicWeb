package pl.danielkolban.musicweb.album;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album findAlbumById(Long id);

    void delete(Album album);

    Optional<Album> findByNameIgnoreCase(String replaceAll);
}

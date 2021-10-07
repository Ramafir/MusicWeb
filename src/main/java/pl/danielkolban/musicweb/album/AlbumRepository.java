package pl.danielkolban.musicweb.album;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    Album findAlbumById(Long id);

    void delete(Album album);

    Optional<Album> findByNameIgnoreCase(String replaceAll);

    @Query(value = "select a from Album a where a.name like %:keyword% or a.artist.nickname like %:keyword%")
    List<Album> findAll(@Param("keyword") String keyword);

}

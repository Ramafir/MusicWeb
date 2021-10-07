package pl.danielkolban.musicweb.artist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    public Artist findArtistById(Long id);

    void deleteArtistById(Long id);

    Optional<Artist> findByNicknameIgnoreCase(String replaceAll);
}

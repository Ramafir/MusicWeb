package pl.danielkolban.musicweb.album;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> listAll(String keyword) {
        if (keyword != null) {
            return albumRepository.findAll(keyword);
        } else {
            return albumRepository.findAll();
        }

    }
}

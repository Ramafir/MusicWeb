package pl.danielkolban.musicweb.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.danielkolban.musicweb.album.Album;
import pl.danielkolban.musicweb.album.AlbumRepository;
import pl.danielkolban.musicweb.artist.Artist;
import pl.danielkolban.musicweb.artist.ArtistRepository;

import java.util.List;

@Controller
public class HomeController {

    private AlbumRepository albumRepository;
    private ArtistRepository artistRepository;

    public HomeController(AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Album> albums = albumRepository.findAll();
        List<Artist> artists = artistRepository.findAll();
        model.addAttribute("albums", albums);
        model.addAttribute("artists", artists);
        return "main/index";

    }
}

package pl.danielkolban.musicweb.home;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.danielkolban.musicweb.album.Album;
import pl.danielkolban.musicweb.album.AlbumService;
import pl.danielkolban.musicweb.artist.Artist;
import pl.danielkolban.musicweb.artist.ArtistRepository;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private final AlbumService albumService;
    private final ArtistRepository artistRepository;


    @GetMapping("/")
    public String displayHome(Model model, @Param("keyword") String keyword) {
        List<Album> albums = albumService.listAll(keyword);
        List<Artist> artists = artistRepository.findAll();
        model.addAttribute("albums", albums);
        model.addAttribute("keyword", keyword);
        model.addAttribute("artists", artists);
        return "main/index";

    }

}

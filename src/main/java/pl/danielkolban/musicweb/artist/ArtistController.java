package pl.danielkolban.musicweb.artist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.danielkolban.musicweb.album.Album;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    private ArtistRepository artistRepository;

    public ArtistController(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }



    @GetMapping
    public String displayArtists(Model model) {

        List<Artist> artists = artistRepository.findAll();
        model.addAttribute("artists", artists);
        return "/artists/list-artists";

    }

    @GetMapping("/new")
    public String displayArtistForm(Model model) {
        Artist artist = new Artist();
        model.addAttribute("artist", artist);
        return "artists/new-artist";

    }

    @PostMapping("/save")
    public String createArtist(Artist artist, Model model) {
        artistRepository.save(artist);
        return "redirect:/artists";

    }

    @GetMapping("/update")
    public String displayArtistUpdateForm(@RequestParam("id") long theId, Model model) {
        Artist theArtist = artistRepository.findArtistById(theId);
        model.addAttribute("artist", theArtist);
        return "artists/new-artist";
    }

    @GetMapping("/delete")
    public String deleteArtist(@RequestParam("id") long theId, Model model) {
        Artist artist = artistRepository.findArtistById(theId);
        artistRepository.delete(artist);
        return "redirect:/artists";
    }

    @GetMapping("/{name}")
    public String getArtist(@PathVariable String name, Model model) {
        Optional<Artist> artist = artistRepository.findByNicknameIgnoreCase(name.replaceAll("-", " "));
        artist.ifPresent(art -> model.addAttribute("artist", art));
        return "artists/artist";
    }

}
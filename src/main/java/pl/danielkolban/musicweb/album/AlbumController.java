package pl.danielkolban.musicweb.album;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.danielkolban.musicweb.artist.Artist;
import pl.danielkolban.musicweb.artist.ArtistRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;

    public AlbumController(AlbumRepository albumRepository, ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
    }

    @GetMapping
    public String displayAlbums(Model model) {

        List<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "/albums/list-albums";

    }

    @GetMapping("/new")
    public String displayAlbumForm(Model model) {
        Album album = new Album();
        List<Artist> artists = artistRepository.findAll();
        model.addAttribute("artist", artists);
        model.addAttribute("album", album);
        return "albums/new-album";


    }

    @PostMapping("/save")
    public String createAlbum(Album album, Model model) {
        albumRepository.save(album);
        return "redirect:/albums";

    }

    @GetMapping("/update")
    public String displayAlbumUpdateForm(@RequestParam("id") long theId, Model model) {
        Album theAlbum = albumRepository.findAlbumById(theId);
        model.addAttribute("album", theAlbum);
        return "albums/new-album";
    }

    @GetMapping("/delete")
    public String deleteAlbum(@RequestParam("id") long theId, Model model) {
        Album album = albumRepository.findAlbumById(theId);
        albumRepository.delete(album);
        return "redirect:/albums";
    }

    @GetMapping("/{name}")
    public String getAlbum(@PathVariable String name, Model model) {
        Optional<Album> album = albumRepository.findByNameIgnoreCase(name.replaceAll("-", " "));
        album.ifPresent(alb -> model.addAttribute("album", alb));
        return "albums/album";
    }


}

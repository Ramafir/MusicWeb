package pl.danielkolban.musicweb.album;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.danielkolban.musicweb.artist.Artist;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;
    @NotBlank
    @Size(min = 2, max = 1000)
    private String shortDescription;
    @NotNull
    private AlbumGenre genre;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @NotBlank
    private String imgUrl;

    public Album(String name, String shortDescription, AlbumGenre genre, Artist artist, String imgUrl) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.genre = genre;
        this.artist = artist;
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return name;
    }
}



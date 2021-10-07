package pl.danielkolban.musicweb.album;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.danielkolban.musicweb.artist.Artist;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String shortDescription;
    private AlbumGenre genre;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;
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



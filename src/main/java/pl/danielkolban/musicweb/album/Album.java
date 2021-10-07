package pl.danielkolban.musicweb.album;

import pl.danielkolban.musicweb.artist.Artist;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String shortDescription;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
    fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;
    private String imgUrl;

    public Album(String name, String shortDescription, Artist artist, String imgUrl) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.artist = artist;
        this.imgUrl = imgUrl;
    }

    public Album() {

    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) && Objects.equals(name, album.name) && Objects.equals(shortDescription, album.shortDescription) && Objects.equals(artist, album.artist) && Objects.equals(imgUrl, album.imgUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortDescription, artist, imgUrl);
    }

    @Override
    public String toString() {
        return name;
    }
}



package pl.danielkolban.musicweb.artist;

import pl.danielkolban.musicweb.album.Album;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;
    @Size(min = 2, max = 50)
    private String nickname;
    @OneToMany(mappedBy = "artist")
    private List<Album> albums;
    @NotBlank
    private String imgUrl;
    @NotBlank
    @Size(min = 2, max = 1000)
    private String bio;

    public Artist(String firstName, String lastName, String nickname, List<Album> albums, String imgUrl, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.albums = albums;
        this.imgUrl = imgUrl;
        this.bio = bio;
    }

    public Artist() {

    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return Objects.equals(id, artist.id) && Objects.equals(firstName, artist.firstName) && Objects.equals(lastName, artist.lastName) && Objects.equals(nickname, artist.nickname) && Objects.equals(albums, artist.albums) && Objects.equals(imgUrl, artist.imgUrl) && Objects.equals(bio, artist.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, nickname, albums, imgUrl, bio);
    }

    @Override
    public String toString() {
        return Objects.requireNonNullElseGet(nickname, () -> firstName + " " + lastName);

    }
}

package entities;

import java.util.Objects;

public class Album extends Collectible {
    private String albumTitle;
    private String artist;

    public Album(String albumTitle, String artist) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        super.setOwnerId(null);
        super.setId(Collectible.getNewId());
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("Album title: ");
        builder.append(this.albumTitle);
        builder.append("; Artist: ");
        builder.append(this.artist);
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Album) {
            Album a = (Album) obj;
            return super.equals(obj) && Objects.equals(this.artist, a.artist) && Objects.equals(this.albumTitle, a.albumTitle);
        } else {
            return false;
        }
    }
}

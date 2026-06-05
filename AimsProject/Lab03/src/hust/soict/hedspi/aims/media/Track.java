package hust.soict.hedspi.aims.media;

import java.util.Objects;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable {
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() throws PlayerException {
        if (length <= 0) {
            System.err.println("ERROR: Track length is non-positive");
            throw new PlayerException("Track length is non-positive");
        }
        System.out.println("Playing track: " + title);
        System.out.println("Track length: " + length);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Track other)) {
            return false;
        }
        return length == other.length && Objects.equals(title, other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length);
    }
}

package hust.soict.hedspi.aims.media;

import java.util.Objects;

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
    public void play() {
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

package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private final List<Track> tracks;

    public CompactDisc() {
        super();
        this.tracks = new ArrayList<>();
    }

    public CompactDisc(String title, String category, String artist, String director, float cost) {
        super(title, category, cost, director, 0);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (track == null) {
            System.out.println("Cannot add null track");
            return;
        }
        if (tracks.contains(track)) {
            System.out.println("Track already exists: " + track.getTitle());
            return;
        }
        tracks.add(track);
        System.out.println("Track added: " + track.getTitle());
    }

    public void removeTrack(Track track) {
        if (track == null) {
            System.out.println("Cannot remove null track");
            return;
        }
        if (!tracks.contains(track)) {
            System.out.println("Track not found: " + track.getTitle());
            return;
        }
        tracks.remove(track);
        System.out.println("Track removed: " + track.getTitle());
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("CD length: " + getLength());
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": "
                + getCost() + " $";
    }
}

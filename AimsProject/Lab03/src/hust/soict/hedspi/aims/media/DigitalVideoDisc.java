package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(String title) {
        super(title, null, 0f, null, 0);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost, null, 0);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, director, length);
    }

    public boolean isMatch(String title) {
        return getTitle() != null && title != null && getTitle().toLowerCase().contains(title.toLowerCase());
    }

    @Override
    public void play() throws PlayerException {
        if (getLength() <= 0) {
            System.err.println("ERROR: DVD length is non-positive");
            throw new PlayerException("DVD length is non-positive");
        }
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": "
                + getCost() + " $";
    }
}

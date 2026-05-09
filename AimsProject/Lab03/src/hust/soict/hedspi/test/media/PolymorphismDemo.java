package hust.soict.hedspi.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class PolymorphismDemo {
    public static void main(String[] args) {
        List<Media> mediaList = new ArrayList<>();
        mediaList.add(new CompactDisc("Love of My Life", "Pop", "Carly Simon", "Carly Simon", 15f));
        mediaList.add(new DigitalVideoDisc("The Matrix", "Science Fiction", "The Wachowski Brothers", 136, 7f));
        mediaList.add(new Book("The Catcher in the Rye", "Novel", 4f));

        for (Media media : mediaList) {
            System.out.println(media);
        }
    }
}

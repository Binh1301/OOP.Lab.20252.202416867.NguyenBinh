package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int titleComparison = Comparator.nullsLast(String::compareTo).compare(media1.getTitle(), media2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Float.compare(media2.getCost(), media1.getCost());
    }
}

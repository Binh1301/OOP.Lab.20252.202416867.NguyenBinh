package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private final ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add null media");
            return;
        }
        if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {
            System.out.println("The store is full");
            return;
        }
        itemsInStore.add(media);
        System.out.println("The media has been added to the store");
    }

    public void removeMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot remove null media");
            return;
        }
        if (itemsInStore.remove(media)) {
            System.out.println("The media has been removed from the store");
            return;
        }
        System.out.println("The media was not found in the store");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        addMedia(dvd);
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        removeMedia(dvd);
    }
}

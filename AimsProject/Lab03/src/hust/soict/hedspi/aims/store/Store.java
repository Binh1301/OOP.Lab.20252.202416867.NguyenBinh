package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private final List<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Cannot add null media");
            return;
        }

        if (itemsInStore.contains(media)) {
            System.out.println("The media already exists in the store");
            return;
        }

        if (itemsInStore.size() >= MAX_ITEMS_IN_STORE) {
            System.out.println("The store is full");
            return;
        }

        itemsInStore.add(media);
        System.out.println("The media has been added to the store");
    }

    public void addDVD(DigitalVideoDisc dvd) {
        addMedia(dvd);
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

    public void removeDVD(DigitalVideoDisc dvd) {
        removeMedia(dvd);
    }

    public Media findByTitle(String title) {
        if (title == null) {
            return null;
        }
        for (Media media : itemsInStore) {
            if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title.trim())) {
                return media;
            }
        }
        return null;
    }

    public List<Media> getItemsInStore() {
        return new ArrayList<>(itemsInStore);
    }

    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i));
        }
        System.out.println("***************************************************");
    }
}

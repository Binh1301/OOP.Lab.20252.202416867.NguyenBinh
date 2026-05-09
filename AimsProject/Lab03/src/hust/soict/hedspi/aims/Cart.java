package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;

    private final List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("The media is null");
            return;
        }
        if (itemsOrdered.contains(media)) {
            System.out.println("The media already exists in the cart");
            return;
        }
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("The media has been added");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        addMedia(dvd);
    }

    public void removeMedia(Media media) {
        if (media == null) {
            System.out.println("The media is null");
            return;
        }

        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media was not found");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        removeMedia(dvd);
    }

    public Media findByTitle(String title) {
        if (title == null) {
            return null;
        }
        for (Media media : itemsOrdered) {
            if (media.getTitle() != null && media.getTitle().equalsIgnoreCase(title.trim())) {
                return media;
            }
        }
        return null;
    }

    public List<Media> getItemsOrdered() {
        return new ArrayList<>(itemsOrdered);
    }

    public void clear() {
        itemsOrdered.clear();
    }

    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i));
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media);
                found = true;
            }
        }
        if (found) {
            return;
        }
        System.out.println("No media found with id: " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            String mediaTitle = media.getTitle();
            if (mediaTitle != null && title != null && mediaTitle.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(media);
                found = true;
            }
        }
        if (found) {
            return;
        }
        System.out.println("No media found with title: " + title);
    }

    public void playByTitle(String title) {
        Media media = findByTitle(title);
        if (media == null) {
            System.out.println("No media found with title: " + title);
            return;
        }
        if (media instanceof Playable playable) {
            playable.play();
            return;
        }
        System.out.println("The selected media cannot be played");
    }
}

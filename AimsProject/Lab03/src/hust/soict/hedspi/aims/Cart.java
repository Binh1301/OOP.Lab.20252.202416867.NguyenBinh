package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
    private final List<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("The media is null");
            return;
        }
        itemsOrdered.add(media);
        System.out.println("The media has been added");
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
}

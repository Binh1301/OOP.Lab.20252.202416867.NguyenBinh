package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Interstellar", "Sci-fi", "Christopher Nolan", 148, 10.5f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-fi", "Christopher Nolan", 148, 12.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Titanic", "Romance", "James Cameron", 195, 8.0f);

        System.out.println("=== Add DVDs ===");
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        System.out.println("\n=== Remove Existing DVD ===");
        store.removeDVD(dvd2);

        System.out.println("\n=== Remove Non-existing DVD ===");
        store.removeDVD(dvd2);
    }
}

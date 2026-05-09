package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.DigitalVideoDisc;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private final DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];

    public void addDVD(DigitalVideoDisc dvd) {
        if (dvd == null) {
            System.out.println("Cannot add null DVD");
            return;
        }

        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == null) {
                itemsInStore[i] = dvd;
                System.out.println("The DVD has been added to the store");
                return;
            }
        }

        System.out.println("The store is full");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (dvd == null) {
            System.out.println("Cannot remove null DVD");
            return;
        }

        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == dvd) {
                itemsInStore[i] = null;
                System.out.println("The DVD has been removed from the store");
                return;
            }
        }

        System.out.println("The DVD was not found in the store");
    }
}

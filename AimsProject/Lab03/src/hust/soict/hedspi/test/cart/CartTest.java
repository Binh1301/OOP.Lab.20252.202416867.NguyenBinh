package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Interstellar", "Sci-fi", "Nolan", 148, 10.5f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Inception", "Sci-fi", "Nolan", 148, 12.0f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Titanic", "Romance", "Cameron", 195, 8.0f);
        cart.addDigitalVideoDisc(dvd3);

        System.out.println("\nPrint cart:");
        cart.printCart();

        System.out.println("\nSearch ID = 2:");
        cart.searchById(2);

        System.out.println("\nSearch ID = 99:");
        cart.searchById(99);

        System.out.println("\nSearch title 'Titanic':");
        cart.searchByTitle("Titanic");

        System.out.println("\nSearch title 'Avatar':");
        cart.searchByTitle("Avatar");
    }
}

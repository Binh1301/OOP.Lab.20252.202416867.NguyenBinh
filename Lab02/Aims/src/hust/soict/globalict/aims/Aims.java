package hust.soict.globalict.aims;

import hust.soict.globalict.Cart;

public class Aims {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1.setCost(19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2.setCost(24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
        dvd3.setCost(18.99f);

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        cart.printCart();

        cart.removeDigitalVideoDisc(dvd2);
        System.out.println("\nAfter removing:");
        cart.printCart();
    }
}

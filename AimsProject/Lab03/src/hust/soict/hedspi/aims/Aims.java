package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    private final Store store = new Store();
    private final Cart cart = new Cart();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Aims().run();
    }

    private void run() {
        seedStore();

        while (true) {
            showMenu();
            String choice = readLine();
            if ("0".equals(choice)) {
                break;
            }
            switch (choice) {
                case "1" -> handleViewStore();
                case "2" -> handleUpdateStore();
                case "3" -> handleCurrentCart();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private void handleViewStore() {
        while (true) {
            store.printStore();
            storeMenu();
            String choice = readLine();
            if ("0".equals(choice)) {
                return;
            }
            switch (choice) {
                case "1" -> handleSeeMediaDetailsFromStore();
                case "2" -> handleAddMediaToCartFromStore();
                case "3" -> handlePlayMediaFromStore();
                case "4" -> handleCurrentCart();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void handleUpdateStore() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            String choice = readLine();
            if ("0".equals(choice)) {
                return;
            }
            switch (choice) {
                case "1" -> addMediaToStore();
                case "2" -> removeMediaFromStore();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void handleCurrentCart() {
        while (true) {
            cart.printCart();
            cartMenu();
            String choice = readLine();
            if ("0".equals(choice)) {
                return;
            }
            switch (choice) {
                case "1" -> filterCart();
                case "2" -> sortCart();
                case "3" -> removeMediaFromCart();
                case "4" -> playMediaFromCart();
                case "5" -> placeOrder();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void handleSeeMediaDetailsFromStore() {
        System.out.print("Enter media title: ");
        Media media = store.findByTitle(readLine());
        if (media == null) {
            System.out.println("Media not found in store");
            return;
        }

        System.out.println(media);
        while (true) {
            mediaDetailsMenu();
            String choice = readLine();
            if ("0".equals(choice)) {
                return;
            }
            switch (choice) {
                case "1" -> cart.addMedia(media);
                case "2" -> playMedia(media);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void handleAddMediaToCartFromStore() {
        System.out.print("Enter media title: ");
        Media media = store.findByTitle(readLine());
        if (media == null) {
            System.out.println("Media not found in store");
            return;
        }
        cart.addMedia(media);
        if (media instanceof DigitalVideoDisc) {
            long dvdCount = cart.getItemsOrdered().stream().filter(DigitalVideoDisc.class::isInstance).count();
            System.out.println("Current number of DVDs in cart: " + dvdCount);
        }
    }

    private void handlePlayMediaFromStore() {
        System.out.print("Enter media title: ");
        Media media = store.findByTitle(readLine());
        if (media == null) {
            System.out.println("Media not found in store");
            return;
        }
        playMedia(media);
    }

    private void filterCart() {
        System.out.println("Filter by: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        String choice = readLine();
        switch (choice) {
            case "1" -> {
                System.out.print("Enter id: ");
                try {
                    cart.searchById(Integer.parseInt(readLine()));
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid id");
                }
            }
            case "2" -> {
                System.out.print("Enter title: ");
                cart.searchByTitle(readLine());
            }
            default -> System.out.println("Invalid choice");
        }
    }

    private void sortCart() {
        System.out.println("Sort by: ");
        System.out.println("1. Title then cost");
        System.out.println("2. Cost then title");
        String choice = readLine();
        switch (choice) {
            case "1" -> cart.sortByTitle();
            case "2" -> cart.sortByCost();
            default -> {
                System.out.println("Invalid choice");
                return;
            }
        }
        cart.printCart();
    }

    private void removeMediaFromCart() {
        System.out.print("Enter media title: ");
        Media media = cart.findByTitle(readLine());
        if (media == null) {
            System.out.println("Media not found in cart");
            return;
        }
        cart.removeMedia(media);
    }

    private void playMediaFromCart() {
        System.out.print("Enter media title: ");
        cart.playByTitle(readLine());
    }

    private void placeOrder() {
        System.out.println("Order created");
        cart.clear();
    }

    private void addMediaToStore() {
        System.out.println("Choose media type:");
        System.out.println("1. DVD");
        System.out.println("2. CD");
        System.out.println("3. Book");
        String choice = readLine();

        System.out.print("Title: ");
        String title = readLine();
        System.out.print("Category: ");
        String category = readLine();
        System.out.print("Cost: ");
        float cost = readFloat();

        Media media;
        switch (choice) {
            case "1" -> {
                System.out.print("Director: ");
                String director = readLine();
                System.out.print("Length: ");
                int length = readInt();
                media = new DigitalVideoDisc(title, category, director, length, cost);
            }
            case "2" -> {
                System.out.print("Artist: ");
                String artist = readLine();
                System.out.print("Director: ");
                String director = readLine();
                media = new CompactDisc(title, category, artist, director, cost);
            }
            case "3" -> media = new Book(title, category, cost);
            default -> {
                System.out.println("Invalid media type");
                return;
            }
        }

        store.addMedia(media);
    }

    private void removeMediaFromStore() {
        System.out.print("Enter media title: ");
        Media media = store.findByTitle(readLine());
        if (media == null) {
            System.out.println("Media not found in store");
            return;
        }
        store.removeMedia(media);
    }

    private void playMedia(Media media) {
        if (media instanceof Playable playable) {
            playable.play();
            return;
        }
        System.out.println("The selected media cannot be played");
    }

    private void seedStore() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
        store.addMedia(new CompactDisc("Love of My Life", "Pop", "Carly Simon", "Carly Simon", 15f));
        store.addMedia(new Book("The Catcher in the Rye", "Novel", 18.99f));
    }

    private String readLine() {
        return scanner.nextLine().trim();
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(readLine());
            } catch (NumberFormatException ex) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }

    private float readFloat() {
        while (true) {
            try {
                return Float.parseFloat(readLine());
            } catch (NumberFormatException ex) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}

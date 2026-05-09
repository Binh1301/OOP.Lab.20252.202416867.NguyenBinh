package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private final List<String> authors;

    public Book() {
        super();
        this.authors = new ArrayList<>();
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
        this.authors = new ArrayList<>();
    }

    public void addAuthor(String authorName) {
        if (authorName == null || authorName.isBlank()) {
            System.out.println("Invalid author name");
            return;
        }

        if (authors.contains(authorName)) {
            System.out.println("Author already exists: " + authorName);
            return;
        }

        authors.add(authorName);
        System.out.println("Author added: " + authorName);
    }

    public void removeAuthor(String authorName) {
        if (authorName == null || authorName.isBlank()) {
            System.out.println("Invalid author name");
            return;
        }

        if (!authors.contains(authorName)) {
            System.out.println("Author not found: " + authorName);
            return;
        }

        authors.remove(authorName);
        System.out.println("Author removed: " + authorName);
    }

    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + ": " + getCost() + " $";
    }
}

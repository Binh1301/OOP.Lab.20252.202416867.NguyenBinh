package hust.soict.hedspi.aims.media;

import java.util.Objects;

public abstract class Media implements Comparable<Media> {
    private static int nextId = 1;

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        this.id = nextId++;
    }

    public Media(String title, String category, float cost) {
        this();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        if (id >= nextId) {
            nextId = id + 1;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Media other)) {
            return false;
        }
        return Objects.equals(title, other.title) && Float.compare(cost, other.cost) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cost);
    }

    @Override
    public int compareTo(Media other) {
        if (other == null) {
            throw new NullPointerException("Cannot compare to null Media");
        }
        String thisTitle = title == null ? "" : title;
        String otherTitle = other.title == null ? "" : other.title;
        int titleCompare = thisTitle.compareTo(otherTitle);
        if (titleCompare != 0) {
            return titleCompare;
        }
        return Float.compare(cost, other.cost);
    }
}

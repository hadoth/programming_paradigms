package entities;

import java.util.Objects;

public class Book extends Collectible {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        super.setOwnerId(null);
        super.setId(Collectible.getNewId());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append("Title: ");
        builder.append(this.title);
        builder.append("; Author: ");
        builder.append(this.author);
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book b = (Book) obj;
            return super.equals(obj) && Objects.equals(this.author, b.author) && Objects.equals(this.title, b.title);
        } else {
            return false;
        }
    }
}

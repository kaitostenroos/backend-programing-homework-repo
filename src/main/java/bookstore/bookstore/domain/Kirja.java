package bookstore.bookstore.domain;

import jakarta.persistence.Entity;

@Entity
public class Kirja {
    private String title;
    private String author;
    private int year;
    private String isbn;
    private double price;

}

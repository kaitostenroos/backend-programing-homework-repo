package bookstore.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kirja {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    private String title;
    private String author;
    private int year;
    private String isbn;
    private double price;

}

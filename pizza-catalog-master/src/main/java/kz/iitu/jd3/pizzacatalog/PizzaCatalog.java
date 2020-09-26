package kz.iitu.jd3.pizzacatalog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaCatalog {

    public PizzaCatalog() {
    }

    public PizzaCatalog(String title, String author, Integer rating) {
        this.title = title;
        this.author = author;
        this.rating = rating;
    }

    private String title;
    private String author;
    private Integer rating;
}

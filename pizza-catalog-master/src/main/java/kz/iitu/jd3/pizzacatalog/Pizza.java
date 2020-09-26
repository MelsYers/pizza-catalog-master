package kz.iitu.jd3.pizzacatalog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pizza {

    public Pizza() {
    }

    public Pizza(String id, String title, String author, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    private String id;
    private String title;
    private String author;
    private String description;
}

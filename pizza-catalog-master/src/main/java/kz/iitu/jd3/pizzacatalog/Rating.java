package kz.iitu.jd3.pizzacatalog;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {

    public Rating() {
    }

    public Rating(String pizzaId, Integer rating) {
        this.pizzaId = pizzaId;
        this.rating = rating;
    }

    private String pizzaId;
    private Integer rating; // 0 to 5
}

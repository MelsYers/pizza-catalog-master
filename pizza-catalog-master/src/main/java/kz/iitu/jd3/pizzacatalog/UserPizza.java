package kz.iitu.jd3.pizzacatalog;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserPizza {

    private List<Pizza> userPizza;

    public UserPizza() {
    }

    public UserPizza(List<Pizza> userPizza) {
        this.userPizza = userPizza;
    }
}

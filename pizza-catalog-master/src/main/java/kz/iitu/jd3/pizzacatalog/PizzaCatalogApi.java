package kz.iitu.jd3.pizzacatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class PizzaCatalogApi {

    @Autowired
    private PizzaInformationService pizzaInformationService;
    @Autowired
    private RatingService ratingService;

    @GetMapping("/{userId}")
    public List<PizzaCatalog> getAllPizza(
            @PathVariable String userId) {



        // get all books by userId
        UserPizza  userPizza = pizzaInformationService.getUserPizza(userId);

        List<PizzaCatalog> pizzaCatalogList = new ArrayList<>();
        for (Pizza pizza : userPizza.getUserPizza()) {
            Rating pizzaRating = ratingService.getPizzaRating(pizza.getId());

            pizzaCatalogList.add(new PizzaCatalog(pizza.getTitle(),
                    pizza.getAuthor(), pizzaRating.getRating()));
        }

        return pizzaCatalogList;
    }


}

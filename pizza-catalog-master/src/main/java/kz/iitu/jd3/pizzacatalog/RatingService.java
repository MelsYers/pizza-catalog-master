package kz.iitu.jd3.pizzacatalog;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getPizzaRatingFallback",
            threadPoolKey = "getPizzaRating",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            })
    public Rating getPizzaRating(String bookId) {
        return restTemplate.getForObject(
                "http://localhost:2020/rating/" + bookId,
                Rating.class);
    }
    public Rating getPizzaRatingFallback(String pizzaId) {
        return new Rating(pizzaId, 0);
    }
}

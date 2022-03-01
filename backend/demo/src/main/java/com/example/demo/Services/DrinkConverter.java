package com.example.demo.Services;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.demo.Model.Beer;
import com.example.demo.Model.Coffee;
import com.example.demo.Model.Drink;
import com.example.demo.Utilities.BeerDescription;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DrinkConverter {
    @Autowired
    RestTemplate restTemplate;

    private DecimalFormat rating = new DecimalFormat("0.000");
    
    Function<Coffee, Drink> coffeeToDrink = new Function<Coffee, Drink>(){
        public Drink apply(Coffee coffee){
            Drink drink = new Drink();
            drink.setKey(coffee.getDescription());
            drink.setName(coffee.getTitle());
            drink.setPrice("$" + (int)(8 + (Math.random())*19) +".99");
            drink.setRating(rating.format(Math.random()*5));
            drink.setDescription(coffee.getDescription());
            drink.setImage(getCoffeeImage());
            drink.setID(UUID.randomUUID());
            return drink;
        }
    };

    Function<Beer, Drink> beerToDrink = new Function<Beer, Drink>(){
        public Drink apply(Beer beer){
            Drink drink = new Drink();
            drink.setKey("Description");
            drink.setName(beer.getName());
            drink.setPrice(beer.getPrice());
            drink.setRating(rating.format(beer.getRating().getAverage()));
            drink.setDescription(getBeerDescription(beer.getName()));
            drink.setImage(beer.getImage());
            drink.setID(UUID.randomUUID());
            return drink;
        }
    };

    private String getCoffeeImage(){
        ResponseEntity<String> response = restTemplate.getForEntity("https://coffee.alexflipnote.dev/random.json", String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, String> map = mapper.readValue(response.getBody(), Map.class);
            return map.get("file");
        } catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }

    private String getBeerDescription(String beer){
        return BeerDescription.getDescription(Arrays.stream(BeerDescription.BEER_TYPES).filter(beer_type -> beer.toUpperCase().contains(beer_type)).collect(Collectors.toList()).get(0));
    }
}

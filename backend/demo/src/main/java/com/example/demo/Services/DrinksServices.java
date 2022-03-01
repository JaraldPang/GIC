package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.demo.Model.Beer;
import com.example.demo.Model.Coffee;
import com.example.demo.Model.Drink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DrinksServices {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired 
    DrinkConverter drinkConverter; 

    public List<Drink> getCoffees(){
        List<Drink> drinks = new ArrayList<>();
        ResponseEntity<Coffee[]> coffee_response = restTemplate.getForEntity("https://api.sampleapis.com/coffee/hot", Coffee[].class);
        for (Coffee coffee : coffee_response.getBody()){
            drinks.add(drinkConverter.coffeeToDrink.apply(coffee));
        }
        return drinks;
    }

    public List<Drink> getBeers(){
        List<Drink> drinks = new ArrayList<>();
        ResponseEntity<Beer[]> beer_response = restTemplate.getForEntity("https://api.sampleapis.com/beers/ale", Beer[].class);
        for (Beer beer: beer_response.getBody()){
            drinks.add(drinkConverter.beerToDrink.apply(beer));
        }
        return drinks;
    }

    public List<Drink> getAllDrinks(){
        List<Drink> drinks = new ArrayList<>();
        ResponseEntity<Beer[]> beer_response = restTemplate.getForEntity("https://api.sampleapis.com/beers/ale", Beer[].class);
        for (Beer beer: beer_response.getBody()){
            drinks.add(drinkConverter.beerToDrink.apply(beer));
        }
        ResponseEntity<Coffee[]> coffee_response = restTemplate.getForEntity("https://api.sampleapis.com/coffee/hot", Coffee[].class);
        for (Coffee coffee : coffee_response.getBody()){
            drinks.add(drinkConverter.coffeeToDrink.apply(coffee));
        }
        drinks.sort(Comparator.comparing(Drink::getRating).reversed());
        return drinks;
    }

}

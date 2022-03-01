package com.example.demo.Model;

import java.util.UUID;

public class Drink{
    String key;
    String name;
    String price;
    double rating;
    String description;
    String image;
    UUID id;

    public String getKey(){
        return this.key;
    }

    public String getName(){
        return this.name;
    }

    public String getPrice(){
        return this.price;
    }

    public double getRating(){
        return this.rating;
    }

    public String getDescription(){
        return this.description;
    }

    public String getImage(){
        return this.image;
    }

    public UUID getID(){
        return this.id;
    }

    public void setKey(String key){
        this.key = key;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setRating(String rating){
        double new_rating = Double.parseDouble(rating);
        this.rating = new_rating;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setImage(String image){
        this.image = image;
    }

    public void setID(UUID id){
        this.id = id;
    }

}

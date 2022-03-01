package com.example.demo.Model;

public class Beer {
    private String price;
    private String name;
    private Rating rating;
    private String image;
    private int id;

    public String getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public Rating getRating(){
        return this.rating;
    }

    public String getImage(){
        return this.image;
    }

    public int getID(){
        return this.id;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRating(Rating rating){
        this.rating = rating;
    }

    public void setID(int id){
        this.id = id;
    }
}

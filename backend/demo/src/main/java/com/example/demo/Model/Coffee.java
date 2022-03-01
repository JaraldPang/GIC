package com.example.demo.Model;

public class Coffee {
    private String title;
    private String description;
    private String[] ingredients;
    private int id;

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public String[] getIngredients(){
        return this.ingredients;
    }

    public int getID(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setIngredients(String[] ingredients){
        this.ingredients = ingredients;
    }

    public void setID(int id){
        this.id = id;
    }
}

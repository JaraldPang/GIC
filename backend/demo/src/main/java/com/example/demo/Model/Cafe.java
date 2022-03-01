package com.example.demo.Model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cafes")
public class Cafe {
    String key;
    String name;
    int employees;
    String logo;
    String location;
    @Id
    UUID id = UUID.randomUUID();

    public String getKey(){
        return this.key;
    }

    public String getName(){
        return this.name;
    }

    public int getEmployees(){
        return this.employees;
    }

    public String getLogo(){
        return this.logo;
    }

    public String getLocation(){
        return this.location;
    }

    public UUID getID(){
        return this.id;
    }

    public void setID(UUID id){
        this.id = id;
    }
}

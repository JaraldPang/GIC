package com.example.demo.Model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {
    String key;
    String name;
    int daysWorked;
    String cafe;
    @Id
    UUID id = UUID.randomUUID();

    public String getKey(){
        return this.key;
    }

    public String getName(){
        return this.name;
    }

    public int getDaysWorked(){
        return this.daysWorked;
    }

    public String getCafe(){
        return this.cafe;
    }

    public UUID getID(){
        return this.id;
    }
}

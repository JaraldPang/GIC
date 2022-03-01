package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Model.Drink;
import com.example.demo.Services.DrinksServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
public class DrinksController {
    @Autowired
    private DrinksServices drinksServices;

    @GetMapping("/drinks")
    public ResponseEntity<List<Drink>> getDrinks(@RequestParam String type){
        switch(type){
            case "coffee":
                return ResponseEntity.ok(drinksServices.getCoffees());
            case "beer":
                return ResponseEntity.ok(drinksServices.getBeers());
            case "":
                return ResponseEntity.ok(drinksServices.getAllDrinks());
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}

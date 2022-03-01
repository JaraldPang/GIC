package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Model.Cafe;
import com.example.demo.Services.CafeServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class CafeController {
    @Autowired
    private CafeServices cafeServices;

    @GetMapping("/cafes")
    public ResponseEntity<List<Cafe>> getCafes(@RequestParam String location){
        return ResponseEntity.ok(cafeServices.getCafes(location));
    }

    @PostMapping("cafe")
    public void addCafe(@RequestBody Cafe cafe){
        cafeServices.addCafe(cafe);
    }

    @GetMapping("/cafes/test")
    public ResponseEntity<List<Cafe>> getAllCafes(){
        return ResponseEntity.ok(cafeServices.getAllCafes());
    }
}

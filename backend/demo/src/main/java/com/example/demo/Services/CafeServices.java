package com.example.demo.Services;

import java.util.List;

import com.example.demo.Model.Cafe;
import com.example.demo.Repositories.CafeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CafeServices {
    @Autowired
    private CafeRepo cafeRepo;

    public List<Cafe> getAllCafes(){
        return cafeRepo.findAll();
    }
    
    public List<Cafe> getCafes(String location){
        List<Cafe> cafes = cafeRepo.findByLocation(location);
        return cafes;
    }
    public void addCafe(Cafe cafe){
        Cafe current = cafeRepo.findByName(cafe.getName());
        if (current != null){
            cafeRepo.deleteByName(current.getName());
        }
        cafeRepo.save(cafe);
    }
}

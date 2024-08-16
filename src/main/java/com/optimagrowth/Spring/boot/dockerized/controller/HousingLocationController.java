package com.optimagrowth.Spring.boot.dockerized.controller;

import com.optimagrowth.Spring.boot.dockerized.entity.HousingLocation;
import com.optimagrowth.Spring.boot.dockerized.service.HousingLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/housing")
public class HousingLocationController {
    @Autowired
    private HousingLocationService housingLocationService;

    @GetMapping
    public ResponseEntity<List<HousingLocation>> findAllHousing(){
        return ResponseEntity.ok(housingLocationService.findAllHousing());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HousingLocation> findByIdHousing(@PathVariable("id") Long id){
        return ResponseEntity.ok(housingLocationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HousingLocation> saveHousing(@RequestBody HousingLocation housingLocation){
        ;
        return ResponseEntity.ok(housingLocationService.saveHousingLocation(housingLocation));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHousingLocation(@PathVariable("id") Long id){
        housingLocationService.deletedHousingLocation(id);
        return ResponseEntity.accepted().build();
    }
}

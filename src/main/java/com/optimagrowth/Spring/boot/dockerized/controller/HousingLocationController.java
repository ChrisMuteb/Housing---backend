package com.optimagrowth.Spring.boot.dockerized.controller;

import com.optimagrowth.Spring.boot.dockerized.dto.HousingLocationRequest;
import com.optimagrowth.Spring.boot.dockerized.dto.HousingLocationResponse;
import com.optimagrowth.Spring.boot.dockerized.entity.HousingLocation;
import com.optimagrowth.Spring.boot.dockerized.mapper.HousingLocationMapper;
import com.optimagrowth.Spring.boot.dockerized.service.HousingLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/housing")
public class HousingLocationController {
    @Autowired
    private HousingLocationService housingLocationService;

    @GetMapping
    public ResponseEntity<List<HousingLocationResponse>> findAllHousing(){

        return ResponseEntity.ok(housingLocationService.findAllHousing());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HousingLocationResponse> findByIdHousing(@PathVariable("id") Long id){
        return ResponseEntity.ok(housingLocationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HousingLocationResponse> saveHousing(@RequestBody HousingLocationRequest housingLocationRequest){
        ;
        return ResponseEntity.ok(housingLocationService.saveHousingLocation(housingLocationRequest));
    }

    @PutMapping
    public ResponseEntity<HousingLocationResponse> updateHouseLocation(
            @RequestBody HousingLocationRequest request
    ){
        housingLocationService.updateHousingLocation(request);
        return ResponseEntity.accepted().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHousingLocation(@PathVariable("id") Long id){
        housingLocationService.deletedHousingLocation(id);
        return ResponseEntity.accepted().build();
    }
}

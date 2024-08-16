package com.optimagrowth.Spring.boot.dockerized.service;

import com.optimagrowth.Spring.boot.dockerized.Exception.HousingLocationNotFound;
import com.optimagrowth.Spring.boot.dockerized.entity.HousingLocation;
import com.optimagrowth.Spring.boot.dockerized.repository.HousingLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class HousingLocationService {
    @Autowired
    private HousingLocationRepository housingLocationRepository;

    public List<HousingLocation> findAllHousing(){
        return housingLocationRepository.findAll();
    }

    public HousingLocation findById(Long id){
        return housingLocationRepository.findById(id).orElseThrow(() -> new HousingLocationNotFound(format("Housing Location not found", id)));
    }

    public HousingLocation saveHousingLocation(HousingLocation housingLocation){
        return housingLocationRepository.save(housingLocation);
    }
    // update existing record

    public void deletedHousingLocation(Long id){
        housingLocationRepository.deleteById(id);
//        return "House location deleted";
    }
}

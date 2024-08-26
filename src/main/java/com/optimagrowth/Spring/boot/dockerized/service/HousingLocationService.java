package com.optimagrowth.Spring.boot.dockerized.service;

import com.optimagrowth.Spring.boot.dockerized.Exception.HousingLocationNotFound;
import com.optimagrowth.Spring.boot.dockerized.dto.HousingLocationRequest;
import com.optimagrowth.Spring.boot.dockerized.dto.HousingLocationResponse;
import com.optimagrowth.Spring.boot.dockerized.entity.HousingLocation;
import com.optimagrowth.Spring.boot.dockerized.mapper.HousingLocationMapper;
import com.optimagrowth.Spring.boot.dockerized.repository.HousingLocationRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.apache.commons.lang.StringUtils;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class HousingLocationService {
    @Autowired
    private HousingLocationRepository housingLocationRepository;
    @Autowired
    private HousingLocationMapper housingLocationMapper;

    public List<HousingLocationResponse> findAllHousing(){
        return housingLocationRepository.findAll()
                .stream()
                .map(housingLocationMapper::fromHousingLocation)
                .collect(Collectors.toList());
    }

    public HousingLocationResponse findById(Long id){
        HousingLocation housingLocation = housingLocationRepository.findById(id)
                .orElseThrow(() -> new HousingLocationNotFound(format("Housing Location not found", id)));
        return housingLocationMapper.fromHousingLocation(housingLocation);
    }

    public HousingLocationResponse saveHousingLocation(HousingLocationRequest housingLocationRequest){
        var houseLoactionv = housingLocationRepository
                .save(housingLocationMapper.toHouseLocation(housingLocationRequest));
        return housingLocationMapper.fromHousingLocation(houseLoactionv);
    }
    // update existing record

    public void deletedHousingLocation(Long id){
        housingLocationRepository.deleteById(id);
//        return "House location deleted";
    }

    public void updateHousingLocation(HousingLocationRequest request) {
        var housingLocation = housingLocationRepository.findById(request.id())
                .orElseThrow(() -> new HousingLocationNotFound(
                        format("Cannot update housingLocation:: No customer found with the provided ID:: %s", request.id())
                ));
        mergeHousingLocation(housingLocation, request);
        housingLocationRepository.save(housingLocation);
    }

    private void mergeHousingLocation(HousingLocation housingLocation, HousingLocationRequest request) {
        if(StringUtils.isNotBlank(request.name())){
            housingLocation.setName(request.name());
        }
        if(StringUtils.isNotBlank(request.city())){
            housingLocation.setCity(request.city());
        }
        if(StringUtils.isNotBlank(request.state())){
            housingLocation.setState(request.state());
        }
        if(StringUtils.isNotBlank(request.photo())){
            housingLocation.setPhoto(request.photo());
        }
        if(request.availableUnits() != null){
            housingLocation.setAvailableUnits(request.availableUnits());
        }
        if(request.wifi() != null){
            housingLocation.setWifi(request.wifi());
        }
        if(request.laundry() != null){
            housingLocation.setLaundry(request.laundry());
        }
    }
}
